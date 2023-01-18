package edu.miu.waaassignment1.repo;

import edu.miu.waaassignment1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();
    public Post findById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
    public List<Post> findPostByAuthor(String author);

}
