package method;

public class RecursionFailure {

	public static void main(String[] args) {
		recursion();
	}

	public static void recursion() {
		System.out.println("인셉션 시도");
		recursion(); // 메소드 안에서 자기 자신 호출 (재귀함수)
		// Exception in thread "main" java.lang.StackOverflowError
		// 재귀함수는 같은 메소드를 무한히 반복해 호출하다 프로그램 죽어버릴 수 있다.
	}
}
