package com.socialmedia.springbootgraphql.repository;

import com.socialmedia.springbootgraphql.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
