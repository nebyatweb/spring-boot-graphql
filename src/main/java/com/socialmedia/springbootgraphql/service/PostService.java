package com.socialmedia.springbootgraphql.service;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    void updatePost(Post post, long postId);
    Post getPostById(long postId);
    List<Post> getAllPosts();
    List<Comment> getComments(long postId);
}
