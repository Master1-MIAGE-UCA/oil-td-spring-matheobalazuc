package com.projet.Dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class DiceRollService {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    private Random random = new Random();

    public DiceRollLog rollDices(int diceCount) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add(random.nextInt(6) + 1);
        }

        DiceRollLog diceRollLog = new DiceRollLog();
        diceRollLog.setDiceCount(diceCount);
        diceRollLog.setResults(results);
        diceRollLog.setTimestamp(LocalDateTime.now());

        return diceRollLogRepository.save(diceRollLog);
    }
}