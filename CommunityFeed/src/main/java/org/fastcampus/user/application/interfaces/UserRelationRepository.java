package org.fastcampus.user.application.interfaces;

import org.fastcampus.user.domain.User;

public interface UserRelationRepository {
    boolean isAlreadyFollow(User userId, User followerId);
    void save(User user, User follower);
    void delete(User user, User targetUser);
}
