package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	//스프링 데이터 JPA 기본 CRUD 기능 제공
	//참고. 복잡한 동적 쿼리 Querydsl 라이브러리 사용하면 된다.
	//Querydsl 사용하면 쿼리도 자바 코드로 안전하게 작성 및 동적 쿼리 편리하게 작성 가능
	//JPA + Querydsl 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리 사용 또는 JdbcTemplate 사용
	
	//JPQL select m from Member m where m.name = ?
	@Override
	Optional<Member> findByName(String name);
}
