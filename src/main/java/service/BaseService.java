package service;

import dao.BaseDao;

/**
 * Basic interface for services
 * @author MDee
 *
 */
public interface BaseService {

    public void setDao(BaseDao baseDao);
    
    public BaseDao getDao();
}
