package datatype;

public class AgeOfDogs {

	public static void main(String[] args) {
		// 원터 올해 3살 강아지
		// 맥스 올해 7살 강아지
		// 강아지들의 나이를 변수들로 선언하고 변수들 이용해 질문들의 참 또는 거짓 여부 출력

		int ageOfWinter = 3;
		int ageOfMax = 7;

		boolean sameAge = ageOfWinter == ageOfMax;
		boolean winterIsOlder = ageOfWinter > ageOfMax;
		boolean maxIsOlder = ageOfMax > ageOfWinter;

		System.out.println("윈터의 나이가 맥스의 나이와 같은가? : " + sameAge);
		System.out.println("윈터의 나이가 맥스의 나이보다 많은가? : " + winterIsOlder);
		System.out.println("맥스의 나이가 원터의 나이보다 많은가? : " + maxIsOlder);

	}

}
