package dao;

import java.util.List;

import model.Lyric;

/**
 * Interface for storing and retrieving {@link model.Lyric} instances
 * @author MDee
 *
 */
public interface LyricDao extends BaseDao {
    
    public Long persistLyric(Lyric lyric);
    
    public Lyric updateLyric(Lyric lyric);
    
    public Lyric getLyricWithId(Long id);
    
    public List<Lyric> getAllLyrics();
    
}
