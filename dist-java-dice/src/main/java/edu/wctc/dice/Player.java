package edu.wctc.dice;

import java.text.NumberFormat;
import java.util.Locale;

public class Player {
    private String name;
    private int bet;
    private int cash;

    public Player(String name) {
        this.name = name;
        bet = 0;
        cash = 10;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public boolean isBankrupt(){
        return cash <= 0;
    }

    public void loses(){
        bet = 0;
    }

    public void setBet(int bet){
        // if the player bets over their cash amount use cash value.
        bet = Math.min(bet, cash);

        cash -= bet;
    }

    @Override
    public String toString() {
//        return String.format("%s: $%d", name, cash);

        return String.format("%s: %s", name,
                NumberFormat.getCurrencyInstance(Locale.US).format(cash));
    }

    public void wins() {
        cash += bet * 2;
        bet = 0;
    }
}
