package datatype.string;

public class String05 {

	public static void main(String[] args) {
		String fat = "치킨은 살 안 쪄요. 살은 내가 쪄요.";
		String replaced = fat.replaceAll("내가", "네가"); // replaceAll("바꿀 문자열", "새 문자열")
		System.out.println(replaced);

	}

}
