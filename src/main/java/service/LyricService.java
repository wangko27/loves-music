package service;

import java.util.List;

import model.Lyric;

/**
 * Simple service for {@link model.Lyric} operations
 * @author MDee
 *
 */
public interface LyricService extends BaseService {

    public Long persistLyric(Lyric lyric);
    
    public Lyric updateLyric(Lyric lyric);
    
    public Lyric getLyricWithId(Long id);
    
    public List<Lyric> getAllLyrics();
}
