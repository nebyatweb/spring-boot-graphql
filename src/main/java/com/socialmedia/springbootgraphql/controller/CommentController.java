package com.socialmedia.springbootgraphql.controller;

import com.socialmedia.springbootgraphql.service.CommentService;
import com.socialmedia.springbootgraphql.service.PostService;
import com.socialmedia.springbootgraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    private CommentService commentService;
    private PostService postService;
    private UserService userService;

    public CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }


}
