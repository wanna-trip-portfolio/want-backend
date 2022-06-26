package com.want.want.repository;

import com.want.want.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Transactional
    @Query("update Post p set p.hit = p.hit + 1 where p.id = :id")
    int updateHit(Long id);
}
