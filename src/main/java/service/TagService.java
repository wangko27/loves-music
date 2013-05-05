package service;

import model.Tag;

import java.util.List;

/**
 */
public interface TagService extends BaseService {

    public Long persistTag(Tag tag);

    public Tag updateTag(Tag tag);

    public Tag getTagWithId(Long id);

    public Tag getTagWithName(String name);

    public List<Tag> getAllTags();
}
