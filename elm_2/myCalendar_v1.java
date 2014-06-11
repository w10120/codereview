import java.io.IOException;
import java.util.Calendar;

/**
 * @author 米倉一宏 更新日 2014/6/11
 */
public class myCalendar_v1 {
	private final static int firstday = 1;

	/**
	 * @param args
	 * @throws IOException
	 * @param year
	 * @param month
	 * @param week
	 *            曜日
	 * @param lastDay
	 *            月の最後の日
	 */
	public static void main(String[] args) {
		// カレンダーのインスタンスを取得する
		Calendar cal = Calendar.getInstance();

		// 年、月、月を設定
		int year = 2014, month = 4, lastDay = 30;
		// 月初めの曜日を格納
		int week = 0;

		// 年、月をセットする
		cal.set(year, month - 1, cal.getActualMinimum(Calendar.DATE));
		// 月初めの曜日を取得
		week = cal.get(Calendar.DAY_OF_WEEK);
		// 年月を表示
		System.out.println(String.valueOf(year) + "年" + String.valueOf(month)
				+ "月");
		// 曜日を表示
		System.out.println(" 日 月 火 水 木 金 土");

		// 最後の日付まで繰り返す
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

			if (i < 10) {
				System.out.print("  " + i);
			} else {
				System.out.print(" " + i);
			}
			// 土曜日になったら改行する
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
		}
		System.out.println();
	}
}