package daoImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import dao.BandDao;
import model.Band;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class BandDaoImpl implements BandDao {

    @Inject
    private Provider<EntityManager> entityManager;

    @Transactional
    public Long persistBand(Band band) {
        entityManager.get().persist(band);
        return band.getId();
    }

    @Transactional
    public Band updateBand(Band band) {
        return entityManager.get().merge(band);
    }

    public Band getBandWithId(Long id) {
        TypedQuery<Band> query = entityManager.get().createQuery("from Band b where b.id = :id", Band.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Band> getAllBands() {
        TypedQuery<Band> query = entityManager.get().createQuery("from Band b", Band.class);
        return query.getResultList();
    }

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }
}
