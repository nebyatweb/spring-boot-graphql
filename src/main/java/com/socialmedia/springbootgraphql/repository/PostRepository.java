package com.socialmedia.springbootgraphql.repository;

import com.socialmedia.springbootgraphql.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
