package work3_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:模拟一副扑克牌，然后分别发5张牌给3个人
 * User: starry
 * Date: 2021 -03 -09
 * Time: 16:42
 */

//扑克牌
class Card {
    public String suit; //花色
    public int rank;    //数字

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "suit='" + suit + '\'' +
//                ", rank=" + rank +
//                '}';
        return "["+suit+","+rank+"]";
    }
}

//生成扑克牌
class DeckCard {
    public static final String[] suits = {"♥","♠","♦","♣"};

    //买一副牌
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < 13; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(suit,rank);
                cardList.add(card);
            }
        }
        return cardList;
    }

    //交换两张牌
    public void swap(List<Card> cardList, int i, int j) {
        Card tmp = cardList.get(i);
        cardList.set(i,cardList.get(j));
        cardList.set(j,tmp);
    }

    //洗牌
    public void washCard(List<Card> cardList) {
        for (int i = cardList.size()-1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cardList,i,rand);
        }
    }

}

public class Work2 {

    public static void main(String[] args) {
        DeckCard deckCard = new DeckCard();
        List<Card> cardList = deckCard.buyCard();
        System.out.println("========买牌=========");
        System.out.println(cardList);
        deckCard.washCard(cardList);
        System.out.println("========洗牌=========");
        System.out.println(cardList);

        //三个人
        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();
        //存放三个人手里牌的数组
        List<List<Card>> hands = new ArrayList<>();
        hands.add(hands1);
        hands.add(hands2);
        hands.add(hands3);
        System.out.println("========发牌=========");
        //一个人一次发五张牌
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Card card = cardList.remove(0);
                hands.get(i).add(card);
            }
        }
/*
        //三人轮流发牌，一人一共发5张牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                hands.get(j).add(card);
            }
        }
*/
        System.out.println("第一个人：");
        System.out.println(hands1);
        System.out.println("第二个人：");
        System.out.println(hands2);
        System.out.println("第三个人：");
        System.out.println(hands3);
        System.out.println("剩下的牌：");
        System.out.println(cardList);
    }

}