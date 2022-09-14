package com.socialmedia.springbootgraphql.controller;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.domain.User;
import com.socialmedia.springbootgraphql.resolver.CreatePostInput;
import com.socialmedia.springbootgraphql.service.PostService;
import com.socialmedia.springbootgraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private UserService userService;
    private PostService postService;

    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @MutationMapping
    public Post createPost(@Argument CreatePostInput input, @Argument long userId) {
        User user = userService.getUserById(userId);
        Post post = postService.createPost(new Post(
                input.getPostId(),
                input.getBody(),
                user.getUsername(),
                input.getCreatedAt(),
                new ArrayList<>()
        ));
        user.addPost(post);
        userService.updateUser(user, user.getUserId());
        return post;
    }

    @QueryMapping
    public List<Post> allPosts() {
        return postService.getAllPosts();
    }

    @QueryMapping
    public Post postById(@Argument long postId) {
        return postService.getPostById(postId);
    }

    @SchemaMapping(typeName = "Post")
    public List<Comment> comments(Post post) {
        return postService.getComments(post.getPostId());
    }
}
