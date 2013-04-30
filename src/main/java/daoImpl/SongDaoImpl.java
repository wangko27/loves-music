package daoImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import dao.SongDao;
import model.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class SongDaoImpl implements SongDao {

    @Inject
    private Provider<EntityManager> entityManager;

    @Transactional
    public Long persistSong(Song song) {
        entityManager.get().persist(song);
        return song.getId();
    }

    @Transactional
    public Song updateSong(Song song) {
        return entityManager.get().merge(song);
    }

    public Song getSongWithId(Long id) {
        TypedQuery<Song> query = entityManager.get().createQuery("from Song s where s.id = :id", Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Song> getAllSongs() {
        TypedQuery<Song> query = entityManager.get().createQuery("from Song s", Song.class);
        return query.getResultList();
    }

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }
}
