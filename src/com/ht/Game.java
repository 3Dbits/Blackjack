package com.ht;

import java.util.Scanner;

public class Game {

    private String input = "";
    private boolean startAgain = false;
    private final int max = 21;
    boolean firstAppStart = true;
    Scanner sc = new Scanner(System.in);
    Deck deck = new Deck();
    //TestDeck deck = new TestDeck();


    public void playGame() throws InterruptedException {

        Hand dealer = new Hand();
        Hand player = new Hand();
        startAgain = false;

        if(firstAppStart){
            //loadingApp();
            firstAppStart = false;
        }

        System.out.println("\n-------------NEW GAME-------------");

        firstHand(dealer, player);

        while (!input.equalsIgnoreCase("exit") && !startAgain) {
            menu(dealer, player);
        }

        if (startAgain) {
            playGame();
        }
    }

    public void info() {
        System.out.println("\n\tCommands:\n" +
                "\t  * exit -> to exit game\n" +
                "\t  * hit -> get a card\n" +
                "\t  * done -> to finnish round");
    }

    public void menu(Hand dealer, Hand player) {
        System.out.println("\nChose next step:\n1.hit, 2.done, 3.info, 4.exit");
        input = sc.nextLine();

        switch (input) {
            case "hit" :
                player.playerSum(deck.getCard(), "P");
                defineWhoWinsPlayer(dealer, player);
                break;
            case "done" :
                dealerLogic(dealer, player.getSum());
                defineWhoWins(dealer, player);
                break;
            case "info" :
                info();
                break;
            case "exit" :
                break;
            default:
                System.out.println("Please enter valid input!");
        }
    }

    public void loadingApp() throws InterruptedException {
        System.out.print("[/--------------]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[//-------------]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[////-----------]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[//////---------]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[////////-------]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[//////////-----]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[////////////---]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[//////////////-]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        Thread.sleep(100);
        System.out.print("[///////////////]");
        Thread.sleep(1000);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print("Blackjack APP");
    }

    public void dealerLogic (Hand dealer, int playerSum) {
        if (dealer.getSum() < 16 && dealer.getSum() < playerSum) {
            System.out.println("Dealer hand:");
            dealer.playerSum(deck.getCard(), "D");
            dealerLogic(dealer, playerSum);
        }
        startAgain = true;
    }

    public void defineWhoWins(Hand dealer, Hand player) {
            if (dealer.getSum() > max) {
                System.out.println("Dealer BUST!");
                System.out.println("Player wins!!");
            } else if (dealer.getSum() < player.getSum()) {
                System.out.println("Player wins!!");
            } else {
                System.out.println("The house always win. Try again!");
            }
    }

    public void defineWhoWinsPlayer(Hand dealer, Hand player) {
        if (dealer.getSum() == max) {
            System.out.println("The house always win. Try again!");
            startAgain = true;
        } else if (player.getSum() == max) {
            System.out.println("Player wins!");
            startAgain = true;
        } else if (player.getSum() > max) {
            System.out.println("Player BUST!");
            startAgain = true;
        }
    }

    public void firstHand(Hand dealer, Hand player) {
        System.out.println("Dealer:");
        dealer.playerSum(deck.getCard(), "D");
        dealer.playerSum(deck.getCard(), "D");

        System.out.println("\nYou:");
        player.playerSum(deck.getCard(), "P");
        player.playerSum(deck.getCard(), "P");

        defineWhoWinsPlayer(dealer, player);
    }


}

