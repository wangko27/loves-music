package dao;

import model.Album;

import java.util.List;

/**
 */
public interface AlbumDao extends BaseDao {

    public Long persistAlbum(Album album);

    public Album updateAlbum(Album album);

    public Album getAlbumWithId(Long id);

    public List<Album> getAlbumsWithTitle(String title);

    public List<Album> getAllAlbums();

}
