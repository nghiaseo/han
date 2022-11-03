package com.han.webservice.Controller;

import com.han.webservice.Entity.Post;
import com.han.webservice.Exception.PostNotFoundException;
import com.han.webservice.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRepo postRepo;
    PostController(PostRepo postRepo){
        this.postRepo = postRepo;
    }
    @GetMapping("/posts")
    List<Post> allPosts(){
        return postRepo.findAll();
    }
    @GetMapping("/posts/{id}")
    Post singlePost(@PathVariable Long id){
        return postRepo.findById(id).orElseThrow(()-> new PostNotFoundException(id));
    }
    @PostMapping("/posts")
    Post newPost(@RequestBody Post newPost){
        return postRepo.save(newPost);
    }
}
