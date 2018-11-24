package com.silverhyuk.spring_boot_jpa.repository;

import com.silverhyuk.spring_boot_jpa.entity.parentChild.Comment;
import com.silverhyuk.spring_boot_jpa.entity.parentChild.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;


public interface CommentRepository02 extends MyRepository<Comment, Long>{

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

    //Page<Comment> findByLikeCountGreaterThenAndPost(int likeCount, Post post, Pageable pageable);

}
