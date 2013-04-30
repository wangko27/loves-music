package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "band")
@SuppressWarnings("serial")
public class Band implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "lyricist_band",
            joinColumns = {@JoinColumn(name = "band_id")},
            inverseJoinColumns = @JoinColumn(name = "lyricist_id")
    )
    private Set<Lyricist> lyricists;

    @OneToMany(
            mappedBy = "band",
            cascade = {CascadeType.ALL}
    )
    private Set<Album> albums;

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Lyricist> getLyricists() {
        return lyricists;
    }

    public void setLyricists(Set<Lyricist> lyricists) {
        this.lyricists = lyricists;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}