package com.example.socialProfile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(LikeId.class)
@Table(name = "likes")
public class Like {

    @Id
    private Long postId;

    @Id
    private Long userId;

    private LocalDateTime createdAt;
    
    public Like() {
    }
    
    public Like(Long postId, Long userId) {
    	this.postId = postId;
    	this.userId =  userId;
    	this.createdAt = LocalDateTime.now();
    }
    
    public Long getPostId() {
    	return postId;
    }
    
    public void setPostId(Long postId) {
    	this.postId = postId;
    }
    
    public Long getUserId() {
    	return userId;
    }
    
    public void setUserId(Long userId) {
    	this.userId = userId;
    }
    
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt;
    }
}

