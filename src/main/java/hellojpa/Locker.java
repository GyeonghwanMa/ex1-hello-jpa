package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {
    @Id @GeneratedValue
    private Long Id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
