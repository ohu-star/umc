package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity //이 class가 JPA entity임을 나타낸다. 데베 테이블과 매핑됨
@Getter //클래스의 모든 필드에 대한 getter 메서드 자동 생성
@Builder //빌더 패턴 클래스 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) //매개변수 없는 기본 생성자.
@AllArgsConstructor(access = AccessLevel.PUBLIC) //모든 필드를 매개변수로 받는 생성자.
public class Food extends BaseEntity {

    @Id //해당 필드를 엔티티의 기본 키로 설정
    //기본 키값을 자동으로 생성. AUTO_INCREMENT를 통해 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    //음식 카테고리는 보통 수정/삭제를 잘 하지 않으므로 양방향 매핑을 하지 않아도 됨
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}