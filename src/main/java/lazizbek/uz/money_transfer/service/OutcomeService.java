package lazizbek.uz.money_transfer.service;

import lazizbek.uz.money_transfer.entity.Card;
import lazizbek.uz.money_transfer.entity.Income;
import lazizbek.uz.money_transfer.entity.Outcome;
import lazizbek.uz.money_transfer.payload.OutcomeDto;
import lazizbek.uz.money_transfer.payload.Result;
import lazizbek.uz.money_transfer.repository.CardRepository;
import lazizbek.uz.money_transfer.repository.IncomeRepository;
import lazizbek.uz.money_transfer.repository.OutcomeRepository;
import lazizbek.uz.money_transfer.security.JwtFilter;
import lazizbek.uz.money_transfer.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    JwtFilter jwtFilter;


    public List<Outcome> get(Integer id) {
        return outcomeRepository.findAllByFromCardIdId(id);
    }


    public Result transferMoney(OutcomeDto outcomeDto) {
        // Kartani(chiqim) id bo'yicha topish
        Optional<Card> optionalFromCard = cardRepository.findById(outcomeDto.getFromCardId());
        if (!optionalFromCard.isPresent()) {
            return new Result(false, "Karta topilmadi");
        }
        Card fromCard = optionalFromCard.get();

        // Kartani(kirim) id bo'yicha topish
        Optional<Card> optionalToCard = cardRepository.findById(outcomeDto.getToCardId());
        if (!optionalToCard.isPresent()) {
            return new Result(false, "Karta topilmadi");
        }
        Card toCard = optionalToCard.get();

        // Tekshirish
        String username = jwtFilter.username;
        if (!fromCard.getUsername().equals(username)) {
            return new Result(false, "Bu sizning kartangiz emas");
        }

        // Tekshirish
        if (fromCard.getId().equals(toCard.getId())) {
            return new Result(false, "Kartalar bir xil!");
        }

        // Tekshirish, Kartadagi pulni tekshirish
        if(fromCard.getBalance() < (outcomeDto.getAmount() + outcomeDto.getAmount() * 0.01)) {
            return new Result(false, "Pul yetarli emas");
        }

        // Karta(chiqim) pulini o'zgartish
        fromCard.setBalance(fromCard.getBalance() - (outcomeDto.getAmount() + outcomeDto.getAmount() * 0.01));
        Card savedFromCard = cardRepository.save(fromCard);

        // Karta(kirim) pulini o'zgartish
        toCard.setBalance(toCard.getBalance() + outcomeDto.getAmount());
        Card savedToCard = cardRepository.save(toCard);

        // SAVE OUTCOME
        Outcome outcome = new Outcome();
        outcome.setAmount(outcomeDto.getAmount());
        outcome.setFromCardId(savedFromCard);
        outcome.setToCardId(savedToCard);
        outcomeRepository.save(outcome);

        // SAVE INCOME
        Income income = new Income();
        income.setAmount(outcomeDto.getAmount());
        income.setToCardId(savedToCard);
        income.setFromCardId(savedFromCard);
        incomeRepository.save(income);
        return new Result(true, "Money successfully transferred");
    }


}
