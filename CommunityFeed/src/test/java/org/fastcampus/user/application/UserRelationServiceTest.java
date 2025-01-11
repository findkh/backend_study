package org.fastcampus.user.application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.user.application.dto.CreateUserRequestDto;
import org.fastcampus.user.application.dto.FollowUserRequestDto;
import org.fastcampus.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRelationServiceTest {
    private final UserService userService = FakeObjectFactory.getUserService();
    private final UserRelationService userRelationService = FakeObjectFactory.getUserRelationService();
    private User user1;
    private User user2;
    private FollowUserRequestDto relationDto;

    @BeforeEach
    void setUp() {
        // given
        CreateUserRequestDto req = new CreateUserRequestDto("Doe", "");
        this.user1 = userService.createUser(req);
        this.user2 = userService.createUser(req);
        this.relationDto = new FollowUserRequestDto(user1.getId(), user2.getId());
    }


    @Test
    void givenCreateTwoUserWhenFollowThenUserFollowOtherUser() {
        // when
        userRelationService.follow(relationDto);

        // then
        assertEquals(1, user1.followingCount());
        assertEquals(1, user2.followerCount());
    }

    @Test
    void givenFollowUserWhenFollowAgainThenThrowException() {
        // given
        userRelationService.follow(relationDto);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(relationDto));
    }

    @Test
    void givenFollowUserWhenFollowSelfThenThrowException() {
        // given
        FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(sameUser));
    }

    @Test
    void givenFollowUserWhenUnfollowThenUserUnfollowOtherUser() {
        // given
        userRelationService.follow(relationDto);

        // when
        userRelationService.unfollow(relationDto);

        // then
        assertEquals(0, user1.followingCount());
        assertEquals(0, user2.followerCount());
    }

    @Test
    void givenUnfollowUserWhenUnfollowAgainThenThrowException() {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(relationDto));
    }

    @Test
    void givenUnfollowUserWhenUnfollowSelfThenThrowException() {
        // given
        FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(sameUser));
    }
}
