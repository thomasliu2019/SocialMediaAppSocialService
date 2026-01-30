package com.example.socialProfile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialProfile.service.LikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class LikeController {

    private LikeService likeService;

    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> like( @PathVariable Long postId, @RequestHeader("X-User-Id") Long userId) {
        likeService.likePost(userId, postId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}/like")
    public ResponseEntity<Void> unlike(@PathVariable Long postId, @RequestHeader("X-User-Id") Long userId) {
        likeService.unlikePost(userId, postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{postId}/likes/count")
    public long count(@PathVariable Long postId) {
        return likeService.getLikeCount(postId);
    }
}

