package org.fastcampus.comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.CommentContent;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

class CommentTest {
    private final UserInfo info = new UserInfo("name", "url");
    private final User user1 = new User(1L, info);
    private final User user2 = new User(2L, info);

    private final Post post = new Post(1L, user1, new PostContent("content"));
    private final Comment comment = new Comment(1L, post, user1, new CommentContent("content"));

    @Test
    void givenCommentCreated_whenLike_thenLikeCountShouldBe1() {
        //when
        comment.like(user2);

        //then
        assertEquals(1, comment.getLikeCounter());
    }

    @Test
    void givenCommentCreated_whenLikeBySelf_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> comment.like(user1));
    }

    @Test
    void givenCommentCreatedAndLike_whenUnlike_thenLikeCounteShouldBe0() {
        //given
        comment.like(user2);

        //when
        comment.unLike(user1);

        //then
        assertEquals(0, comment.getLikeCounter());
    }

    @Test
    void givenCommentCreated_whenUnlike_thenLikeCountShouldBe0() {
        //when
        comment.unLike(user1);

        //then
        assertEquals(0, comment.getLikeCounter());
    }

    @Test
    void givenComment_whenUpdateContent_thenShouldBeUpdated () {
        //given
        String newCommentContent = "new content";

        //when
        comment.updateComment(user1, newCommentContent);

        //then
        assertEquals(newCommentContent, comment.getContent());
    }

    @Test
    void givenComment_whenUpdateContentOver100_thenThrowException() {
        //given
        String newCommentContent = "a".repeat(101);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> comment.updateComment(user1, newCommentContent));
    }

}
