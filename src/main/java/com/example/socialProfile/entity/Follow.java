package com.example.socialProfile.entity;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(FollowId.class)
@Table(name = "follows")
public class Follow {

    @Id
    private Long followerId;

    @Id
    private Long followeeId;

    private LocalDateTime createdAt;
    
    public Follow() {
    }
    
    public Follow(Long followerId, Long followeeId) {
    	this.followerId = followerId;
    	this.followeeId = followeeId;
    	this.createdAt = LocalDateTime.now();
    }
    
    public Long getFollowerId() {
    	return followerId;
    }
    
    public void setFollowerId(Long followerId) {
    	this.followerId = followerId;
    }
    
    public Long getFolloweeId() {
    	return followeeId;
    }
    
    public void setFolloweeId(Long followeeId) {
    	this.followeeId = followeeId;
    }
    
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt;
    }
}
