package edu.miu.waaassignment1.service.postServiceImp;

import edu.miu.waaassignment1.entity.Post;
import edu.miu.waaassignment1.entity.dto.PostDto;
import edu.miu.waaassignment1.helper.ListMapper;
import edu.miu.waaassignment1.repo.PostRepo;
import edu.miu.waaassignment1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImp implements PostService {
    @Autowired
    private  PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired

    ListMapper<Post, PostDto> postPostDtoListMapper;


    @Override
    public List<Post> findAllPost() {
        return postRepo.findAll();
    }

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) postPostDtoListMapper.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(Post post) {
       postRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, PostDto p) {
       postRepo.update(id, modelMapper.map(p,Post.class));
    }

    @Override
    public List<Post> findPostByAuthor(String author) {
        return postRepo.findPostByAuthor(author);
    }
}
