package edu.wctc.dice;

import edu.wctc.dice.iface.GameInput;
import edu.wctc.dice.iface.GameOutput;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


@Lazy
@Component
public class DiceGame {
    private final GameInput in;
    private final GameOutput out;

    private List<Player> players = new ArrayList<>();
    private int currentRound = 1;
    private Logger logger = Logger.getLogger(DiceGame.class.getName());


    public DiceGame(GameInput in, GameOutput out) {
        this.in = in;

        this.out = out;
    }

    private void beginRound() {
        logger.info("Begin Round " + currentRound);

        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            String choice = getPlayerChoice(currentPlayer.getName());
            if (choice.equals("2")) {
                playerIterator.remove();
                logger.info("Player cashed out: " + currentPlayer.toString());
            } else {
                int bet = getBet(currentPlayer.getCash());
                currentPlayer.setBet(bet);
            }
        }
    }

    private void endRound(boolean evens) {
        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            if (evens) {
                currentPlayer.wins();
            } else {
                currentPlayer.loses();
                if (currentPlayer.isBankrupt()) {
                    playerIterator.remove();
                    logger.info("Player bankrupt: " + currentPlayer.toString());
                }
            }
        }

        playerReport();

        logger.info("End Round " + currentRound++);
    }

    private int getBet(int cash) {
        String bet = in.getInput("Bet how much? ($" + cash + " available): ");
        return Integer.parseInt(bet);
    }

    private String getPlayerChoice(String playerName) {
        String menu = playerName.toUpperCase() + "'s turn:\n"
                + "  1. Place Bet\n"
                + "  2. Cash Out (Quit)\n >";
        return in.getInput(menu);
    }

    private void initPlayers() {
        String playerName = in.getInput("Enter player name: ");
        while (players.isEmpty() || !playerName.equalsIgnoreCase("Q")) {
            players.add(new Player(playerName));
            logger.info("Player " + playerName + " joined game");
            playerName = in.getInput("Enter player name (Q to quit): ");
        }
    }

    public void play() {
        logger.info("Game start");

        initPlayers();

        while (!players.isEmpty()) {
            beginRound();
            boolean evens = rollDice();
            endRound(evens);
            currentRound++;
        }

        out.output("GAME OVER");
    }

    private void playerReport() {
        String report = "Player Report (Round " + currentRound + ")\n";
        if (players.isEmpty()) {
            report += "  No players remain!\n";
        } else {
            for (Player player : players) {
                report += "  " + player.toString() + "\n";
            }
        }
        out.output(report);
    }

    private boolean rollDice() {
        int die1 = rollDie();
        int die2 = rollDie();

        // Players win on even totals
        boolean even = (die1 + die2) % 2 == 0;

        String outcome = "Roll was " + die1 + ", " + die2;

        out.output(outcome + (even ? "\nPlayers WIN!" : "\nPlayers LOSE!"));

        logger.info(outcome);

        return even;
    }

    private int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
//        return dieRoller.rollDie();
    }
}
