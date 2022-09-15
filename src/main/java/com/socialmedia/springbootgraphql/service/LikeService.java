package com.socialmedia.springbootgraphql.service;

import com.socialmedia.springbootgraphql.domain.Like;

import java.util.List;

public interface LikeService {
    Like createLike(Like like);
    void removeLike(long likeId);
    Like getLikeById(long likeId);
    List<Like> getAllLikes();
}
