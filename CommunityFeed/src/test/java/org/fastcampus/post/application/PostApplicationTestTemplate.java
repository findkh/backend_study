package org.fastcampus.post.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.post.application.dto.CreateCommentRequestDto;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dto.CreateUserRequestDto;
import org.fastcampus.user.domain.User;

public class PostApplicationTestTemplate {
    final UserService userService = FakeObjectFactory.getUserService();
    final PostService postService = FakeObjectFactory.getPostService();
    final User user = userService.createUser(new CreateUserRequestDto("user1", null));
    final User otherUser = userService.createUser(new CreateUserRequestDto("user2", null));
    CreatePostRequestDto postRequestDto = new CreatePostRequestDto(user.getId(), "this is test content",
            PostPublicationState.PUBLIC);
    final CommentService commentService = FakeObjectFactory.getCommentService();
    final Post post = postService.createPost(postRequestDto);

    final String commentContentText = "this is test commentText";
    CreateCommentRequestDto commentRequestDto = new CreateCommentRequestDto(post.getId(), user.getId(),
            "this is test commentText");
}
