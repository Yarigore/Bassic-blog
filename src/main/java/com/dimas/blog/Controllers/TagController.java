package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Tag;
import com.dimas.blog.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getTags() {
        return tagService.getTags()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        return tagService.saveTag(tag)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        Optional<Tag> tagToChange = tagService.getTagById(id);

        if (tagToChange.isPresent()) {
            Tag existingTag = tagToChange.get();

            if (tag.getName() != null) {
                existingTag.setName(tag.getName());
            }

            Optional<Tag> updatedTag = tagService.saveTag(existingTag);

            return updatedTag
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(500).build());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Tag> deleteTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.deleteTag(tag));
    }


}
