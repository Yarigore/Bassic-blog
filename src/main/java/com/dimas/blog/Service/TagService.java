package com.dimas.blog.Service;

import com.dimas.blog.Entities.Tag;
import com.dimas.blog.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getTags(){
        return tagRepository.findAll();
    }

    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

    public Tag deleteTag(Tag tag){
        tagRepository.delete(tag);
        return tag;
    }

}
