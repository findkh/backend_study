package org.fastcampus.post.repository.jpa.post_queue;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.repository.entity.post.PostEntity;

public interface UserPostQueueCommandRepository {
    void publishPost(PostEntity postEntity);

    void saveFollowPost(Long userId, Long targetId);

    void deleteUnfollowPost(Long userId, Long targetId);
}
