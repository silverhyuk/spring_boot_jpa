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
import static org.junit.Assert.*;

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
}