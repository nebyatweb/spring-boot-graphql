package com.socialmedia.springbootgraphql.service.impl;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Like;
import com.socialmedia.springbootgraphql.repository.CommentRepository;
import com.socialmedia.springbootgraphql.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        return null;
    }

    @Override
    public void updateComment(Comment comment, long commentId) {

    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public List<Like> getLikes(long commentId) {
        return null;
    }
}
