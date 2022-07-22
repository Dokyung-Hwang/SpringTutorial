package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Smile:DK");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("Result = " + (result == member));
        Assertions.assertEquals(result, member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");;
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");;
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertEquals(result, member1);
    }
}
