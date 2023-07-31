package datatype.realnumber;

public class RealNumberData02 {

	public static void main(String[] args) {
		float floatNumber = 0.001f + 0.001f + 0.0001f;
		System.out.println(floatNumber); // 0.0021000002

		// 컴퓨터에서 실수를 표현하는 방법의 한계로 소수점 아래에서 아주 정확한 값 표현 X
		// 컴퓨터 실수형 아주 세밀하게 정확한 값 계산 X (ex.돈 계산처럼 정확한 계산 필요한 경우 실수형 사용 X)
		// 0.001 + 0.001 + 0.0001 = 0.0021
	}

}
