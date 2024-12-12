package com.projet.Dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DiceRollController {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    private Random random = new Random();

    @GetMapping("/rollDice")
    public DiceRollLog rollDice() {
        return rollDices(1);
    }

    @GetMapping("/rollDices/{X}")
    public DiceRollLog rollDices(@PathVariable int X) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            results.add(random.nextInt(6) + 1);
        }

        DiceRollLog diceRollLog = new DiceRollLog();
        diceRollLog.setDiceCount(X);
        diceRollLog.setResults(results);
        diceRollLog.setTimestamp(LocalDateTime.now());

        return diceRollLogRepository.save(diceRollLog);
    }


    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}