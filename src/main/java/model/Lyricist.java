package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "lyricist")
@SuppressWarnings("serial")
public class Lyricist implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pic_url", nullable = true)
    private String picUrl;

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

    @JsonIgnore
    public Set<Lyric> getLyrics() {
        return lyrics;
    }

    @JsonIgnore
    public void setLyrics(Set<Lyric> lyrics) {
        this.lyrics = lyrics;
    }

    @JsonIgnore
    public Set<Band> getBands() {
        return bands;
    }

    public void setBands(Set<Band> bands) {
        this.bands = bands;
    }

    @JsonIgnore
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
