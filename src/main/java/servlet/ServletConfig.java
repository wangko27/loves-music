package servlet;

import java.util.HashMap;
import java.util.Map;

import dao.*;
import daoImpl.*;
import resources.LyricResource;
import service.*;
import serviceImpl.*;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class ServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        
        return Guice.createInjector(new ServletModule() {
            
            @Override
            protected void configureServlets() {
                Map<String, String> params = new HashMap<String, String>();
                
                // Bindings
                bind(LyricResource.class);
                bind(LyricDao.class).to(LyricDaoImpl.class);
                bind(LyricService.class).to(LyricServiceImpl.class);
                bind(BandDao.class).to(BandDaoImpl.class);
                bind(BandService.class).to(BandServiceImpl.class);
                bind(AlbumDao.class).to(AlbumDaoImpl.class);
                bind(AlbumService.class).to(AlbumServiceImpl.class);
                bind(SongDao.class).to(SongDaoImpl.class);
                bind(SongService.class).to(SongServiceImpl.class);
                bind(LyricistDao.class).to(LyricistDaoImpl.class);
                bind(LyricistService.class).to(LyricistServiceImpl.class);
                bind(TagDao.class).to(TagoDaoImpl.class);
                bind(TagService.class).to(TagServiceImpl.class);
                
                serve("/*").with(GuiceContainer.class, params);
                filter("/*").through(PersistFilter.class);
            }
            
        },  new JpaPersistModule("lovesMusicJpaUnit"));
    }

}
