package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.apache.catalina.Session;
import org.apache.catalina.Store;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Transactional
public class MemberService {
    /**
     * 회원가입
     */
    public Long join(Member member) throws IOException {
        long start = System.currentTimeMillis();
        try {
            validateDuplicateMember(member); //중복 회원 검증
            Store memberRepository = null;
            memberRepository.save((Session) member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try {
            Scanner memberRepository = null;
            return (List<Member>) memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }
}
