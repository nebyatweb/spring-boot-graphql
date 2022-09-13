package com.socialmedia.springbootgraphql.repository;

import com.socialmedia.springbootgraphql.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
