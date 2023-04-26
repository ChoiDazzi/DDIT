package chapter11;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		//날짜를 2024-04-05 수요일
		//미리 날짜 형식을 지정해서 사용
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD E요일");
		System.out.println(dateFormat.format(date));

		//날짜를 Singleton 형식으로 제공 
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH);
		int date2 = calendar.get(calendar.DATE);
		int day = calendar.get(calendar.DAY_OF_WEEK);
		
		//jdk 1.8부터 사용가능
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일")));
	}
}
