package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member) throws SQLException;
    Optional<Member> findById(Long id); // null을 반환할때 옵셔널로 null을 반환한다
    Optional<Member> findByName(String name);
    List<Member> findAll();
    void clearStore();
}
