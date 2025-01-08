package org.fastcampus.user.repository.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRelationEntity.class)
public class UserRelationIdEntity {
    private Long followingUserId;
    private Long followerUserId;
}
