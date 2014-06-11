package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Deck {

	public int jokerNum = 0;

	public ArrayList<Card> deck = new ArrayList<Card>();;

	// ジョーカーの数が渡されたとき
	public Deck(int joker) {
		jokerNum = joker;
		deckMake(jokerNum);
	}

	// ジョーカーの数が渡されなかったとき(オーバーロード)
	public Deck() {
		// 引数ありのコンストラクタに0を渡す
		this(0);
	}

	public void deckMake(int joker) {

		for (int i = 1; i < 53 + joker; i++) {
			deck.add(new Card(i)); // リストにカードを格納
		}
		Collections.shuffle(deck);
	}

	// デッキの残り枚数を返す
	public int getRest() {
		return deck.size();
	}

	// 指定された場所のカード一枚を返す
	public Card pick(int index) {
		return deck.get(index);
	}

	// デッキリストを返す
	public ArrayList<Card> getDeck() {
		return deck;
	}

	// 指定された数だけカードを引く
	public List<Card> draw(int n) throws IllegalArgumentException {

		List<Card> drawnCards = new ArrayList<>();

		if (n > getRest()) {
			throw new IllegalArgumentException("残り枚数以下の値を入力してください");
		}
		for (int i = 0; i < n; i++) {
			Card card = deck.get(i);
			drawnCards.add(card);
			deck.remove(i);
		}
		return drawnCards;
	}
}
