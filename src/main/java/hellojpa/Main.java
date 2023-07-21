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

      Book book = new Book();
      book.setName("CODE");
      book.setAuthor("찰스 펫졸드");

      em.persist(book);

      tx.commit();



    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}