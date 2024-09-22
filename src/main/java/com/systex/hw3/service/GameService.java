package com.systex.hw3.service;

import java.util.Random;

public class GameService {
    private final int luckNumber;
    private int remains;

    public GameService(int range, int remains) {
        this.remains = remains;

        this.luckNumber = new Random().ints(1, range + 1).findFirst().getAsInt();

    }

    public int getRemains() {
        return remains;
    }

    public boolean guessLuckNumber(int number) {
        if (this.luckNumber != number) {
            this.remains -= 1;
            return false;
        } else {
            return true;
        }
    }

    public int getLuckNumber() {
        return luckNumber;
    }
}
