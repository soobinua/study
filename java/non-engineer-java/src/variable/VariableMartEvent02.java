package variable;

public class VariableMartEvent02 {// 변수의 필요성

	public static void main(String[] args) {
		// 마트 매달 15일 물건 구매하면 15% 적립금 추가로 적립 이벤트
		// 마트에서 날짜를 13일로 바꾸고 적립금을 13%로 줄이겠다고 한다면
		// 이전에는 각 숫자를 찾아 모두 바꿔야했다면
		// 변수 사용 시 변수 값만 변경하면 된다.

		int ratio = 13; // 변수 사용 시 변수 값만 변경하면 된다.

		System.out.println(100 * ratio / 100.0);
		System.out.println(300 * ratio / 100.0);
		System.out.println(1000 * ratio / 100.0);
		System.out.println(1000 * ratio / 100.0);

	}

}
