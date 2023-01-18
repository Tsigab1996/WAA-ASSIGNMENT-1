package edu.miu.waaassignment1.service;

import edu.miu.waaassignment1.entity.Post;
import edu.miu.waaassignment1.entity.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<Post> findAllPost();
    public List<PostDto> findAll();

    PostDto getById(long id);

    void save(Post post);

    void delete(long id);

    void update(long id, PostDto p);
    public List<Post> findPostByAuthor(String author);

}
