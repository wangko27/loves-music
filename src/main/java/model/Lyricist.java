package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "lyric")
@SuppressWarnings("serial")
public class Lyricist implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "lyricist",
            cascade = {CascadeType.ALL}
    )
    private Set<Lyric> lyrics;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "lyricist_band",
            joinColumns = {@JoinColumn(name = "lyricist_id")},
            inverseJoinColumns = @JoinColumn(name = "band_id")
    )
    private Set<Band> bands;

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

    public Set<Lyric> getLyrics() {
        return lyrics;
    }

    public void setLyrics(Set<Lyric> lyrics) {
        this.lyrics = lyrics;
    }
}
