package edu.miu.waaassignment1.controller;

import edu.miu.waaassignment1.entity.Post;
import edu.miu.waaassignment1.entity.dto.PostDto;
import edu.miu.waaassignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

   private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping

    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")

    public PostDto findById(@PathVariable long id){
        return postService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable long id, @RequestBody PostDto postDto){
        postService.update(id, postDto);
    }

    @GetMapping(value =
            {
                    "/handlingMultipleEndpoints",
                    "/handlingMultipleEndpoints/{id}"
            })
    public String multipleEndpointsDemo(@PathVariable(required = false) String author) {
        if (author != null) {
            return "AUTHOR: " + author;
        } else {
            return "ID missing";
        }
    }

    // FOR DEMO PURPOSES
    @GetMapping("/h/{id}")
    public EntityModel<PostDto> getByIdH(@PathVariable int id) {

        PostDto post = postService.getById(id);
        EntityModel<PostDto> resource = EntityModel.of(post);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-posts"));

        return resource;
    }

}
