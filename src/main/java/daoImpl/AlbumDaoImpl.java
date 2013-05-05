package daoImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import dao.AlbumDao;
import model.Album;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class AlbumDaoImpl implements AlbumDao {

    @Inject
    private Provider<EntityManager> entityManager;

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Long persistAlbum(Album album) {
        entityManager.get().persist(album);
        return album.getId();
    }

    @Transactional
    public Album updateAlbum(Album album) {
        return entityManager.get().merge(album);
    }

    public Album getAlbumWithId(Long id) {
        TypedQuery<Album> query = entityManager.get().createQuery("from Album a where a.id = :id", Album.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Album> getAlbumsWithTitle(String title) {
        TypedQuery<Album> query = entityManager.get().createQuery("from Album a where a.title = :title", Album.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    public List<Album> getAllAlbums() {
        TypedQuery<Album> query = entityManager.get().createQuery("from Album a where a.id = :id", Album.class);
        return query.getResultList();
    }

}
