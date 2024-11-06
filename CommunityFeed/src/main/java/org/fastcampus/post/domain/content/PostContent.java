package org.fastcampus.post.domain.content;

public class PostContent extends Content {

    private static final int MIN_POST_LENGTH = 50;
    private static final int MAX_POST_LENGTH = 500;

    public PostContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() > MAX_POST_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (contentText.length() < MIN_POST_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

//    private final String content;
//
//    public PostContent(String content) {
//        if(content == null || content.length() <= 5 || content.length() > 500) {
//            throw new IllegalArgumentException();
//        }
//        this.content = content;
//    }
//
//    public String getContent() {
//        return content;
//    }
}
