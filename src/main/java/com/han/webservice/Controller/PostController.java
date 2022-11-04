package com.han.webservice.Controller;

import com.han.webservice.Entity.Post;
import com.han.webservice.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity singlePost(@PathVariable Long id){
        Optional<Post> post = this.postRepo.findById(id);
        if(post.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(post);
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with id "+id+" not found !");
        }
    }
    @PostMapping("/posts")
    Post newPost(@RequestBody Post newPost){
        return postRepo.save(newPost);
    }
    @PutMapping("/posts")
    public ResponseEntity updatePost(@RequestBody Post editPost){
        Optional<Post> post = this.postRepo.findById(editPost.getId());
        if(post.isPresent()){
             return ResponseEntity.status(HttpStatus.OK).body(postRepo.save(editPost));
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with id "+editPost.getId()+" not found !");
        }
    }

}
