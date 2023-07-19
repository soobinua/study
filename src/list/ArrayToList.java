package list;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		// 배열을 List로 변환 - Arrays.asList(배열)
		Integer[] integerArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		List<Integer> integerList = Arrays.asList(integerArray);

		System.out.println(integerList);
	}
}
