package com.example.socialProfile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.socialProfile.client.PostClient;
import com.example.socialProfile.client.dto.PostResponse;
import com.example.socialProfile.repository.FollowRepository;

import com.example.socialProfile.entity.Follow;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedService {

    private FollowRepository followRepository;
    private PostClient postClient;

    public List<PostResponse> getFeed(Long userId) {

        List<Long> followees = followRepository.findByFollowerId(userId)
                .stream()
                .map(Follow::getFolloweeId)
                .toList();

        if (followees.isEmpty()) {
            return List.of();
        }

        return postClient.getPostsByAuthors(followees);
    }
}

