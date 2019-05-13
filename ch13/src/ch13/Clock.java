package ch13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	public String now() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");//date는 이거랑 같이써야함( 날짜형식 지정)
		return format.format(new Date());
		
	}
}
