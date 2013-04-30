package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "album")
@SuppressWarnings("serial")
public class Album implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(
            mappedBy = "album",
            cascade = {CascadeType.ALL}
    )
    private Set<Song> songs;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "band_id")
    private Band band;

    @Column(name = "art_url", nullable = false)
    private String artUrl;

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

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }
}
