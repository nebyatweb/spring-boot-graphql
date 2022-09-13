package com.socialmedia.springbootgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostInput {
    private long postId;
    private String body;
    private LocalDate createdAt;
}
