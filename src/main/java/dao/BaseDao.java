package dao;

import javax.persistence.EntityManager;

import com.google.inject.Provider;

/**
 * Basic DAO interface
 * @author MDee
 *
 */
public interface BaseDao {

    public Provider<EntityManager> getEntityManager();

    public void setEntityManager(Provider<EntityManager> entityManager);
}
