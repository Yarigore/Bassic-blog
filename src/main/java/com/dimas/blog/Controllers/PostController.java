package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Post;
import com.dimas.blog.Service.ImgbbService;
import com.dimas.blog.Service.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private ImgbbService imgbbService;

    @Autowired
    public PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Post> createPost(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("authorId") Long authorId,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("tagIds") List<Long> tagIds) throws IOException {

        Post post = postService.createPost(file, title, content, authorId, categoryId, tagIds);
        return ResponseEntity.ok(post);
    }


    @DeleteMapping
    public ResponseEntity<Post> deletePost(@RequestParam Post post){
        return ResponseEntity.ok(postService.deletePost(post));
    }

    @Operation(summary = "Subir una imagen", description = "Endpoint para cargar una imagen al servidor.")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(
            @Parameter(description = "Archivo a subir", required = true)
            @RequestParam("file") MultipartFile file) throws IOException {

        // Procesar el archivo
        String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
        String response = imgbbService.uploadImage(base64Image);

        // Extraemos la URL
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        String imageUrl = jsonNode.get("data").get("url").asText();

        System.out.println(imageUrl);

        return ResponseEntity.ok("Archivo subido con éxito. Respuesta: " + response);
    }

}
