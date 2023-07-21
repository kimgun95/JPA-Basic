package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.Team;

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

      Member member = new Member();
      member.setName("gun kim");
      em.persist(member);

      em.flush();
      em.clear();

      Member referenceMember = em.getReference(Member.class, member.getId());
      System.out.println("referenceMember " + referenceMember.getClass());

      em.detach(referenceMember);

      referenceMember.getName();


      //
      // Member findMember = em.find(Member.class, member.getId());
      // System.out.println("findMember " + findMember.getClass());

    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }
}