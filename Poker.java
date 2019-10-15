import java.util.Scanner;
import java.util.Arrays;

public class Poker {    
    private int rank1, rank2, rank3, rank4, rank5;
    private char suit1, suit2, suit3, suit4, suit5;
    private int [][] cards = new int [4][13];
    private int [] temp = new int [5];
    
    public Poker (int rank1, int rank2, int rank3, int rank4, int rank5, char suit1, char suit2, char suit3, char suit4, char suit5) {
        this.rank1 = rank1;
        this.rank2 = rank2;
        this.rank3 = rank3;
        this.rank4 = rank4;
        this.rank5 = rank5;
        this.suit1 = suit1;
        this.suit2 = suit2;
        this.suit3 = suit3;
        this.suit4 = suit4;
        this.suit5 = suit5;
    }
    
    public int suitToInt (char suit) {
        int x = 4;
        if (suit == 'D' || suit == 'd') {
            x = 0;
        }

        if (suit == 'H' || suit == 'h') {
            x = 1;
        }

        if (suit == 'C' || suit == 'c') {
            x = 2;
        }

        if (suit == 'S' || suit == 's') {
            x = 3;
        }  
        
        return x;
    }

    public void initializeArray () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[i][j] = 0;
            }
        }
    }

    public void initializeTempArray () {
        for (int i = 0; i < 5; i++) {
            temp[i] = 0;
            }
    }
    
    public void fillArray () {
        cards [suitToInt(suit1)][rank1-1] = 1;
        cards [suitToInt(suit2)][rank2-1] = 1;
        cards [suitToInt(suit3)][rank3-1] = 1;
        cards [suitToInt(suit4)][rank4-1] = 1;
        cards [suitToInt(suit5)][rank5-1] = 1;
    }
    
    public boolean checkFlush () {
        boolean flag = false;

        if (suit1 == suit2 && suit2 == suit3 && suit3 == suit4) { 
            flag = true;
        }

        return flag;
    }
        
    public boolean checkStraight () {    
        int count = 0;
        int count2 = 0;
        boolean flag = false;
        //initializeTempArray(temp);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (cards[i][j] == 1) {
                    temp[count] = (j+1);
                    count++;
                }
            }
        }

        Arrays.sort(temp);

        for (int k = 0; k < 4; k++) {
            if (temp[k+1] == temp[k]+1) {
                count2++;
            }
        }

        if (count2 == 4) {
            flag = true;
        }

        return flag;
    }

    public boolean checkFourOfAKind () {
        int count = 0;
        int count2 = 0;
        boolean flag = false;
        //initializeTempArray(temp);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (cards[i][j] == 1) {
                    temp[count] = (j+1);
                    count++;
                }
            }
        }

        Arrays.sort(temp);

        for (int k = 0; k < 4; k++) {
            if (temp[k] == temp[k+1]) {
                count2++;
            }
        }

        if (count2 == 3) {
            flag = true;
        }

        return flag;
    }
}