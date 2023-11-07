package chap16_1107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();	//날짜 관련 클래스
		LocalTime Time = LocalTime.now();	//시간 관련 클래스
		LocalDateTime dt = LocalDateTime.now();	//날짜와 시간을 모두 가지는 클래스
		
		System.out.println("오늘의 날짜 : "+ date);
		System.out.println("현재의 시간 : "+ Time);
		System.out.println("현재의 날짜와 시간 : "+ dt);
		
		String s = dt.getYear()+ "년 ";
		s += dt.getMonthValue()+ "월 ";
		s += dt.getDayOfMonth()+ "일 ";
		s += dt.getDayOfWeek()+ " ";
		s += dt.getHour()+ "시 ";
		s += dt.getMinute()+ "분" ;
		s += dt.getSecond() + "초 ";
		System.out.println("현재의 날짜와 시간 : " +s);
		
		System.out.println("오늘부터 100일 기념일은 : "+date.plusDays(100));
		System.out.println("오늘부터 10주 후의 날짜는 : "+date.plusWeeks(10));
	}

}
//책 646