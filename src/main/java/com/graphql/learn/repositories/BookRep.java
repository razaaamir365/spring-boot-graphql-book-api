package com.graphql.learn.repositories;

import com.graphql.learn.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRep extends JpaRepository<Book,Integer> {
}
