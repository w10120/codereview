import java.io.*;
import java.util.Calendar;

/**
 * @author 米倉一宏 更新日 2014/5/1
 */

public class myCalendar {
	private final static int firstday = 1;
	public static void main(String[] args) throws IOException {
		//カレンダーのインスタンスを取得する
		Calendar cal = Calendar.getInstance();
		//文字入力
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//年を取得
		int year = 0;
		//月を取得
		int month = 0;
		//月の最後の日付
		int lastDay = 0;

		//月初めの曜日を取得
		int week = 0;
		//年チェック
		boolean CheckYear = true;
		//月チェック
		boolean CheckMonth = true;

		try {
		//年チェック
			while(CheckYear){
				System.out.println("年を入力してください");
				//年を入力します
				year = Integer.parseInt(input.readLine());
				//年が4桁の場合
				if(String.valueOf(year).length() == 4){
					CheckYear = false;
				}else{
					System.out.println("年は4桁で入力してください");
				}
			}
		//月チェック
			while(CheckMonth){
				System.out.println("月を入力してください");
				//月を入力する
				month = Integer.parseInt(input.readLine());
				//月が1~12の場合
				if( month >= 1 && month <= 12 ){
					CheckMonth = false;
				}else{
					System.out.println("1~12を入力してください");
				}
			}
		}catch (IOException e) {
			System.out.println("数字以外は入力しないでください");
			System.out.println("処理を中断します");
			return;
		}catch (Exception a) {
			System.out.println("数字以外は入力しないでください");
			System.out.println("処理を中断します");
			return;
		}
		//年、月をセットする
		cal.set(year,month-1,cal.getActualMinimum(Calendar.DATE));
		//月初めの曜日を取得
		week = cal.get(Calendar.DAY_OF_WEEK);
		//年月を出力する
		System.out.println(String.valueOf(year)+"年"+String.valueOf(month)+"月");
		//曜日を出力する
		System.out.println(" 日 月 火 水 木 金 土");
		//最後の日付を取得する
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		/*
		* 最後の日付を取得する
		*/
		if(month==1 || month==3 || month==7 || month==8 || month==10 || month==12) {
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}else if(month==4 || month==6 || month==9 || month==11){
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}else if(year%4 == 0 && month==2){
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}else if(year%4 != 0 && month==2){
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		/*
		* カレンダーを出力する
		*/

		//最後の日付まで繰り返す
		for (int i = 1; i <= lastDay; i++) {
			// 1日とそれ以外で分岐する
			if (i == 1) {
			// 1日の曜日位置まで移動する
				for (int j = 1; j < cal.get(Calendar.DAY_OF_WEEK); j++) {
					System.out.print("   ");
				}
			} else {
				// 日付を増やす
				cal.add(Calendar.DAY_OF_MONTH, firstday);
			}
			// 1～9と10～で表示を変える
			if (i < 10) {
				System.out.print("  " + i);
			} else {
				System.out.print(" " + i);
			}
			// 土曜日になったら改行する
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println("");
			}
		}
		System.out.println();
 	}
}