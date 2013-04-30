package dao;

import model.Band;

import java.util.List;

/**
 */
public interface BandDao extends BaseDao {

    public Long persistBand(Band band);

    public Band updateBand(Band band);

    public Band getBandWithId(Long id);

    public List<Band> getAllBands();
}
