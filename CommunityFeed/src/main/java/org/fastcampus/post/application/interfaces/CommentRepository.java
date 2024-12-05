package org.fastcampus.post.application.interfaces;

import java.util.Optional;
import org.fastcampus.comment.Comment;

public interface CommentRepository {
    Comment save(Comment comment);

    Optional<Comment> findById(Long id);
}
