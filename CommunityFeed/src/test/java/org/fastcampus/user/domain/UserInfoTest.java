package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCrated_thenThrowNothing() {
        //given
        String name = "Abc";
        String profileImgUrl = "";

        //when
        //then
        assertDoesNotThrow(() -> new UserInfo(name, profileImgUrl));
    }

    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowError(){
        //given
        String name = "";
        String profileImgUrl = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImgUrl));
    }
}
