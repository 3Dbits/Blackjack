package com.ht;

public class TestDeck {
    static int count = 0;
    String[] a1 = new String[] {"2", "2"};
    String[] a2 = new String[] {"2", "2"};
    String[] a3 = new String[] {"3", "2"};
    String[] a4 = new String[] {"2", "2"};
    String[] a5 = new String[] {"2", "2"};
    String[] a6 = new String[] {"2", "2"};
    String[] a7 = new String[] {"2", "2"};
    String[] a8 = new String[] {"2", "2"};

    public String[] getCard() {
        count++;

        return switch (count) {
            case 1 -> a1;
            case 2 -> a2;
            case 3 -> a3;
            case 4 -> a4;
            case 5 -> a5;
            case 6 -> a6;
            case 7 -> a7;
            case 8 -> a8;
            default -> null;
        };
    }
}
