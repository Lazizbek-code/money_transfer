package lazizbek.uz.money_transfer.controller;

import lazizbek.uz.money_transfer.entity.Card;
import lazizbek.uz.money_transfer.payload.CardDto;
import lazizbek.uz.money_transfer.payload.Result;
import lazizbek.uz.money_transfer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping
    public ResponseEntity<?> addCard(@RequestBody CardDto cardDto) {
        Result result = cardService.addCard(cardDto);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        List<Card> cards = cardService.get();
        return ResponseEntity.status(cards != null ? 200 : 409).body(cards);
    }

    @GetMapping("/username")
    public ResponseEntity<?> getCardByUsername() {
        List<Card> cardsByUsername = cardService.getCardByUsername();
        return ResponseEntity.status(cardsByUsername != null ? 200 : 409).body(cardsByUsername);
    }

}
