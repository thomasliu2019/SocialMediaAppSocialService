package com.example.socialProfile.service;

import org.springframework.stereotype.Service;

import com.example.socialProfile.entity.Like;
import com.example.socialProfile.entity.LikeId;
import com.example.socialProfile.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeService {

    private LikeRepository likeRepository;
    
    public void likePost(Long userId, Long postId) {
        if (likeRepository.existsByPostIdAndUserId(postId, userId)) {
            throw new IllegalStateException("Already liked");
        }

        likeRepository.save(new Like(postId, userId));
    }

    public void unlikePost(Long userId, Long postId) {
        LikeId id = new LikeId(postId, userId);
        likeRepository.deleteById(id);
    }

    public long getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}

