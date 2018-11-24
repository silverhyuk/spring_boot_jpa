package com.silverhyuk.spring_boot_jpa.entity.parentChild;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private Integer likeCount = 0;

    //ManyToOne 의 fetch모드는 기본적으로 eager
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;


    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
