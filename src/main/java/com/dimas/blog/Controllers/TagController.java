package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Tag;
import com.dimas.blog.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getTags() {
        return ResponseEntity.ok(tagService.getTags());
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.createTag(tag));
    }

    @DeleteMapping
    public ResponseEntity<Tag> deleteTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.deleteTag(tag));
    }


}
