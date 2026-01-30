package com.example.socialProfile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.socialProfile.entity.Follow;
import com.example.socialProfile.entity.FollowId;
import com.example.socialProfile.repository.FollowRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowService {

    private FollowRepository followRepository;

    public void follow(Long me, Long target) {
        if (me.equals(target)) {
            throw new IllegalArgumentException("Cannot follow yourself");
        }

        if (followRepository.existsByFollowerIdAndFolloweeId(me, target)) {
            return;
        }

        followRepository.save(new Follow(me, target));
    }

    public void unfollow(Long me, Long target) {
        followRepository.deleteById(new FollowId(me, target));
    }

    public List<Long> getFollowers(Long userId) {
        return followRepository.findByFolloweeId(userId)
                .stream()
                .map(Follow::getFollowerId)
                .toList();
    }

    public List<Long> getFollowing(Long userId) {
        return followRepository.findByFollowerId(userId)
                .stream()
                .map(Follow::getFolloweeId)
                .toList();
    }
}

