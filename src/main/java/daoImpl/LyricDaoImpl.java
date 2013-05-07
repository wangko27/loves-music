package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Lyric;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import dao.LyricDao;

/**
 * Implementation of {@link dao.LyricDao} interface
 * @author MDee
 *
 */
public class LyricDaoImpl implements LyricDao {
    
    @Inject 
    private Provider<EntityManager> entityManager; 

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Long persistLyric(Lyric lyric) throws IllegalArgumentException {
        if (lyric.getText() == null) {
            throw new IllegalArgumentException("Lyric text cannot be null.");
        }
        entityManager.get().persist(lyric);
        return lyric.getId();
    }

    @Transactional
    public Lyric updateLyric(Lyric lyric) {
        return entityManager.get().merge(lyric);
    }

    public Lyric getLyricWithId(Long id) {
        TypedQuery<Lyric> query = entityManager.get().createQuery("from Lyric l where l.id = :id", Lyric.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Lyric> getAllLyrics() {
        TypedQuery<Lyric> query = entityManager.get().createQuery("from Lyric l order by l.id desc", Lyric.class);
        return query.getResultList();
    }

}
