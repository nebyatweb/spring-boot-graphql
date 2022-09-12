package com.socialmedia.springbootgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInput {
    private long userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
}
