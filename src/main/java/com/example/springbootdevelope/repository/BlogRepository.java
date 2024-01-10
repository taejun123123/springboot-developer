package com.example.springbootdevelope.repository;

import com.example.springbootdevelope.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
