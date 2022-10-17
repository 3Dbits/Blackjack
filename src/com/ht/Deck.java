package com.ht;

public class Deck {

    private int numberOfCards = 52;
    private String[][] deckOfCards = new String[numberOfCards][2];
    private final String[] CARDS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
    private final String[] SUITS = {"♣", "♦", "♥", "♠"};


    public Deck() {
        shuffle();
    }

    public void shuffle() {
        if (numberOfCards == 0 || numberOfCards == 52) {
            this.numberOfCards = 52;
            for (int i = 0; i < this.SUITS.length; i++) {
                for (int j = 0; j < this.CARDS.length; j++) {
                    this.deckOfCards[j + 13 * i][0] = this.CARDS[j];
                    this.deckOfCards[j + 13 * i][1] = this.SUITS[i];
                }
            }
        } else {
            System.out.println("You must use all off your cards.");
        }

    }

    //For test print all cards in deck
    public void testPrint() {
        for(int i = 0; i < numberOfCards; i++) {
            System.out.println("[" + deckOfCards[i][0] + " ," + deckOfCards[i][1] +"]");
        }
    }

    public String[] getCard() {
        int tempRandom;
        String[] tempArrayRandom = new String[2];

        if (numberOfCards == 0) {
            shuffle();
        }

        numberOfCards--;
        do {
            tempRandom = (int) (Math.random() * 52);
        } while (deckOfCards[tempRandom][0] == null);
        tempArrayRandom[0] = deckOfCards[tempRandom][0];
        tempArrayRandom[1] = deckOfCards[tempRandom][1];
        deckOfCards[tempRandom][0] = null;
        return tempArrayRandom;
        }
}
