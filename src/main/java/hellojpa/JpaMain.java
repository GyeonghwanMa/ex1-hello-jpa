package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 하나만 생성
        EntityManager em = emf.createEntityManager(); // 요청 올 경우에 생성 - 쓰레드 간에 공유 X

        EntityTransaction tx = em.getTransaction(); // 데이터 변경은 트랜잭션 안에서 실행
        tx.begin();

        try {

            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }
        emf.close();
    }
}
