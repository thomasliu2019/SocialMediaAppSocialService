package com.example.socialProfile.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialProfile.service.FollowService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class FollowController {

    private FollowService followService;

    @PostMapping("/{userId}/follow")
    public ResponseEntity<Void> follow(@PathVariable Long userId, @RequestHeader("X-User-Id") Long me) {
        followService.follow(me, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/follow")
    public ResponseEntity<Void> unfollow(@PathVariable Long userId,@RequestHeader("X-User-Id") Long me) {
        followService.unfollow(me, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/followers")
    public List<Long> followers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }

    @GetMapping("/{userId}/following")
    public List<Long> following(@PathVariable Long userId) {
        return followService.getFollowing(userId);
    }
}

