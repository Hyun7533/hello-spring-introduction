package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest { // 순서와 상관없이 테스트가 실행된다. 순서에 의존해서 설계하면 안된다.

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { // 메서드가 끝날때마다 이 메서드가 동작한다. callback
        repository.clearStore();
    }

    @Test // 실행이 가능해진다
    public void save() {
        Member member = new Member();
        member.setName("teaHyun");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();// optional은 get으로 꺼낼수있따
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
