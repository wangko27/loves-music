package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "song")
@SuppressWarnings("serial")
public class Song implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(
            mappedBy = "song",
            cascade = {CascadeType.ALL}
    )
    private Set<Lyric> lyrics;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "album_id")
    private Album album;

    @Column(name="url", nullable = false)
    private String url;

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
