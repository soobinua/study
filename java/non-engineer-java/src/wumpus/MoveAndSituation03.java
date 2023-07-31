package wumpus;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MoveAndSituation03 { // 위험 요소를 만났을 때의 이벤트 처리

	public static int[] rooms = { 0, 1, 2, 3 };

	// 각 방에서 이동할 수 있는 방들의 목록을 표현한 통로
	public static int[][] links = { { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }, { 0, 1, 2 } };

	public static String BAT = "Bat";
	public static String PIT = "Pit";
	public static String WUMPUS = "Wumpus";
	public static String NOTHING = "Nothing";

	// 각 방에 배치된 위험요소
	public static String[] hazards = { NOTHING, BAT, PIT, WUMPUS };

	public static int currentRoom = 0; // 현재 방 번호

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("지금" + currentRoom + "번 방에 있습니다.");

			// 현재 방에서 갈 수 있는 방들의 목록
			int[] nextRooms = links[currentRoom];

			// 현재 방에서의 통로들 출력
			System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");
			System.out.println(Arrays.toString(nextRooms));

			// 이동할 방 번호 입력받기
			int roomNumber = scanner.nextInt();

			// 플레이어 이동 처리
			move(roomNumber);
		}
	}

	// 플레이어가 이동했을 때 이동과 그 뒤의 이벤트들을 처리하는 메소드
	// 이동을 하게 되면 그 방에 어떤 위험요소가 있는지 판단하고
	// 각 위험요소에 해당하는 이벤트 처리
	private static void move(int room) {
		// 입력한 방으로 이동
		currentRoom = room;

		// 현재 방에 위치한 위험요소
		String hazardInRoom = hazards[currentRoom];

		if (hazardInRoom.equals(WUMPUS)) { // 현재 방에 움퍼스가 있는 경우
			System.out.println("움퍼스에게 잡아먹혔습니다.");
		} else if (hazardInRoom.equals(PIT)) { // 현재 방에 구덩이가 있는 경우
			System.out.println("구덩이에 빠졌습니다.");
		} else if (hazardInRoom.equals(BAT)) { // 현재 방에 박쥐가 있는 경우
			System.out.println("박쥐가 당신을 잡아 다른 방에 떨어트렸습니다.");

			Random random = new Random();

			// 박쥐가 없는 방이 나올때까지 랜덤하게 방 선택
			do {
				currentRoom = random.nextInt(rooms.length);
			} while (hazards[currentRoom].equals(BAT));

			// 박쥐를 이동시키기 위해 원래 방의 박쥐는 먼저 제거
			// 플레이어가 이동할 방을 선택하는 것보다 박쥐를 먼저 제거하면
			// 플레이어가 제자리에 머무는 경우가 생기게 되므로
			// 플레이어가 이동할 위치를 먼저 선택한 후 박쥐 제거
			hazards[room] = NOTHING;

			// 플레이어를 이동시킨 후 플레이어가 있는 방이나
			// 또 다른 박쥐가 있는 방을 피해 박쥐 이동시킨다.
			while (true) {
				// 박쥐가 이동해갈 방을 랜덤하게 선택
				int newBatRoom = random.nextInt(rooms.length);

				// 선택된 방이 플레이어가 있는 방이라면
				// 반복문의 처음으로 되돌아가 방을 다시 선택
				if (newBatRoom == currentRoom) {
					continue;
				}

				// 선택된 방에 플레이어도 또 다른 위험요소도 없다면
				// 선택된 방에 박쥐 배치
				if (hazards[newBatRoom].equals(NOTHING)) {
					hazards[newBatRoom] = BAT;
					break;
				}
			}

			// 플레이어의 위치가 변경되었으므로 다시 한번
			// 해당 방으로 이동했을 때에 대한 이벤트 처리
			move(currentRoom);

		}

	}
}
