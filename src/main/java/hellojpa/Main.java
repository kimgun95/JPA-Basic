package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member1 = new Member();
      member1.setUsername("kim");

      Member member2 = new Member();
      member2.setUsername("lee");

      Member member3 = new Member();
      member3.setUsername("park");

      System.out.println("=========================");
      em.persist(member1); // db seq -> 1, 51
      em.persist(member2); // 메모리에서 호출
      em.persist(member3); // 메모리에서 호출
      System.out.println("member1의 id 값: " + member1.getId());
      System.out.println("member2의 id 값: " + member2.getId());
      System.out.println("member3의 id 값: " + member3.getId());
      System.out.println("=========================");
      tx.commit();

    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}