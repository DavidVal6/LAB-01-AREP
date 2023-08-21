package org.example.Server;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HTTPServerTest {

    @Test
    public void ShouldPutBlankSpaces(){
        HttpServer httpServer = new HttpServer();
        String codificationName = "Game%20of%20Thrones";
        String rightOne = "Game of Thrones";
        codificationName = httpServer.nameFixer(codificationName);
        assertEquals(rightOne,codificationName);
    }

    @Test
    public void ShouldMapTheJson() {
            HttpServer httpServer = new HttpServer();
            String jsonTest = "{\"Title\":\"It\",\"Year\":\"2017\",\"Rated\":\"R\",\"Released\":\"08 Sep 2017\",\"Runtime\":\"135 min\",\"Genre\":\"Horror\",\"Director\":\"Andy Muschietti\",\"Writer\":\"Chase Palmer, Cary Joji Fukunaga, Gary Dauberman\",\"Actors\":\"Bill Skarsgård, Jaeden Martell, Finn Wolfhard\",\"Plot\":\"In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.\",\"Language\":\"English, Hebrew\",\"Country\":\"United States, Canada\",\"Awards\":\"10 wins & 46 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"86%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"7.3\",\"imdbVotes\":\"576,995\",\"imdbID\":\"tt1396484\",\"Type\":\"movie\",\"DVD\":\"19 Dec 2017\",\"BoxOffice\":\"$328,874,981\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
            httpServer.movieSetter(jsonTest);
            HashMap<String, Object> map = httpServer.getMovieData();
            assertTrue(map.containsKey("Year"));
    }

    @Test
    public void ShouldCreateTheList(){
        HttpServer httpServer = new HttpServer();
        String jsonTest = "{\"Title\":\"It\",\"Year\":\"2017\",\"Rated\":\"R\",\"Released\":\"08 Sep 2017\",\"Runtime\":\"135 min\",\"Genre\":\"Horror\",\"Director\":\"Andy Muschietti\",\"Writer\":\"Chase Palmer, Cary Joji Fukunaga, Gary Dauberman\",\"Actors\":\"Bill Skarsgård, Jaeden Martell, Finn Wolfhard\",\"Plot\":\"In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.\",\"Language\":\"English, Hebrew\",\"Country\":\"United States, Canada\",\"Awards\":\"10 wins & 46 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"86%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"7.3\",\"imdbVotes\":\"576,995\",\"imdbID\":\"tt1396484\",\"Type\":\"movie\",\"DVD\":\"19 Dec 2017\",\"BoxOffice\":\"$328,874,981\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        httpServer.movieSetter(jsonTest);
        String list = httpServer.listMader();
        assertTrue(list.startsWith("<ul>\n"));
    }
    @Test
    public void ShouldMakeTheRightHTML(){
        HttpServer httpServer = new HttpServer();
        String jsonTest = "{\"Title\":\"It\",\"Year\":\"2017\",\"Rated\":\"R\",\"Released\":\"08 Sep 2017\",\"Runtime\":\"135 min\",\"Genre\":\"Horror\",\"Director\":\"Andy Muschietti\",\"Writer\":\"Chase Palmer, Cary Joji Fukunaga, Gary Dauberman\",\"Actors\":\"Bill Skarsgård, Jaeden Martell, Finn Wolfhard\",\"Plot\":\"In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.\",\"Language\":\"English, Hebrew\",\"Country\":\"United States, Canada\",\"Awards\":\"10 wins & 46 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"86%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"7.3\",\"imdbVotes\":\"576,995\",\"imdbID\":\"tt1396484\",\"Type\":\"movie\",\"DVD\":\"19 Dec 2017\",\"BoxOffice\":\"$328,874,981\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        httpServer.movieSetter(jsonTest);
        String list = httpServer.listMader();
        String httpResponse = httpServer.htmlResponse(list);
        assertTrue(httpResponse.startsWith("HTTP/1.1 200 OK"));
    }
    @Test
    public void ShouldSetTheMovie(){
        HttpServer httpServer = new HttpServer();
        String uri = "/movie?name=Cars";
        String movie = httpServer.getMovie(uri);
        assertTrue(movie.startsWith("HTTP/1.1 200 OK\r\n"));
    }
}