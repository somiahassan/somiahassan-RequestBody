

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
            
            //implement logic here
             // Retrieve the song object from the request body
    Song song = om.readValue(ctx.body(), Song.class);
    
    // Return the song object as JSON in the response body
    ctx.json(song);
        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            //implement logic here
             // Retrieve the song object from the request body
    Song song = om.readValue(ctx.body(), Song.class);
    
    // Update the artist name to "Beatles"
    song.setArtistName("Beatles");
    
    // Return the updated song object as JSON in the response body
    ctx.json(song);
               
        });


        return app;
    }
    
}
