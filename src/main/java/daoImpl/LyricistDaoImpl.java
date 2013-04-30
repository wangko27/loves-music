package daoImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import dao.LyricistDao;
import model.Lyricist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class LyricistDaoImpl implements LyricistDao {

    @Inject
    private Provider<EntityManager> entityManager;

    @Transactional
    public Long persistLyricist(Lyricist lyricist) {
        entityManager.get().persist(lyricist);
        return lyricist.getId();
    }

    @Transactional
    public Lyricist updateLyricist(Lyricist lyricist) {
        return entityManager.get().merge(lyricist);
    }

    public Lyricist getLyricistWithId(Long id) {
        TypedQuery<Lyricist> query = entityManager.get().createQuery("from Lyricist l where l.id = :id", Lyricist.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Lyricist> getAllLyricists() {
        TypedQuery<Lyricist> query = entityManager.get().createQuery("from Lyricist l", Lyricist.class);
        return query.getResultList();
    }

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }
}
