package com.silverhyuk.spring_boot_jpa.repository;

import com.silverhyuk.spring_boot_jpa.entity.parentChild.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepository02Test {

    @Autowired
    CommentRepository02 commentRepository02;

    @Test
    public void crud() {
        Comment comment = new Comment();
        comment.setComment("Hello Comment");
        commentRepository02.save(comment);
        commentRepository02.save(null);

        List<Comment> all = commentRepository02.findAll();
        assertThat(all.size()).isEqualTo(1);
        Optional<Comment> byId = commentRepository02.findById(100l);
        assertThat(byId).isEmpty();
        Comment comment1 = byId.orElse(new Comment());
    }

    @Test
    public void queryCreate() {
        this.createCommon(100, "HELLO");
        List<Comment> hello = commentRepository02.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("hello",10);
        assertThat(hello.size()).isEqualTo(1 );
    }

    @Test
    public void queryOrderBy() {
        this.createCommon(100, "spring data jpa");
        this.createCommon(55, "HIBERNATE SPRING");
        List<Comment> hello = commentRepository02.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");        assertThat(hello.size()).isEqualTo(2);
        assertThat(hello.size()).isEqualTo(2);
        assertThat(hello).first().hasFieldOrPropertyWithValue("likeCount", 100);

    }

    //ctrl + alt + [m]
    private void createCommon(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository02.save(newComment);
    }
}