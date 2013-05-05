package service;

import model.Band;

import java.util.List;

/**
 */
public interface BandService extends BaseService {

    public Long persistBand(Band band);

    public Band updateBand(Band band);

    public Band getBandWithId(Long id);

    public Band getBandWithName(String name);

    public List<Band> getAllBands();
}
