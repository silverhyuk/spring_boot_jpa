package com.silverhyuk.spring_boot_jpa.repository;

import com.silverhyuk.spring_boot_jpa.entity.parentChild.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
