package org.fastcampus.post.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.fastcampus.comment.Comment;
import org.fastcampus.post.application.interfaces.LikeRepository;
import org.fastcampus.post.domain.Post;
import org.fastcampus.user.domain.User;

public class FakeLikeRepository implements LikeRepository {

    private final Map<Post, Set<User>> postLikes = new HashMap<>();
    private final Map<Comment, Set<User>> commentLikes = new HashMap<>();

    @Override
    public boolean checkLike(Post post, User user) {
        Set<User> users = postLikes.get(post);
        return users != null && users.contains(user);
    }

    @Override
    public void like(Post post, User user) {
        Set<User> users = postLikes.get(post);
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
        postLikes.put(post, users);
    }

    @Override
    public void unLike(Post post, User user) {
        Set<User> users = postLikes.get(post);
        if (users != null) {
            users.remove(user);
            postLikes.put(post, users);
        }
    }

    @Override
    public boolean checkLike(Comment comment, User user) {
        Set<User> users = commentLikes.get(comment);
        return users != null && users.contains(user);
    }

    @Override
    public void like(Comment comment, User user) {
        Set<User> users = commentLikes.get(comment);
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
        commentLikes.put(comment, users);
    }

    @Override
    public void unLike(Comment comment, User user) {
        Set<User> users = commentLikes.get(comment);
        if (users != null) {
            users.remove(user);
            commentLikes.put(comment, users);
        }
    }
}
