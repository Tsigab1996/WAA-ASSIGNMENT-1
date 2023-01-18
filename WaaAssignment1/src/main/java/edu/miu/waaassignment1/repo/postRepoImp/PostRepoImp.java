package edu.miu.waaassignment1.repo.postRepoImp;

import edu.miu.waaassignment1.entity.Post;
import edu.miu.waaassignment1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImp implements PostRepo {

    private static List<Post>posts;
    static {
        posts= new ArrayList<>();
        Post p1= new Post(1, "Java Code", "How to code java", "James");
        Post p2= new Post(2, "Maven Structure", "Retrieving Dependencies", "John");
        Post p3= new Post(3, "Spring Boot", "Spring Boot Principle", "Dean");
        Post p4= new Post(4, "WAA", "What is exactly WAA", "Tsigab");
        Post p5= new Post(5, "POJOS", "What are POJOS", "Sami");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
        posts.add(p5);

    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(p->p.getId()==id).findFirst().get();
    }

    @Override
    public void save(Post post) {
      posts.add(post);
    }

    @Override
    public void delete(long id) {
      posts.removeIf(p->p.getId()==id);
    }

    @Override
    public void update(long id, Post post) {
        for(int i=0; i<posts.size(); i++){
            Post p= posts.get(i);
            if(p.getId()==id){
                posts.set(i, post);
            }
        }
    }

    @Override
    public List<Post> findPostByAuthor(String author) {
        return posts.stream().filter(p->p.getAuthor().equals(author)).collect(Collectors.toList());
    }
}
