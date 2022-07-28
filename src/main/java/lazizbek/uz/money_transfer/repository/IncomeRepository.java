package lazizbek.uz.money_transfer.repository;

import lazizbek.uz.money_transfer.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    boolean existsById(Integer id);

    List<Income> findAllByToCardIdId(Integer toCardId_id);
}
