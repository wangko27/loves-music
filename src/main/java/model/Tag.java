package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author MDee
 */
@Entity
@Table(name = "tag")
@SuppressWarnings("serial")
public class Tag implements Serializable {

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
            name = "lyric_tag",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = @JoinColumn(name = "lyric_id")
    )
    private Set<Lyric> lyrics;

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

    public void setLyrics(Set<Lyric> lyrics) {
        this.lyrics = lyrics;
    }
}
