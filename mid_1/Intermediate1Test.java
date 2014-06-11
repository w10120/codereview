package intermediate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Intermediate1Test {

	@Test
	public void toBinaryStringは10進数の数を2進数表記に変換する() {
		int src = 14;
		String actual = Intermediate1.toBinaryString(src);

		assertThat(actual, is("1110"));
	}

	@Test
	public void toBinaryStringは0を渡すと0を返す() {
		int src = 0;
		String actual = Intermediate1.toBinaryString(src);

		assertThat(actual, is("0"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void toBinaryStringは負の数を渡すとIllegalArgumentExceptionを投げる() {
		Intermediate1.toBinaryString(-1);
	}

}
