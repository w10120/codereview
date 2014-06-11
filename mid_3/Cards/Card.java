package Cards;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Card implements Comparable<Card> {

	public int number;
	private int id;

	public String suit;

	// 渡された数値からマークと数字を保持
	public Card(int n) {
		id = n;
		if (id > 52) {
			suit = "ジョーカー";
			number = 0;
		} else if (id >= 40) {
			suit = "スペード";
			number = id - 39;
		} else if (id >= 27) {
			suit = "ハート";
			number = id - 26;
		} else if (id >= 14) {
			suit = "ダイヤ";
			number = id - 13;
		} else {
			suit = "クラブ";
			number = id;
		}
	}

	// 大きい、小さい、等しいを1,-1,0で返す
	public int compareTo(Card another) {
		if (this.id > another.id) {
			return 1;
		} else if (this.id == another.id) {
			return 0;
		} else {
			return -1;
		}
	}

	// カードを表示する
	public void showCard() {
		System.out.print(suit);
		if (suit.equals("ジョーカー")) {
		} else {
			System.out.println("の" + number);
		}
	}

}
