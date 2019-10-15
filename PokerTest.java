import java.util.*;

public class PokerTest {
  public static void main(String [] args) {
    
    //Scanner for reading from screen
    Scanner in = new Scanner(System.in);

    int rank1, rank2, rank3, rank4, rank5;
    char suit1, suit2, suit3, suit4, suit5;
    //int s1, s2, s3, s4, s5;

    System.out.println("Enter suit1: ");
    suit1 = in.next().charAt(0);
    System.out.println("Enter suit2: ");
    suit2 = in.next().charAt(0);
    System.out.println("Enter suit3: ");
    suit3 = in.next().charAt(0);
    System.out.println("Enter suit4: ");
    suit4 = in.next().charAt(0);
    System.out.println("Enter suit5: ");
    suit5 = in.next().charAt(0);
    
    System.out.println("Enter rank1: ");
    rank1 = in.nextInt();
    System.out.println("Enter rank2: ");
    rank2 = in.nextInt();
    System.out.println("Enter rank3: ");
    rank3 = in.nextInt();
    System.out.println("Enter rank4: ");
    rank4 = in.nextInt();
    System.out.println("Enter rank5: ");
    rank5 = in.nextInt();


    Poker hand = new Poker(rank1, rank2, rank3, rank4, rank5, suit1, suit2, suit3, suit4, suit5);

    hand.initializeArray();
    hand.fillArray();
    //check flush
    if (hand.checkFlush()) {
      System.out.println("Hand is a flush.");
    }
    
    //check straight
    hand.initializeTempArray();
    if (hand.checkStraight()) {
      System.out.println("Hand is a straight.");
    }

    //check flush straight
    hand.initializeTempArray();
    if(hand.checkFlush() && hand.checkStraight()) {
      System.out.println("Hand is a straight flush.");
    }

    //check 4 of a kind
    hand.initializeTempArray();
    if(hand.checkFourOfAKind()) {
      System.out.println("Hand is a 4 of a kind.");
    }

  }
}