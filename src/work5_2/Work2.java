package work5_2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -02
 * Time: 8:13
 */

class Card2{
    public int rank; // 数值
    public String suit; // 花色
    public Card2(int rank, String suit) {
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
}

public class Work2 {

    public static void main(String[] args) {
        Card2 card1 = new Card2(1,"♦");
        Card2 card2 = new Card2(1,"♦");

        PriorityQueue<Card2> qu = new PriorityQueue<Card2>(new Comparator<Card2>() {
            @Override
            public int compare(Card2 o1, Card2 o2) {
                return o1.rank - o2.rank;
            }
        });
        qu.offer(card1);
        qu.offer(card2);
        System.out.println(qu);

    }

}
