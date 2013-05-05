package dao;

import model.Tag;

import java.util.List;

/**
 */
public interface TagDao extends BaseDao {

   public Long persistTag(Tag tag);

   public Tag updateTag(Tag tag);

   public Tag getTagWithId(Long id);

   public List<Tag> getAllTags();

   public Tag getTagWithName(String name);

}
