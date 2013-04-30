package serviceImpl;

import com.google.inject.Inject;
import dao.BandDao;
import dao.BaseDao;
import model.Band;
import service.BandService;

import java.util.List;

/**
 */
public class BandServiceImpl implements BandService {

    @Inject
    private BandDao bandDao;

    public Long persistBand(Band band) {
        return bandDao.persistBand(band);
    }

    public Band updateBand(Band band) {
        return bandDao.updateBand(band);
    }

    public Band getBandWithId(Long id) {
        return bandDao.getBandWithId(id);
    }

    public List<Band> getAllBands() {
        return bandDao.getAllBands();
    }

    public void setDao(BaseDao baseDao) {
        this.bandDao = (BandDao) baseDao;
    }

    public BaseDao getDao() {
        return bandDao;
    }
}
