package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager entityManager = emf.createEntityManager();

    EntityTransaction tx = entityManager.getTransaction();
    tx.begin();

    try {
//      Member member = new Member();
//      member.setId(1L);
//      member.setName("gun");
//
//      entityManager.persist(member);

//      Member member1 = entityManager.find(Member.class, 1L);
//      entityManager.clear();
//      Member member2 = entityManager.find(Member.class, 1L);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      entityManager.close();
    }

    emf.close();
  }
}