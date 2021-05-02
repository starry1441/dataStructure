package work5_2;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -02
 * Time: 7:54
 */

class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class Work1 {

    public static void main(String[] args) {
        Card card1 = new Card(4,"♦");
        Card card2 = new Card(2,"♦");
        Card card3 = new Card(2,"♦");

        PriorityQueue<Card> qu = new PriorityQueue<Card>();
        qu.offer(card1);
        qu.offer(card2);
        System.out.println(qu);
        System.out.println(card1.compareTo(card2));

        System.out.println(card2 == card3);
        System.out.println(card2.equals(card3));
    }

}
