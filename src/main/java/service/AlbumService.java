package service;

import model.Album;

import java.util.List;

/**
 */
public interface AlbumService extends BaseService {

    public Long persistAlbum(Album album);

    public Album updateAlbum(Album album);

    public Album getAlbumWithId(Long id);

    public List<Album> getAllAlbums();

}
