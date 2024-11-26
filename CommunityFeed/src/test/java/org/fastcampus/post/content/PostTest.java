package org.fastcampus.post.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

class PostTest {
    private final UserInfo info = new UserInfo("name", "url");
    private final User user1 = new User(1L, info);
    private final User user2 = new User(2L, info);

    private final Post post = new Post(1L, user1, new PostContent("content"));

    @Test
    void givenPostCreated_whenLike_thenCountShouldBe1() {
        //when
        post.like(user2);

        // then
        assertEquals(1, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenLikeOtherUser_thenThrowException() {
        //when then
        assertThrows(IllegalArgumentException.class, () -> post.like(user1));
    }

    @Test
    void givenPostCreatedAndUnlike_whenUnlike_thenLikeCountShouldBe0() {
        // given
        post.like(user2);

        //when
        post.unLike(user2);

        //then
        assertEquals(0, post.getLikeCount());
    }

    @Test
    void givenPostCreated_thenLikeCountShouldBe0() {
        //when
        post.unLike(user2);

        //then
        assertEquals(0, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUpdatedContent_thenContentShouldBeUpdated() {
        //given
        String newPostContent = "new content";

        //when
        post.updatePost(user1, newPostContent, PostPublicationState.PUBLIC);

        // then
        assertEquals(newPostContent, post.getContent());
    }

    @Test
    void givenPostCreated_whenUpdatedUser2_thenThrowException() {
        //given
        String newPostContent = "new content";

        //when then
        assertThrows(IllegalArgumentException.class, () -> post.updatePost(user2, newPostContent, PostPublicationState.PUBLIC));
    }

}
