package org.fastcampus.post.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fastcampus.comment.Comment;
import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.application.dto.UpdateCommentRequestDto;
import org.junit.jupiter.api.Test;

public class CommentServiceTest extends PostApplicationTestTemplate {

    @Test
    void givenCreateComment_whenCreateComment_thenReturnComment() {
        //when
        Comment comment =commentService.createComment(commentRequestDto);

        //then
        String content = comment.getContent();
        assertEquals(commentContentText, content);
    }

    @Test
    void givenUpdateComment_whenUpdateComment_thenReturnComment() {
        //given
        Comment comment =commentService.createComment(commentRequestDto);

        //when
        UpdateCommentRequestDto updateCommentRequestDto = new UpdateCommentRequestDto(comment.getId(), user.getId(), "update-content");
        Comment updatedComment = commentService.updateComment(updateCommentRequestDto);

        //then
        assertEquals(comment.getId(), updatedComment.getId());
        assertEquals(comment.getAuthor(), updatedComment.getAuthor());
        assertEquals(comment.getContent(), updatedComment.getContent());
    }

    @Test
    void givenComment_whenLikeComment_thenReturnCommentWithLike() {
        //given
        Comment comment =commentService.createComment(commentRequestDto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto(comment.getId(), otherUser.getId());
        commentService.likeComment(likeRequestDto);

        //then
        assertEquals(1, comment.getLikeCounter());
    }

        @Test
    void givenComment_whenUnlikeComment_thenReturnCommentWithoutLike() {
        // given
        Comment comment =commentService.createComment(commentRequestDto);

        // when
        LikeRequestDto likeRequestDto = new LikeRequestDto(comment.getId(), otherUser.getId());
        commentService.likeComment(likeRequestDto);
        commentService.unLikeComment(likeRequestDto);

        assertEquals(0, comment.getLikeCounter());
    }
}
