import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that contains methods to create and manage play lists
 * 
 * @author Isan Eduardo Franco Miranda <isan.9.9f@gmail.com>
 * @version 1.0.0
 */
public class PlayList {
    private String playListName;
    public LinkedHashMap<String, Song> playlist = new LinkedHashMap<>(); // The set of songs the play list has got
    Input in = new Input(); // Class Input to validate the uster entrys

    /**
     * Constructor for the class Playlist
     * 
     * @param playListName
     * @param playList
     */
    public PlayList(String playListName, LinkedHashMap<String, Song> playList) {
        this.playListName = playListName;
        this.playlist = playList;
    }

    /**
     * Constructor for the class play list to create a playlist selecting songs from
     * another playlist
     * 
     * @param playListName
     * @param setOfSongs
     * @param initialPlaylist
     */
    public PlayList(String playListName, String setOfSongs, PlayList initialPlaylist) {
        this.playListName = playListName;
        this.playlist = mapOfSongs(setOfSongs, initialPlaylist);
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    /**
     * Method to extract in a list the playlist's songs
     * 
     * @return An array of songs (Song)
     */
    private List<Song> getValues() {
        return new ArrayList<Song>(this.playlist.values());
    }

    /**
     * Method to extract in a list the playlist's songs genres
     * 
     * @return An array of genres (String)
     */
    private ArrayList<String> getGener() {
        List<Song> songs = getValues();
        ArrayList<String> songGeners = new ArrayList<>();
        songs.forEach(s -> songGeners.add(s.getGenre()));
        return songGeners;
    }

    /**
     * Method to extract in a list the playlist songs's dates of relase
     * 
     * @return An array of years (int)
     */
    private ArrayList<Integer> getDate() {
        List<Song> songs = getValues();
        ArrayList<Integer> songDates = new ArrayList<>();
        songs.forEach(s -> songDates.add(s.getDate()));
        return songDates;
    }

    /**
     * Creates a playlist from a given playlist that has got only an especific genre
     * songs.
     * Show the existing genres from the given playlist and allows the uset to
     * select one of them,
     * then creates a hashmap and returns a playlist shuch that name is the
     * parameter and the
     * hashmap of songs is the hashmap previously created
     * 
     * @param playListName
     * @return A playlist of songs that share the same genre
     */
    public PlayList filterByGenre(String playListName) {
        LinkedHashMap<String, Song> filterdByGenre = new LinkedHashMap<>();
        ArrayList<String> genresBySong = getGener();
        List<String> unique = genresBySong.stream().distinct().collect(Collectors.toList());
        List<Song> songs = getValues();
        unique.forEach(s -> System.out.println((unique.indexOf(s)) + " : " + s));
        int indexGenre = in.intInput("Enter the index of the gender you whish to \n filter by (for exaple, enter 0 for "
                + unique.get(0) + " )");
        String genre = unique.get(indexGenre);
        System.out.println("The selected gener is " + genre + "\nThis is the list of " + genre + " in the library");
        songs.forEach(s -> {
            if (s.getGenre().equals(genre)) {
                System.out.println(s.getSongID() + "." + s.getTitle() + " : " + s.getGenre());
                filterdByGenre.put(s.getSongID(), s);
            }
        });
        return new PlayList(playListName, filterdByGenre);
    }

    /**
     * Creates a playlist from a given playlist that has got only songs relased in a
     * especific date.
     * Show the existing dates from the given playlist and allows the uset to select
     * one of them,
     * then creates a hashmap and returns a playlist shuch that name is the
     * parameter and the
     * hashmap of songs is the hashmap previously created
     * 
     * @param playListName
     * @return A playlist of songs that share the date
     */
    public PlayList filterByDate(String playListName) {
        LinkedHashMap<String, Song> filterdByDate = new LinkedHashMap<>();
        ArrayList<Integer> datesBySong = getDate();
        List<Integer> unique = datesBySong.stream().distinct().collect(Collectors.toList());
        List<Song> songs = getValues();
        unique.forEach(s -> System.out.println((unique.indexOf(s)) + " : " + s));
        int indexGenre = in.intInput(
                "Enter the index of the year you whish to\nfilter by (for exaple, enter 0 for " + unique.get(0) + " )");
        Integer date = unique.get(indexGenre);
        System.out.println("The selected yaer is " + date + "\nThis is the list of songs relased in " + date
                + " present in the library");
        songs.forEach(s -> {
            if (s.getDate().equals(date)) {
                System.out.println(s.getSongID() + "." + s.getTitle() + " : " + s.getDate());
                filterdByDate.put(s.getSongID(), s);
            }
        });
        return new PlayList(playListName, filterdByDate);
    }

    /**
     * Sort the play list based on the year it was relased
     */
    public void sortByDate() {
        List<Song> list = new ArrayList<Song>(this.playlist.values());
        list.sort(Comparator.comparingInt(Song::getDate));
        this.playlist.clear();
        list.forEach(s -> {
            this.playlist.put(s.getSongID(), s);
        });

    }

    /**
     * Sort the play list based on the duration of the song
     */
    public void sortByLength() {
        List<Song> list = new ArrayList<Song>(this.playlist.values());
        list.sort(Comparator.comparingInt(Song::getLength));
        this.playlist.clear();
        list.forEach(s -> {
            this.playlist.put(s.getSongID(), s);
        });

    }

    /**
     * Print from the playlist a set of information usefull for the user like this
     * ----------------------------
     * 120.Highway to Hell
     * Genre: Rock
     * Year relased: 1979
     * Length (seconds): 302
     * ----------------------------
     */
    public void printPlaylist() {
        List<Song> songs = getValues();
        System.out.println("\n----------------------------");
        songs.forEach(s -> System.out.println(s.getSongID() + "." + s.getTitle() +
                "\nGenre: " + s.getGenre() +
                "\nYear relased: " + s.getDate() +
                "\nLength (seconds): " + s.getLength() + "\n----------------------------"));
    }

    /**
     * Print from the playlist a set of information usefull for the user like this
     * ----------------------------
     * 120.Highway to Hell
     * Year relased: 1979
     * ----------------------------
     */
    public void printPlaylistDate() {
        List<Song> songs = getValues();
        System.out.println("\n----------------------------");
        songs.forEach(s -> System.out.println(s.getSongID() + "." + s.getTitle() +
                "\nYear relased: " + s.getDate() + "\n----------------------------"));
    }

    /**
     * Given a set of Song IDs creates a hashmap (string, song) such that the key
     * values are the songs names and
     * the values are the songs selected
     * 
     * @param setOfSongs
     * @param initialPlaylist
     * @return A hashmap to use in the costruction of a playlsit
     */
    private LinkedHashMap<String, Song> mapOfSongs(String setOfSongs, PlayList initialPlaylist) {
        LinkedHashMap<String, Song> mapOfSongs = new LinkedHashMap<>();
        String[] songsId = setOfSongs.split(",");
        for (String song : songsId) {
            if (initialPlaylist.playlist.get(song) != null) {
                mapOfSongs.put(song, initialPlaylist.playlist.get(song));
            } else {
                System.out.println("The value " + song + " does not exist in the current playlist");
            }
        }
        return mapOfSongs;
    }

}
