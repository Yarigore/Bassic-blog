package com.dimas.blog.Service;

import com.dimas.blog.Entities.Tag;
import com.dimas.blog.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Optional<Tag> getTagById(Long id){
        return tagRepository.findById(id);
    }

    public Optional<List<Tag>> getTags(){
        return Optional.of(tagRepository.findAll());
    }

    public Optional<Tag> saveTag(Tag tag){
        return Optional.of(tagRepository.save(tag));
    }

    public Tag deleteTag(Tag tag){
        tagRepository.delete(tag);
        return tag;
    }

}
