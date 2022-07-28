package lazizbek.uz.money_transfer.service;

import lazizbek.uz.money_transfer.entity.Income;
import lazizbek.uz.money_transfer.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;

    public List<Income> get(Integer id) {
        return incomeRepository.findAllByToCardIdId(id);
    }
}
