package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import org.apache.log4j.Logger;
import service.*;
import com.google.inject.Inject;

import java.sql.Timestamp;
import java.util.List;

/**
 * Resource to access {@link model.Lyric} instances
 * @author MDee
 *
 */
@Path("/lyric")
public class LyricResource {

    private static final Logger logger = Logger.getLogger(LyricResource.class);
    
    @Inject
    private LyricService lyricService;
    @Inject
    private BandService bandService;
    @Inject
    private SongService songService;
    @Inject
    private AlbumService albumService;
    @Inject
    private LyricistService lyricistService;
    @Inject
    private TagService tagService;
    
    @GET
    @Produces("text/plain")
    public String handleGreeting() {
        return "Here's a static message: Hello World!";
    }

    @GET
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public Response getAllLyrics() {
        List<Lyric> lyrics = lyricService.getAllLyrics();
        return Response.ok().entity(lyrics).build();
    }

    @GET
    @Path("/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response addNewLyricGet() {
        return Response.status(200)
                .build();
    }

    @OPTIONS
    @Path("/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response addNewLyricOptions() {
        return Response.status(200)
                .build();
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addNewLyric(Lyric lyric) {
        // Lyric has lyricst, album, band
        System.out.println("Got somefin");
        System.out.println(lyric);
        lyric.setDateAdded(new Timestamp(System.currentTimeMillis()));
        // Take care of Band
        Band lyricBand = bandService.getBandWithName(lyric.getSong().getAlbum().getBand().getName());
        if (lyricBand == null) {
            // persist it
            lyricBand = lyric.getSong().getAlbum().getBand();
            bandService.persistBand(lyricBand);
        }
        // Then album
        Album lyricAlbum = albumService.getAlbumWithTitleAndBandName(lyric.getSong().getAlbum().getTitle(), lyricBand.getName());
        if (lyricAlbum == null) {
            lyricAlbum = lyric.getSong().getAlbum();
            lyricAlbum.setBand(lyricBand);
            albumService.persistAlbum(lyricAlbum);
        }
        // Then song
        Song lyricSong = songService.getSongWithTitleAndAlbumTitle(lyric.getSong().getTitle(), lyricAlbum.getTitle());
        if (lyricSong == null) {
            lyricSong = lyric.getSong();
            lyricSong.setAlbum(lyricAlbum);
            songService.persistSong(lyricSong);
        }
        // Now lyricist
        Lyricist lyricist = lyricistService.getLyricistWithName(lyric.getLyricist().getName());
        if (lyricist == null) {
            lyricist = lyric.getLyricist();
            lyricistService.persistLyricist(lyricist);
        }
        // Tagz
        for (Tag tag : lyric.getTags()) {
            Tag existingTag = tagService.getTagWithName(tag.getName());
            if (existingTag == null) {
                tagService.persistTag(tag);
            }
        }
        // Lyric yo
        lyric.setSong(lyricSong);
        lyric.setLyricist(lyricist);
        lyricService.persistLyric(lyric);
        return Response.status(200).entity("Persisted new lyric with ID " + lyric.getId())
                .build();
    }

    
}