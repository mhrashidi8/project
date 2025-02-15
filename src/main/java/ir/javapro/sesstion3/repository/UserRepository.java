package ir.javapro.sesstion3.repository;

import ir.javapro.sesstion3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);
}
