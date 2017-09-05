package pl.coderslab.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.Entity.Author;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Author author) {
        this.em.persist(author);
    }

    public Author findById(long id) {
        return this.em.find(Author.class, id);
    }

    public void delete(Author author) {
        em.remove(em.contains(author) ?
                em : em.merge(author));
    }

    public void update(Author author) {
        this.em.merge(author);
    }

}