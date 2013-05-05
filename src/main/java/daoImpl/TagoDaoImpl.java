package daoImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import dao.TagDao;
import model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class TagoDaoImpl implements TagDao {

    @Inject
    private Provider<EntityManager> entityManager;

    @Transactional
    public Long persistTag(Tag tag) {
        entityManager.get().persist(tag);
        return tag.getId();
    }

    @Transactional
    public Tag updateTag(Tag tag) {
        return entityManager.get().merge(tag);
    }

    public Tag getTagWithId(Long id) {
        TypedQuery<Tag> query = entityManager.get().createQuery("from Tag t where t.id = :id", Tag.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Tag> getAllTags() {
        TypedQuery<Tag> query = entityManager.get().createQuery("from Tag t", Tag.class);
        return query.getResultList();
    }

    public Tag getTagWithName(String name) {
        TypedQuery<Tag> query = entityManager.get().createQuery("from Tag t where t.name = :name", Tag.class);
        query.setParameter("name", name);
        Tag existingTag = null;
        try {
            existingTag = query.getSingleResult();
        } catch (NoResultException nre) {
            // Nothin.
        }
        return existingTag;
    }

    public Provider<EntityManager> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }
}
