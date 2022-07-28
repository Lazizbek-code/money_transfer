package lazizbek.uz.money_transfer.service;

import lazizbek.uz.money_transfer.entity.Card;
import lazizbek.uz.money_transfer.payload.CardDto;
import lazizbek.uz.money_transfer.payload.Result;
import lazizbek.uz.money_transfer.repository.CardRepository;
import lazizbek.uz.money_transfer.security.JwtFilter;
import lazizbek.uz.money_transfer.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    JwtProvider jwtProvider;

    public Result addCard(CardDto cardDto){
        boolean existsByNumber = cardRepository.existsByNumber(cardDto.getNumber());
        if (existsByNumber) {
            return new Result(false, "Carta oldin qo'shilgan");
        }

        Card card = new Card();
        card.setUsername(jwtFilter.username);
        card.setNumber(cardDto.getNumber());
        card.setExpireDate(cardDto.getExpireDate());
        cardRepository.save(card);

        return new Result(true, "Card successfully added");
    }

    public List<Card> get() {
        return cardRepository.findAll();
    }

    public List<Card> getCardByUsername() {
        String username = jwtFilter.username;
        return cardRepository.findAllByUsername(username);
    }
}
