package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Lyric;
import org.apache.log4j.Logger;
import service.LyricService;
import com.google.inject.Inject;

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
    
    @GET
    @Produces("text/plain")
    public String handleGreeting() {
        return "Here's a static message: Hello World!";
    }

    @GET
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllLyrics() {
        List<Lyric> lyrics = lyricService.getAllLyrics();
        return Response.ok().entity(lyrics).build();
    }

    
}