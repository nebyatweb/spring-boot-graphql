package com.socialmedia.springbootgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    private long likeId;
    private String username;
    private LocalDateTime createdAt;
}
