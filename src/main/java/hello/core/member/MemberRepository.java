package hello.core.member;

public interface MemberRepository { // 인터페이스 (역할)

    void save(Member member);       // 회원 저장

    Member findById(Long memberId); // 회원 찾기
}
