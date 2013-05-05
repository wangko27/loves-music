package serviceImpl;

import com.google.inject.Inject;
import dao.AlbumDao;
import dao.BaseDao;
import model.Album;
import service.AlbumService;

import java.util.List;

/**
 */
public class AlbumServiceImpl implements AlbumService {

    @Inject
    private AlbumDao albumDao;

    public Long persistAlbum(Album album) {
        return albumDao.persistAlbum(album);
    }

    public Album updateAlbum(Album album) {
        return albumDao.updateAlbum(album);
    }

    public Album getAlbumWithId(Long id) {
        return albumDao.getAlbumWithId(id);
    }

    public Album getAlbumWithTitleAndBandName(String title, String bandName) {
        List<Album> albumsWithTitle = albumDao.getAlbumsWithTitle(title);
        Album albumToReturn = null;
        for (Album album : albumsWithTitle) {
            if (album.getBand().getName().equals(bandName)) {
                albumToReturn = album;
                break;
            }
        }
        return albumToReturn;
    }

    public List<Album> getAllAlbums() {
        return albumDao.getAllAlbums();
    }

    public void setDao(BaseDao baseDao) {
        this.albumDao = (AlbumDao) baseDao;
    }

    public BaseDao getDao() {
        return albumDao;
    }
}
