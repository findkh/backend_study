package org.fastcampus.post.application.interfaces;

import org.fastcampus.comment.Comment;
import org.fastcampus.post.domain.Post;
import org.fastcampus.user.domain.User;

public interface LikeRepository {
    boolean checkLike(Post post, User user);
    boolean checkLike(Comment comment, User user);
    void like(Post post, User user);
    void like(Comment comment,User user);
    void unLike(Post post, User user);
    void unLike(Comment comment, User user);
}
