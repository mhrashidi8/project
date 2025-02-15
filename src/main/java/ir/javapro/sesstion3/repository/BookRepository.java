package ir.javapro.sesstion3.repository;

import ir.javapro.sesstion3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository <Book,Long> {


    Optional<Book> findByName(String name);


    @Query("select b from Book  b where b.name like :name")
    List<Book> findByNameV2 (String name);


    List <Book> findByNameContains(String name);
}
