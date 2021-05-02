package work5_2;

import java.util.Comparator;
import java.util.PriorityQueue;

class RankComparator implements Comparator<Card2> {
    @Override
    public int compare(Card2 o1, Card2 o2) {
        return o1.rank - o2.rank;
    }
}

public class Work3 {

    public static void main(String[] args) {
        Card2 card1 = new Card2(1,"♦");
        Card2 card2 = new Card2(1,"♦");

        PriorityQueue<Card2> qu = new PriorityQueue<Card2>(new RankComparator());
        qu.offer(card1);
        qu.offer(card2);
        System.out.println(qu);

        RankComparator rankComparator = new RankComparator();
        System.out.println(rankComparator.compare(card1,card2));

    }

}
