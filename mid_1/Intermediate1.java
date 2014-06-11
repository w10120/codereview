package intermediate;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Intermediate1 {

	public static String toBinaryString(int a){

		//戻り値を格納する文字列
		String ans = "";

		//引数が0のとき
		if(a == 0){
			ans = "0";
		} else if (a < 0){ //引数が負の数のとき
				throw new IllegalArgumentException();
		} else {
			while( a > 0 ){
				ans = ( a % 2 ) + ans; //文字列に1か0を格納
				a /= 2;
			}
		}
		return ans; //文字列を返す
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
