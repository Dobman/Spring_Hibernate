package pl.coderslab.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.Entity.PersonDetails;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager em;

    public void save(PersonDetails personDetails) {
        this.em.persist(personDetails);
    }

    public PersonDetails findById(long id) {
        return this.em.find(PersonDetails.class, id);
    }

    public void delete(PersonDetails personDetails) {
        em.remove(em.contains(personDetails) ?
                em : em.merge(personDetails));
    }

    public void update(PersonDetails personDetails) {
        this.em.merge(personDetails);
    }

}