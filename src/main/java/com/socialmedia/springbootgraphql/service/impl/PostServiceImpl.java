package com.socialmedia.springbootgraphql.service.impl;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.exception.PostNotFoundException;
import com.socialmedia.springbootgraphql.repository.CommentRepository;
import com.socialmedia.springbootgraphql.repository.PostRepository;
import com.socialmedia.springbootgraphql.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void updatePost(Post post, long postId) {
        if(postRepository.findById(postId).isPresent()){
            post.setPostId(postId);
            postRepository.save(post);
        }
        else throw new PostNotFoundException("Post with postId "+postId+" does not exist!");
    }

    @Override
    public void removePost(long postId) {
        if (postRepository.existsById(postId))
            postRepository.deleteById(postId);
        else throw new PostNotFoundException("Post with postId "+postId+" does not exist!");
    }

    @Override
    public Post getPostById(long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Comment> getComments(long postId) {
        return postRepository.findById(postId).get().getComments();
    }
}
