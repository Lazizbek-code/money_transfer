package lazizbek.uz.money_transfer.repository;

import lazizbek.uz.money_transfer.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
    List<Outcome> findAllByFromCardIdId(Integer fromCardId);
}
