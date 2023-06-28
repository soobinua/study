package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

//JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
@Transactional //스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커밋. 만약 런타임 예외가 발생하면 롤백
public class MemberService {

	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/**
	 * 회원가입
	 */
	public Long join(Member member) {
		validateDuplicateMember(member); //중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {//같은 이름 있는 중복 회원 X
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
