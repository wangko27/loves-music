package service;

import model.Song;

import java.util.List;

/**
 */
public interface SongService extends BaseService {

   public Long persistSong(Song song);

   public Song updateSong(Song song);

   public Song getSongWith(Long id);

   public Song getSongWithTitleAndAlbumTitle(String songTitle, String albumTitle);

   public List<Song> getAllSongs();
}
