package com.arthur.library_management_api.Repositories;

import com.arthur.library_management_api.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Id(long authorId);

    //Book[] findAllByAuthor_Id(long authorId);
}
