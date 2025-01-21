package org.fastcampus.post.repository.jpa.post_queue;

import java.util.List;
import org.fastcampus.post.repository.entity.post.UserPostQueueEntity;
import org.fastcampus.post.ui.dto.GetPostContentResponseDto;

public interface UserPostQueueQueryRepository {
    List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastPostId);
}
