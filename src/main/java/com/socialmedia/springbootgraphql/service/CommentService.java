package com.socialmedia.springbootgraphql.service;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Like;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    void updateComment(Comment comment, long commentId);
    void removeComment(long commentId);
    List<Comment> getAllComments();
    List<Like> getLikes(long commentId);
}
