package pl.coderslab.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.Entity.Publisher;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Publisher publisher) {
        this.em.persist(publisher);
    }

    public Publisher findById(long id) {
        return this.em.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        em.remove(em.contains(publisher) ?
                em : em.merge(publisher));
    }

    public void update(Publisher publisher) {
        this.em.merge(publisher);
    }

}