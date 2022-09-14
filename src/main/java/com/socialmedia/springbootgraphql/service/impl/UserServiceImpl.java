package com.socialmedia.springbootgraphql.service.impl;

import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.domain.User;
import com.socialmedia.springbootgraphql.exception.UserNotFoundException;
import com.socialmedia.springbootgraphql.repository.UserRepository;
import com.socialmedia.springbootgraphql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user, long userId) {
        if(userRepository.findById(userId).isPresent()){
            user.setUserId(userId);
            userRepository.save(user);
        }
        else throw new UserNotFoundException("User with userId "+userId+" does not exist!");
    }

    @Override
    public User getUserById(long userId) {
        try {
            return userRepository.findById(userId).get();
        } catch (Exception e) {
            throw new UserNotFoundException("User with userId "+userId+" does not exist!");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Post> getPosts(long userId) {
        return userRepository.findById(userId).get().getPosts();
    }


}
