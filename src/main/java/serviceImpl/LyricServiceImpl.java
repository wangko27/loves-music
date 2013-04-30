package serviceImpl;

import java.util.List;

import model.Lyric;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import dao.BaseDao;
import dao.LyricDao;
import service.LyricService;

public class LyricServiceImpl implements LyricService {

    @Inject
    private LyricDao lyricDao;
    
    private static final Logger logger = Logger.getLogger(LyricService.class);
    
    public BaseDao getDao() {
        return lyricDao;
    }

    public void setDao(BaseDao baseDao) {
        this.lyricDao = (LyricDao) baseDao;
    }

    public Long persistLyric(Lyric lyric) {
        return lyricDao.persistLyric(lyric);
    }

    public Lyric updateLyric(Lyric lyric) {
        return lyricDao.updateLyric(lyric);
    }

    public Lyric getLyricWithId(Long id) {
        return lyricDao.getLyricWithId(id);
    }
    
    public List<Lyric> getAllLyrics() {
        return lyricDao.getAllLyrics();
    }

}
