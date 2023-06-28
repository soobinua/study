package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

//정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다
//스프링 빈 등록 - 자바 코드
@Configuration
public class SpringConfig {
	//향후 MemoryMemberRepository를 다른 리포지토리로 변경할 예정이므로, 컴포넌트 스캔 방식 대신에 자바 코드로 스프링 빈을 설정

	private final DataSource dataSource; //데이터베이스 커넥션을 획득할 때 사용하는 객체
	
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		//개방-폐쇄 원칙(OCP, Open-Closed Principle) : 확장에는 열려있고, 수정, 변경에는 닫혀있다.
		//스프링 DI 사용하면 기존 코드 전혀 수정하지 않고 설정만으로 구현 클래스 변경 가능
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}
