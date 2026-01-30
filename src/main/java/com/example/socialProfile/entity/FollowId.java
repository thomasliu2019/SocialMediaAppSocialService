package com.example.socialProfile.entity;

import java.io.Serializable;
import java.util.Objects;

public class FollowId implements Serializable {

    private Long followerId;
    private Long followeeId;

    // Required by JPA
    public FollowId() {}

    public FollowId(Long followerId, Long followeeId) {
        this.followerId = followerId;
        this.followeeId = followeeId;
    }

    // MUST override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FollowId)) return false;
        FollowId that = (FollowId) o;
        return Objects.equals(followerId, that.followerId) &&
               Objects.equals(followeeId, that.followeeId);
    }

    // MUST override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(followerId, followeeId);
    }
}

