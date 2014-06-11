package intermediate2;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */

public class Intermediate2 {

	public static int[] uniq(int[] arr){

		int[] tmp = new int[arr.length]; //一時的に重複した値を格納する配列
		int index = 0; //重複した値を格納する配列のインデックス
		int arraysize = 0; //最終的に返す配列のサイズ

		//例外処理
		if(arr == null){
			throw new NullPointerException();
		} else if (arr.length == 1){
			int[] clonearr = (int[])arr.clone();
			return clonearr;
		} else {
			//今の要素と次の要素を比較し、重複リストにない値なら格納する
			for(int i = 0 ; i < arr.length; i++){
				if(i <= arr.length-2){
					if(tmp[index] != arr[i]){
						if(index < tmp.length){
							if(arr[i] == arr[i+1]){ //重複していたら格納をスキップ
								continue;
							}
							tmp[index] = arr[i]; //格納する
							index++;
							arraysize++;
						} else if(index == arr.length-1){ //配列の最後
							tmp[index] = arr[i]; //格納する
							arraysize++;
						}
					}
				} else if (i == arr.length-1){
					tmp[index] = arr[i];
					arraysize++;
				}
			}
			//返す配列を生成
			int[] ans = new int[arraysize];
			for(int i =0; i < arraysize; i++){
				ans[i] = tmp[i];
			}
			return ans;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
