package com.socialmedia.springbootgraphql.service.impl;

import com.socialmedia.springbootgraphql.domain.Like;
import com.socialmedia.springbootgraphql.exception.LikeNotFoundException;
import com.socialmedia.springbootgraphql.repository.LikeRepository;
import com.socialmedia.springbootgraphql.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void removeLike(long likeId) {
        if(likeRepository.findById(likeId).isPresent())
            likeRepository.deleteById(likeId);
        else
            throw new RuntimeException("Cannot find like with id " + likeId);
    }

    @Override
    public Like getLikeById(long likeId) {
        if(likeRepository.findById(likeId).isPresent())
            return likeRepository.findById(likeId).get();
        else
            throw new LikeNotFoundException("Post with postId "+likeId+" does not exist!");
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }
}
