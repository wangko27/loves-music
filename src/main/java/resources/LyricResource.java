package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import service.LyricService;
import com.google.inject.Inject;

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
        /*
         *  TODO: Connect DB so service can actually
         *  complete message operations 
         */ 
//        List<Lyric> messages = lyricService.getAllLyrics();
//        for (Lyric m : messages) {
//            logger.info(m.getTitle());
//        }
        return "Here's a static message: Hello World!";
    }
    
}