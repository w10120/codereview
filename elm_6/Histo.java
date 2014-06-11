
/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Histo {
	public static void main(String[] args){
		int max = 0;
		int[] spaces = new int[100];
		int[] integerArgs = new int[100];

		//渡された引数の中から最大値を出す
		for(int i = 0; i < args.length ; i++){
			integerArgs[i] = Integer.parseInt(args[i]);
			if(integerArgs[i] >= max){
				max = integerArgs[i];
			}
		}

		for(int i = 0; i < args.length ; i++){
			spaces[i] = max - integerArgs[i];
		}

		for(int i = 0; i < max ; i++){
		//最大値を表示しきるまで繰り返す
			for(int k = 0 ; k < args.length ; k++){
				if(spaces[k] > 0){
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
				spaces[k]--;
			}
		System.out.println();
		}
	}
}