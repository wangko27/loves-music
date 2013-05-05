package serviceImpl;

import com.google.inject.Inject;
import dao.BaseDao;
import dao.LyricistDao;
import model.Lyricist;
import service.LyricistService;

import java.util.List;

/**
 */
public class LyricistServiceImpl implements LyricistService {

    @Inject
    private LyricistDao lyricistDao;

    public Long persistLyricist(Lyricist lyricist) {
        return lyricistDao.persistLyricist(lyricist);
    }

    public Lyricist updateLyricist(Lyricist lyricist) {
        return lyricistDao.updateLyricist(lyricist);
    }

    public Lyricist getLyricistWithId(Long id) {
        return lyricistDao.getLyricistWithId(id);
    }

    public Lyricist getLyricistWithName(String name) {
        return lyricistDao.getLyricistWithName(name);
    }

    public List<Lyricist> getAllLyricists() {
        return lyricistDao.getAllLyricists();
    }

    public void setDao(BaseDao baseDao) {
        this.lyricistDao = (LyricistDao) baseDao;
    }

    public BaseDao getDao() {
        return lyricistDao;
    }
}
