package com.example.socialProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialProfile.entity.Like;
import com.example.socialProfile.entity.LikeId;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

    long countByPostId(Long postId);

    boolean existsByPostIdAndUserId(Long postId, Long userId);
}

