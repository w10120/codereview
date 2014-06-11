package Cards;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class CardTest {

	@Test
	public void カードはマークと数字を持つ() {

		Card card1 = new Card(1); // 1~52がクラブの1からスペードの13まで順に割り当てられている
		Card card2 = new Card(27);

		assertThat(card1.suit, is("クラブ"));
		assertThat(card1.number, is(1));
		assertThat(card2.suit, is("ハート"));
		assertThat(card2.number, is(1));
	}

	@Test
	public void ジョーカーが存在する() {
		Card card = new Card(53); // 53以降がジョーカー

		assertThat(card.suit, is("ジョーカー"));
	}

	@Test
	public void 数字の大小を比較できる() {

		Card card1;
		Card card2;

		card1 = new Card(5);
		card2 = new Card(30);
		assertThat(card1.compareTo(card2), is(-1)); // card1はcard2と比較して小さい

	}

	@Test
	public void 同じ数字の場合のマークの大小関係() {

		Card card1 = new Card(1); // クラブの1
		Card card2 = new Card(14); // ダイヤの1

		assertThat(card1.compareTo(card2), is(-1)); // card1はcard2と比較して小さい

	}

	@Test
	public void ソート可能かどうか() {

		Card card1 = new Card(1); // クラブの1
		Card card2 = new Card(52); // スペードの13
		Card card3 = new Card(53); // ジョーカー
		List<Card> deck = new ArrayList<>();

		// カードの追加
		deck.add(card2);
		deck.add(card3);
		deck.add(card1);

		// カードのソート
		Collections.sort(deck);

		// カードの順番を見る
		assertThat(deck.get(0), is(card1));
		assertThat(deck.get(1), is(card2));
		assertThat(deck.get(2), is(card3));
	}
}