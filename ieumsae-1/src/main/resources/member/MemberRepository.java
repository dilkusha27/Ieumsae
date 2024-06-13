package member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 스프링이 클래스를 리포지토리 빈으로 인식하게 한다.
public interface MemberRepository extends JpaRepository<MemberModel, Long> {
    boolean existsByUserId(String userId); // userId가 DB에 존재하는지 여부를 확인
}
// save(), findById(), findAll(), deleteById() 사용 가능
