package lazizbek.uz.money_transfer.controller;

import lazizbek.uz.money_transfer.entity.Outcome;
import lazizbek.uz.money_transfer.payload.OutcomeDto;
import lazizbek.uz.money_transfer.payload.Result;
import lazizbek.uz.money_transfer.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/outcome")
public class OutcomeController {
    @Autowired
    OutcomeService outcomeService;

    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody OutcomeDto outcomeDto) {
        Result result = outcomeService.transferMoney(outcomeDto);
        return ResponseEntity.status(result.getSuccess() ? 200 : 409).body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getByFromCardId(@PathVariable Integer id) {
        List<Outcome> outcomes = outcomeService.get(id);
        return ResponseEntity.status(outcomes != null ? 200 : 409).body(outcomes);
    }
}
