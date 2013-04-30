package serviceImpl;

import com.google.inject.Inject;
import dao.BaseDao;
import dao.SongDao;
import model.Song;
import service.SongService;

import java.util.List;

/**
 */
public class SongServiceImpl implements SongService {

    @Inject
    private SongDao songDao;

    public Long persistSong(Song song) {
        return songDao.persistSong(song);
    }

    public Song updateSong(Song song) {
        return songDao.updateSong(song);
    }

    public Song getSongWith(Long id) {
        return songDao.getSongWithId(id);
    }

    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }

    public void setDao(BaseDao baseDao) {
        this.songDao = (SongDao) baseDao;
    }

    public BaseDao getDao() {
        return songDao;
    }
}
