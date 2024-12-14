package com.dimas.blog.Controllers;

import com.dimas.blog.Service.ImgbbService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class PostController {

    @Autowired
    private ImgbbService imgbbService; // Suponiendo que tienes un servicio para subir a imgbb

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
