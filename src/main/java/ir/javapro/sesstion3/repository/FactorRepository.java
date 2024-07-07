package ir.javapro.sesstion3.repository;

import ir.javapro.sesstion3.model.Factor;
import ir.javapro.sesstion3.model.Payed;
import ir.javapro.sesstion3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor,Long> {

    Optional<Factor> findByUserAndPayed(User user  , Payed payed);
}
