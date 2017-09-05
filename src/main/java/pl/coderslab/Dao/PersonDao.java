package pl.coderslab.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.Entity.Person;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Person person) {
        this.em.persist(person);
    }

    public Person findById(long id) {
        return this.em.find(Person.class, id);
    }

    public void delete(Person person) {
        em.remove(em.contains(person) ?
                em : em.merge(person));
    }

    public void update(Person person) {
        this.em.merge(person);
    }

}