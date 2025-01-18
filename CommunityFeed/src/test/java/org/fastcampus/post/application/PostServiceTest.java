package org.fastcampus.post.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.application.dto.UpdatePostRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.junit.jupiter.api.Test;

public class PostServiceTest extends PostApplicationTestTemplate {

    @Test
    void givenPostRequestDto_whenCreate_thenReturnPost() {
        //when
        Post savePost = postService.createPost(postRequestDto);

        //then
        Post post = postService.getPost(savePost.getId());

        System.out.println(savePost.getId());
        System.out.println( post.getId());

        assertEquals(savePost, post);
    }


    @Test
    void givenCreatePost_whenUpdate_thenReturnUpdatePost() {
        // given
        Post savePost = postService.createPost(postRequestDto);

        // when
        UpdatePostRequestDto updatePostRequestDto = new UpdatePostRequestDto(user.getId(), "this is test content", PostPublicationState.PUBLIC);
        Post updatePost = postService.updatePost(savePost.getId(), updatePostRequestDto);

        // then
        assertEquals(savePost.getId(), updatePost.getId());
        assertEquals(savePost.getAuthor(), updatePost.getAuthor());
        assertEquals(savePost.getContent(), updatePost.getContent());
    }

    @Test
    void givenCreatePost_whenLiked_thenReturnPostWithLike() {
        //given
        Post savePost = postService.createPost(postRequestDto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto(savePost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);

        //then
        assertEquals(1, savePost.getLikeCount());
    }

    @Test
    void givenCreatePost_whenUnliked_thenReturnPostWithUnlike() {
        // given
        Post savePost = postService.createPost(postRequestDto);

        // when
        LikeRequestDto likeRequestDto = new LikeRequestDto(savePost.getId(), otherUser.getId());
        postService.unlikePost(likeRequestDto);

        // then
        assertEquals(0, savePost.getLikeCount());
    }

    @Test
    void givenCreatePostLiked_whenUnliked_thenReturnPostWithoutLike() {
        //given
        Post savePost = postService.createPost(postRequestDto);
        LikeRequestDto likeRequestDto = new LikeRequestDto(savePost.getId(), otherUser.getId());
        postService.likePost(new LikeRequestDto(savePost.getId(), otherUser.getId()));

        //when
        postService.unlikePost(likeRequestDto);

        //then
        assertEquals(0, savePost.getLikeCount());
    }

    @Test
    void givenCreatePost_whenUnliked_thenReturnPostWithoutLike() {
        //given
        Post savePost = postService.createPost(postRequestDto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto(savePost.getId(), otherUser.getId());
        postService.unlikePost(likeRequestDto);

        //then
        assertEquals(0, savePost.getLikeCount());
    }

}
