import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 * じゃんけん_シンプル版 作成日：2014/04/14 更新日：2014/05/1
 * 
 * @author 米倉一宏
 * 
 */

public class janken_v1 {

	public static void main(String[] args) {

		int man = 0;
		int cpu;
		String player;
		String computer;

		// 開始時メッセージ
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1:グー、2:チョキ、3:パーです。");
		System.out.println("じゃーんけーん・・・");
		System.out.print("出す手を入力 => ");

		// プレイヤーの手の入力待ち
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String str = br.readLine();
			man = Integer.parseInt(str);
		} catch (IOException e) {
			if (man < 1 || man > 3) {
				System.out.println("1~3で入力してください！");
				return;
			}
		}

		// CPUの手をランダムで決める
		Random rnd = new Random();
		cpu = rnd.nextInt(3) + 1; // 1~3を生成

		System.out.println("ぽん!");

		// 手を文字列で取得
		player = numToString(man);
		computer = numToString(cpu);

		// それぞれの手を表示
		System.out.print("あなた：");
		System.out.print(player);
		System.out.print("、コンピューター：");
		System.out.println(computer);

		/*
		 * 勝敗判定
		 */

		// プレイヤーがグーのとき
		if (man == 1) {
			// コンピューターの手
			if (cpu == 1) {
				System.out.println("あいこです！");
			} else if (cpu == 2) {
				System.out.println("あなたの勝ちです！");
			} else {
				System.out.println("あなたの負けです！");
			}
		} else if (man == 2) { // プレイヤーがチョキのとき
			// コンピューターの手
			if (cpu == 1) {
				System.out.println("あなたの負けです！");
			} else if (cpu == 2) {
				System.out.println("あいこです！");
			} else {
				System.out.println("あなたの勝ちです！");
			}
		} else if (man == 3) { // プレイヤーがパーのとき
			// コンピューターの手
			if (cpu == 1) {
				System.out.println("あなたの勝ちです！");
			} else if (cpu == 2) {
				System.out.println("あなたの負けです！");
			} else {
				System.out.println("あいこです！");
			}
		}
	}

	/**
	 * 入力された数値から対応する文字列を返す
	 * 
	 * @param num
	 * @return
	 */
	public static String numToString(int num) {
		if (num == 1) {
			return "グー";
		} else if (num == 2) {
			return "チョキ";
		} else {
			return "パー";
		}
	}
}