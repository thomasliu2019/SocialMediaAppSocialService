package com.example.socialProfile.entity;

import java.io.Serializable;
import java.util.Objects;

public class LikeId implements Serializable {

    private Long postId;
    private Long userId;

    // Required by JPA
    public LikeId() {}

    public LikeId(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikeId)) return false;
        LikeId that = (LikeId) o;
        return Objects.equals(postId, that.postId) &&
               Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId);
    }
}

