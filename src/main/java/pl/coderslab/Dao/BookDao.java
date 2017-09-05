package pl.coderslab.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.Entity.Book;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Book book) {
        this.em.persist(book);
    }

    public Book findById(long id) {
        return this.em.find(Book.class, id);
    }

    public void delete(Book book) {
        em.remove(em.contains(book) ?
                em : em.merge(book));
    }

    public void update(Book book) {
        this.em.merge(book);
    }

    public List<Book> all(){
        Query query = em.createQuery("select b from Book b");
        return (List<Book>)query.getResultList();
    }


}