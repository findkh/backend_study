package org.fastcampus.post.application.interfaces;

import org.fastcampus.comment.Comment;

public interface CommentRepository {
    Comment save(Comment comment);

    Comment findById(Long id);
}
