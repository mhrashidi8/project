package ir.javapro.sesstion3.repository;

import ir.javapro.sesstion3.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
}
