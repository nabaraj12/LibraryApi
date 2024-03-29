package com.example.Books;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where genre= :genre",nativeQuery = true)
    List<Book> findByGenre(@Param("genre") String genre);

}
