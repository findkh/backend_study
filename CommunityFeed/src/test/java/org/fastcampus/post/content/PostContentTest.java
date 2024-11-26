package org.fastcampus.post.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.fastcampus.post.domain.content.PostContent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PostContentTest {

    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent() {
        //given
        String text = "this is a test";

        // when
        PostContent postContent = new PostContent(text);

        //then
        assertEquals(text, postContent.getContentText());
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenReturnThrowError() {
        //given
        String content = "a".repeat(501);

        //then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"갉, 닭, 삵, 먉"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenReturnThrowError(String koreanWord) {
        //given
        String content = koreanWord.repeat(501);

        //then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenReturnThrowError() {
        //given
        String content = "a".repeat(4);

        //then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String value) {
        // when then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(value));
    }

    @Test
    void givenContentLengthOk_whenUpdated_thenReturnUpdatedContent() {
        // given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        postContent.updateContent(content);
    }

    @Test
    void givenContentLengthIsOver_whenUpdated_thenThrowError() {
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when then
        String value = "a".repeat(501);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"갉, 닭, 삵, 먉"})
    void givenContentLengthIsOverAndKorean_whenUpdated_thenReturnThrowError(String koreanWord) {
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when then
        String value = koreanWord.repeat(501);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }

    @Test
    void givenContentLengthIsUnder_whenUpdated_thenThrowError() {
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        String value = "a".repeat(4);
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }
}
