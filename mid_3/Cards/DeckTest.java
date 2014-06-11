package Cards;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class DeckTest {

	@Test
	public void デッキはジョーカー無しだと52枚() {

		Deck deck = new Deck(0);

		assertThat(deck.getRest(), is(52));

	}

	@Test
	public void デッキはジョーカーを入れるとその枚数分増える() {

		Deck deck = new Deck(2);

		assertThat(deck.getRest(), is(54));

	}

	@Test
	public void デッキは生成後シャッフルされている() {

		// デッキを2つ生成
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		Card card1;
		Card card2;

		boolean same = true;

		for (int i = 0; i < deck1.getRest(); i++) {
			card1 = deck1.pick(i);
			card2 = deck2.pick(i);
			// どこか一部でも違う場合はシャッフルできている
			if (card1.suit != card2.suit || card1.number != card2.number)
				same = false;
		}
		assertThat(same, is(false));
	}

	@Test
	public void デッキから指定した枚数のカードを引くことができる() {
		List<Card> drawnCards;
		Deck deck = new Deck(2);
		assertThat(deck.getRest(), is(54));

		try {
			drawnCards = deck.draw(10);

			assertThat(deck.getRest(), is(44));
			assertThat(drawnCards.size(), is(10));
		} catch (IllegalArgumentException e) {
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void 残り枚数よりも大きな数を引くとエラーが投げられる() throws IllegalArgumentException {
		Deck deck = new Deck();
		deck.draw(53);
	}
}