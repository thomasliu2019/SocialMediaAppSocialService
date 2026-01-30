package com.example.socialProfile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialProfile.client.dto.PostResponse;
import com.example.socialProfile.service.FeedService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private FeedService feedService;

    @GetMapping("/feed")
    public List<PostResponse> feed(@RequestHeader("X-User-Id") Long userId) {
        return feedService.getFeed(userId);
    }
}

