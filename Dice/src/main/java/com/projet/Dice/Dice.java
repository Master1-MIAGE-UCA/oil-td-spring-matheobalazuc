package com.projet.Dice;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1; 
    }
}