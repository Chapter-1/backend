package com.chapter1.blueprint.member.repository;


import com.chapter1.blueprint.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 생성자 injection
//    private final EntityManager em;

    // 저장
//    public String save(Member member) {
//        em.persist(member);
//        // 커맨드와 쿼리를 분리
//        return member.getId();
//    }
}
