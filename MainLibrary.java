import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;

/**
 * Main class of the app
 * Manages the library of music
 * 
 * @author Isan Eduardo Franco Miranda <isan.9.9f@gmail.com>
 * @version 1.0.0
 */
public class MainLibrary {
    private BufferedReader reader;
    private String line;
    private String components[] = null;
    private LinkedHashMap<String, Song> mainLibrary = new LinkedHashMap<>();

    /**
     * Form a csv file extract the infrmation to create songs and fill a
     * hashmap(string, song) to be used in the contruction of the main library
     * 
     * @param FileName
     * @return A hashmap with all the songs in csv
     */
    private LinkedHashMap<String, Song> readFile(String FileName) {
        // System.out.println("Method readFile");
        try {
            // System.out.println("readFile catch");
            reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null) {
                components = line.split(";");
                mapLine(components);
            }
            reader.close();
            line = null;
            components = null;
        } catch (Exception e) {
            System.out.println("Main library has been created:");
        }
        // System.out.println(this.mainLibrary);
        return this.mainLibrary;
    }

    /**
     * Construc a song from a csv line and adds it to the main libray playlist
     * 
     * @param components
     */
    private void mapLine(String[] components) {

        String songID = components[0];
        String title = components[1];
        Integer date = Integer.parseInt(components[2]);
        Integer length = Integer.parseInt(components[3]);
        String genre = components[4];
        String cover = components[5];
        String description = components[6];

        // System.out.print("Archivo "+components[1]+" :");

        // System.out.println(title +", "+ songID +", "+ date +", "+ length +", "+ genre
        // +", "+ cover +", "+ description);
        Song newSong = new Song(title, songID, date, length, genre, cover, description);
        this.mainLibrary.put(newSong.getSongID(), newSong);
    }

    private PlayList createMainPlaylist(LinkedHashMap<String, Song> mainLibrary) {

        return new PlayList("Main_Library", mainLibrary);
    }

    public PlayList createMainLibrary(String Filename) {
        return createMainPlaylist(readFile(Filename));
    }

}
