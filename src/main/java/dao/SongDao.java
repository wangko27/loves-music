package dao;

import model.Song;

import java.util.List;

/**
 */
public interface SongDao extends BaseDao {

    public Long persistSong(Song song);

    public Song updateSong(Song song);

    public Song getSongWithId(Long id);

    public List<Song> getSongsWithTitle(String title);

    public List<Song> getAllSongs();

}
