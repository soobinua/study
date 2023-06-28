package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행
@Transactional //테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백. DB에 데이터 남지 않아 다음 테스트에 영향 주지 않는다.
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;

	@Test
	public void join() throws Exception {
		//Given
		Member member = new Member();
		member.setName("spring");

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
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//예외가 발생해야 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
}
