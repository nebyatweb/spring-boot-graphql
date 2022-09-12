package com.socialmedia.springbootgraphql.repository;

import com.socialmedia.springbootgraphql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<User, Long> {

}
