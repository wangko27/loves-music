package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;


/**
 * @author MDee
 */
@Entity
@Table(name = "lyric")
@SuppressWarnings("serial")
public class Lyric implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "song_offset", nullable =  false)
    private Integer songOffset;

    @Column(name = "date_added", nullable = false)
    private Timestamp dateAdded;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "lyricist_id")
    private Lyricist lyricist;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "lyric_tag",
            joinColumns = {@JoinColumn(name = "lyric_id")},
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Lyricist getLyricist() {
        return lyricist;
    }

    public void setLyricist(Lyricist lyricist) {
        this.lyricist = lyricist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Integer getSongOffset() {
        return songOffset;
    }

    public void setSongOffset(Integer songOffset) {
        this.songOffset = songOffset;
    }

    @JsonIgnore
    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }
}
