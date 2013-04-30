package resources;

import com.google.inject.Inject;
import model.Band;
import model.Lyric;
import org.apache.log4j.Logger;
import service.BandService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Resource to access {@link model.Band} instances
 * @author MDee
 *
 */
@Path("/band")
public class BandResource {

    private static final Logger logger = Logger.getLogger(BandResource.class);
    
    @Inject
    private BandService bandService;

    @GET
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllBands() {
        List<Band> bands = bandService.getAllBands();
        return Response.ok().entity(bands).build();
    }
    
}