package ch13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	public String now() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");//date�� �̰Ŷ� ���̽����( ��¥���� ����)
		return format.format(new Date());
		
	}
}
