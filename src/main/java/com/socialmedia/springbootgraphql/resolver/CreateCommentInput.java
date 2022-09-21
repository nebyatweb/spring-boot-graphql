package com.socialmedia.springbootgraphql.resolver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentInput {
    private long commentId;
    private String body;
    private LocalDate createdAt;
}
