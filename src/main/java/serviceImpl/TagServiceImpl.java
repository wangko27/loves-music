package serviceImpl;

import com.google.inject.Inject;
import dao.BaseDao;
import dao.TagDao;
import model.Tag;
import service.TagService;

import java.util.List;

/**
 */
public class TagServiceImpl implements TagService {

    @Inject
    private TagDao tagDao;

    public Long persistTag(Tag tag) {
        return tagDao.persistTag(tag);
    }

    public Tag updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    public Tag getTagWithId(Long id) {
        return tagDao.getTagWithId(id);
    }

    public Tag getTagWithName(String name) {
        return tagDao.getTagWithName(name);
    }

    public List<Tag> getAllTags() {
        return tagDao.getAllTags();
    }

    public void setDao(BaseDao baseDao) {
        this.tagDao = (TagDao) baseDao;
    }

    public BaseDao getDao() {
        return tagDao;
    }
}
