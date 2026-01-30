package com.example.socialProfile.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.socialProfile.client.dto.PostResponse;
import com.example.socialProfile.config.FeignConfig;

@FeignClient(name = "post-service", url = "${services.post.url}", configuration = FeignConfig.class)
public interface PostClient {

    @PostMapping("/posts/batch")
    List<PostResponse> getPostsByAuthors(@RequestBody List<Long> authorIds);
}

