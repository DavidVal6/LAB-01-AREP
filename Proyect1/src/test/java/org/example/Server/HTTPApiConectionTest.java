package org.example.Server;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTTPApiConectionTest {

    @Test
    public void ShouldFormatTheName(){
        HTTPApiConection httpApiConection = new HTTPApiConection();
        httpApiConection.movieNameSetter("Guardians of the galaxy");
        String name = httpApiConection.getMovieName();
        assertEquals("Guardians+of+the+galaxy",name);
    }
    @Test
    public void ShouldMkeTheRightUrl(){
        HTTPApiConection httpApiConection = new HTTPApiConection();
        httpApiConection.movieNameSetter("Fast" + " " + "and" + " " + "Furious");
        String url = httpApiConection.fullUrlBuilder();
        assertEquals("http://www.omdbapi.com/?t=Fast+and+Furious&apikey=c19ff813", url);
    }
}
