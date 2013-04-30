import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import servlet.ServletConfig;

import com.google.inject.servlet.GuiceFilter;

/**
 * This class is used when running an embedded Jetty instance
 * @author MDee
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //   Create the server.
        Server server = new Server(8080);

        // Create a servlet context and add the jersey servlet.
        ServletContextHandler sch = new ServletContextHandler(server, "/");

        // Add our Guice listener that includes our bindings
        sch.addEventListener(new ServletConfig());

        // Then add GuiceFilter and configure the server to 
        // reroute all requests through this filter. 
        sch.addFilter(GuiceFilter.class, "/*", null);

        // Must add DefaultServlet for embedded Jetty. 
        // Failing to do this will cause 404 errors.
        sch.addServlet(DefaultServlet.class, "/");

        // Start the server
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}