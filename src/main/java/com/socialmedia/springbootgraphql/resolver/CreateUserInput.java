package com.socialmedia.springbootgraphql.resolver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInput {
    private long userId;
    private String username;
    private String password;
    private String email;
    private LocalDate createdAt;
}
