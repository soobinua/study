package operator;

public class OperatorEggPackage {

	public static void main(String[] args) {
		// 양계장 닭이 낳은 알 277개
		// 한 판에 30개의 달걀이 포장된다고 할 때 계란판에 포장되고 남은 계란 수 출력

		int totalEggs = 277; // 총 달걀
		int eggCartonSize = 30; // 한 판에 포장되는 달걀

		// totalEgges를 eggCartonSize로 나눈 나머지 계산
		int remainingEggs = totalEggs % eggCartonSize;

		System.out.println("남은 계란의 수는 " + remainingEggs + "개 입니다.");
	}

}
