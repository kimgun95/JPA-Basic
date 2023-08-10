package hellojpa;

import java.util.List;

import hellojpa.domain.Address;
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
      Member member1 = new Member("gun");
      Member member2 = new Member("graves");
      Member member3 = new Member("lee");
      Team teamA = new Team("A");
      Team teamB = new Team("B");
      member1.setTeam(teamA);
      member2.setTeam(teamA);
      member3.setTeam(teamB);

      em.persist(member1);
      em.persist(member2);
      em.persist(member3);
      em.persist(teamA);
      em.persist(teamB);

      em.flush();
      em.clear();

      String jpql = "select t from Team t";
      List<Team> result = em.createQuery(jpql, Team.class)
          .setFirstResult(0)
          .setMaxResults(2)
          .getResultList();

      System.out.println("result = " + result.size());

      for (Team team : result) {
        System.out.println("team = " + team.getName() + " members = " + team.getMembers().size());
        for (Member member : team.getMembers()) {
          System.out.println("-> member = " + member);
        }
      }

    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }
}