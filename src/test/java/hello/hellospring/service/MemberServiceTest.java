package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach //각 테스트 메소드 실행 전 호출
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository(); //테스트가 서로 영향이 없도록 항상 새로운 객체 생성
		memberService = new MemberService(memberRepository); //DI Dependency Injection 의존관계도 새로 맺어준다.
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	public void join() throws Exception {//테스트 메소드명 한글 가능
		//Given
		Member member = new Member();
		member.setName("hello");

		//When
		Long saveId = memberService.join(member);

		//Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void validateDuplicateMember() throws Exception {
		//Given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");

		//When
		memberService.join(member1);
		
		//Then
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 예외가 발생해야 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
}
