package com.socialmedia.springbootgraphql.service.impl;

import com.socialmedia.springbootgraphql.domain.Comment;
import com.socialmedia.springbootgraphql.domain.Like;
import com.socialmedia.springbootgraphql.exception.CommentNotFoundException;
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
        return commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment, long commentId) {
        if(commentRepository.findById(commentId).isPresent()){
            comment.setCommentId(commentId);
            commentRepository.save(comment);
        } else throw new CommentNotFoundException("Comment with commentId "+commentId+" does not exist!");
    }

    @Override
    public void removeComment(long commentId) {
        if(commentRepository.existsById(commentId))
            commentRepository.deleteById(commentId);
        else throw new CommentNotFoundException("Comment with postId "+commentId+" does not exist!");
    }

    @Override
    public Comment getCommentById(long commentId) {
        if(commentRepository.existsById(commentId))
            return commentRepository.findById(commentId).get();
        else throw new CommentNotFoundException("Comment with postId "+commentId+" cannot be found!");
    }


    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Like> getLikes(long commentId) {
        return commentRepository.findById(commentId).get().getLikes();
    }
}
