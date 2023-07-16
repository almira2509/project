package kz.bitlab.ashygali.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.ashygali.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public interface BookRepository extends JpaRepository<Books, Long> {

    }
