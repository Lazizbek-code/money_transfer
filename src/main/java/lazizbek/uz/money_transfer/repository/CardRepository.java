package lazizbek.uz.money_transfer.repository;

import lazizbek.uz.money_transfer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    boolean existsByNumber(String number);
    Card findByUsername(String username);
    List<Card> findAllByUsername(String username);
}
