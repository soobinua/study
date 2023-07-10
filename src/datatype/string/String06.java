package datatype.string;

public class String06 {

	public static void main(String[] args) {
		String birthday = "1970/01/01";
		String year = birthday.substring(0, 4); 	// substring(시작위치, 끝위치(미포함)) 번호 0부터 시작
		String monthAndDay = birthday.substring(5); // substring(시작위치)
		String day = birthday.substring(8);
		System.out.println("출생년도 : " + year);
		System.out.println("출생월일 : " + monthAndDay);
		System.out.println("출생일 : " + day);
	}

}
