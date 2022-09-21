package com.socialmedia.springbootgraphql.controller;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.domain.User;
import com.socialmedia.springbootgraphql.resolver.CreateCommentInput;
import com.socialmedia.springbootgraphql.service.CommentService;
import com.socialmedia.springbootgraphql.service.PostService;
import com.socialmedia.springbootgraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

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

    @MutationMapping
    public Comment createComment(@Argument CreateCommentInput input, @Argument long postId, @Argument long userId) {
        Post post = postService.getPostById(postId);
        User user = userService.getUserById(userId);
        Comment comment = commentService.createComment(new Comment(
                input.getCommentId(),
                input.getBody(),
                user.getUsername(),
                input.getCreatedAt(),
                new ArrayList<>()
        ));
        post.addComment(comment);
        postService.updatePost(post, postId);
        return comment;
    }

    @QueryMapping
    public List<Comment> allComments() {
        return commentService.getAllComments();
    }

    @QueryMapping
    public Comment


}
