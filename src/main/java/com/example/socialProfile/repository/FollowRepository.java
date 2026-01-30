package com.example.socialProfile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialProfile.entity.Follow;
import com.example.socialProfile.entity.FollowId;

public interface FollowRepository extends JpaRepository<Follow, FollowId> {

    List<Follow> findByFollowerId(Long followerId);

    List<Follow> findByFolloweeId(Long followeeId);

    boolean existsByFollowerIdAndFolloweeId(Long followerId, Long followeeId);
}

