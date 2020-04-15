package com.mw.springmongodb.repository;

import com.mw.springmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookDao extends MongoRepository<Book, Integer> {

}
