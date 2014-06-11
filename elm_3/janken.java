import java.util.Random;
import java.io.*;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class janken {
	static int man = 0,cpu = 0; // 手の数値
	static String player = new String(); // プレーヤーの手の文字列
	static String computer = new String(); //コンピューターの手の文字列
	static boolean checkHand = true; // 手を入力している状態
	static boolean aiko = false; // あいこかどうか

	//手を決めるメソッド
	public static void doJanken() throws IOException {
		try {
			while(checkHand){
				System.out.print("出す手を入力 => ");
					// プレイヤーの手の入力待ち
					BufferedReader br =
						new BufferedReader(new InputStreamReader(System.in));
					String str = br.readLine();
					man = Integer.parseInt(str);
					// 条件を満たせば入力終了
					if((man >= 1 ) && (man <= 3)){
						checkHand = false;
					}
				}
				// CPUの手をランダムで決める
				Random rnd = new Random();
				cpu = rnd.nextInt(3)+1; // 1~3を生成

				//プレーヤーの手を文字列にする
				if (man == 1) player = "グー";
				else if (man == 2) player = "チョキ";
				else player = "パー";
				//CPUの手を文字列にする
				if (cpu == 1) computer = "グー";
				else if (cpu == 2) computer = "チョキ";
				else computer = "パー";

				if(aiko){
					System.out.println("しょ！");
					aiko = false;
				} else {
					System.out.println("ぽん！");
				}
				//それぞれの手を表示
				System.out.print("あなた：");
				System.out.print(player);
				System.out.print("、コンピューター：");
				System.out.println(computer);
		} catch (NumberFormatException e) {
			System.out.println("数字の形式が正しくありません。");
		}
	}
	//判定して表示するメソッド
	public static void doJudge() throws IOException{
		// プレイヤーがグーのとき
		if(player.equals("グー")){
			//コンピューターの手
			if(computer.equals("グー")){
				System.out.println("あーいこでー・・・！");
				checkHand = true;
				aiko = true;
				doJanken();
				doJudge();
			} else if (computer.equals("チョキ")){
				System.out.println("あなたの勝ちです！");
			} else {
				System.out.println("あなたの負けです！");
			}
		}
		// プレイヤーがチョキのとき
		if(player.equals("チョキ")){
			//コンピューターの手
			if(computer.equals("グー")){
				System.out.println("あなたの負けです！");
			} else if (computer.equals("チョキ")){
				System.out.println("あーいこでー・・・！");
				checkHand = true;
				aiko = true;
				doJanken();
				doJudge();
			} else {
				System.out.println("あなたの勝ちです！");
			}
		}
		// プレイヤーがパーのとき
		if(player.equals("パー")){
			// コンピューターの手
			if(computer.equals("グー")){
				System.out.println("あなたの勝ちです！");
			} else if (computer.equals("チョキ")){
				System.out.println("あなたの負けです！");
			} else {
				System.out.println("あーいこでー・・・！");
				checkHand = true;
				aiko = true;
				doJanken();
				doJudge();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// 開始時メッセージ
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1:グー、2:チョキ、3:パーです。");
		System.out.println("じゃーんけーん・・・");

		doJanken();
		doJudge();
	}
}