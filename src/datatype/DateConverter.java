package datatype;

public class DateConverter {

	public static void main(String[] args) {
		// 1970/01/23 날짜 형식의 문자열에서 년, 월, 일 잘라 "1970년 01월 23일" 문자열 만들어 출력

		String date = "1970/01/23";
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8);
		System.out.println(year + "년 " + month + "월 " + day + "일");

	}

}
