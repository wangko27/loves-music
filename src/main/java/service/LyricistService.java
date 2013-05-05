package service;

import model.Lyricist;

import java.util.List;

/**
 */
public interface LyricistService extends BaseService {

    public Long persistLyricist(Lyricist lyricist);

    public Lyricist updateLyricist(Lyricist lyricist);

    public Lyricist getLyricistWithId(Long id);

    public Lyricist getLyricistWithName(String name);

    public List<Lyricist> getAllLyricists();
}
