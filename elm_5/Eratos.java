import java.io.*;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Eratos {
	public static void main(String[] args) throws IOException {

		int x = 0;
		String list = "";
		boolean isSosu = false;

		try {
				System.out.println("リストの最大値を整数で入力してください。");
				// 入力待ち
				BufferedReader br =
					new BufferedReader(new InputStreamReader(System.in));
				String line = br.readLine();
				x = Integer.parseInt(line);

				// 2と3を先に表示
				if(x >= 2){
					System.out.print("2 ");
					if(x >= 3){
						System.out.print("3 ");
					}
				}

   			    // 4は素数ではないので5からスタート
        		// i += 2 をすることで偶数は素数計算しない（2以外の偶数は素数ではないため）
        		for (int i = 5; i <= x; i += 2) {
            		// 素数判定対象(i)はリストの最大値xの平方根以下で除算する
            		for (int j = 2; j * j <= i; j++) {
                	// 除算できた場合は素数ではないため判定から抜ける
                		if (i % j == 0) {
                    		isSosu = false;
                    		break;
                		}
                		isSosu = true;
            		}
            		if (isSosu) {
                		System.out.print(+ i +" ");
            		}
        		}
			} catch (NumberFormatException e) {
				System.out.println("数字の形式が正しくxありません。");
			}
	}
}