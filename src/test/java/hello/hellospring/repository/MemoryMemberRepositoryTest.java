package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

//참고. TDD 테스트 주도 개발 Test Driven Development. 테스트 먼저 개발 후 구현 클래스 생성
class MemoryMemberRepositoryTest { //각각 독립적으로 실행되어야 한다. 테스트 순서에 의존적으로 설계하지 않는다.

	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach //각 테스트 메소드 실행 이후 실행
	public void afterEach() { //주로 사용되고 난 후 종료되어야할 리소스 처리
		repository.clearStore(); //메모리 DB에 저장된 데이터 삭제
	}
	
	@Test
	public void save() {
		//given
		Member member = new Member();
		member.setName("spring");

		//when
		repository.save(member);

		//then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		//when
		Member result = repository.findByName("spring1").get();

		//then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		//when
		List<Member> result = repository.findAll();
		
		//then
		assertThat(result.size()).isEqualTo(2);
	}

}
