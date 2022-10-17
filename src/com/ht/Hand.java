package com.ht;

import java.util.Arrays;

public class Hand {

    private int sum;
    private String[][] memory = new String[10][2];
    private int counterCards = 0;
    private int counterA11 = 0;

    public Hand() {
    }

   public void playerSum(String[] card, String who) {
       memory[counterCards][0] = card[0];
       memory[counterCards][1] = card[1];

       seeHand(card, who);

       if (card[0].equals("J") || card[0].equals("Q") || card[0].equals("K")) {
           checkA11(10);
       } else if (card[0].equals("A")) {
           if (this.sum + 11 <= 21) {
               this.sum += 11;
               counterA11++;
           } else if (this.sum + 11 > 21) {
               checkA11(1);
           }
       } else {
           checkA11(Integer.parseInt(card[0]));
       }
       counterCards++;
       //System.out.println("SUM: " + this.sum); //For test print SUM
   }


    public int getSum() {
        return sum;
    }

    public void seeHand(String[] card, String who) {
        if (counterCards == 1 && who.equals("D")) {
            System.out.println("[#, #]");
        } else if (counterCards < 2) {
            System.out.println(Arrays.toString(card));
        } else {
            for (var e : memory) {
                if (e[0] != null) {
                    System.out.println(Arrays.toString(e));
                }
            }
        }
    }

    public void checkA11(int number) {
        if (counterA11 > 0 && this.sum + number > 21) {
            this.sum += (-10 + number);
            counterA11--;
        } else {
            this.sum += number;
        }
    }

}
