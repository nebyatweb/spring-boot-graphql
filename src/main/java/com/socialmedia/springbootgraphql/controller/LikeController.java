package com.socialmedia.springbootgraphql.controller;

import com.socialmedia.springbootgraphql.domain.Like;
import com.socialmedia.springbootgraphql.service.LikeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


}
