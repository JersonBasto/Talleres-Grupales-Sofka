import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlayList {
    private String playListName;
    public LinkedHashMap<String, Song> playlist = new LinkedHashMap<>();
    Input in = new Input();

    public PlayList(String playListName, LinkedHashMap<String, Song> playList) {
        this.playListName = playListName;
        this.playlist = playList;

    }
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

    private List<Song> getValues() {
        return new ArrayList<Song>(this.playlist.values());
    }

    private ArrayList<String> getGener() {
        List<Song> songs = getValues();
        ArrayList<String> songGeners = new ArrayList<>();
        songs.forEach(s -> songGeners.add(s.getGenre()));
        return songGeners;
    }

    private ArrayList<Integer> getDate() {
        List<Song> songs = getValues();
        ArrayList<Integer> songDates = new ArrayList<>();
        songs.forEach(s -> songDates.add(s.getDate()));
        return songDates;
    }

    public PlayList filterByGenre(String playListName) {
        LinkedHashMap<String, Song> filterdByGenre = new LinkedHashMap<>();
        ArrayList<String> genresBySong = getGener();
        List<String> unique = genresBySong.stream().distinct().collect(Collectors.toList());
        List<Song> songs = getValues();
        unique.forEach(s -> System.out.println((unique.indexOf(s)) + " : " + s));
        int indexGenre = in.intInput("Enter the index of the gender you whish to \n filter by (for exaple, enter 0 for "+unique.get(0) +" )");
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

    public PlayList filterByDate(String playListName) {
        LinkedHashMap<String, Song> filterdByDate = new LinkedHashMap<>();
        ArrayList<Integer> datesBySong = getDate();
        List<Integer> unique = datesBySong.stream().distinct().collect(Collectors.toList());
        List<Song> songs = getValues();
        unique.forEach(s -> System.out.println((unique.indexOf(s)) + " : " + s));
        int indexGenre = in.intInput("Enter the index of the year you whish to\nfilter by (for exaple, enter 0 for "+unique.get(0) +" )");
        Integer date = unique.get(indexGenre);
        System.out.println("The selected yaer is " + date + "\nThis is the list of songs relased in " + date + " present in the library");
        songs.forEach(s -> {
            if (s.getDate().equals(date)) {
                System.out.println(s.getSongID() + "." + s.getTitle() + " : " + s.getDate());
                filterdByDate.put(s.getSongID(), s);
            }
        });
        return new PlayList(playListName, filterdByDate);
    }

    public /* PlayList */void sortByDate() {
        List<Song> list = new ArrayList<Song>(this.playlist.values());
        list.sort(Comparator.comparingInt(Song::getDate));
        this.playlist.clear();
        list.forEach(s -> {
            this.playlist.put(s.getSongID(), s);
        });

    }

    public /* PlayList */void sortByLength() {
        List<Song> list = new ArrayList<Song>(this.playlist.values());
        list.sort(Comparator.comparingInt(Song::getLength));
        this.playlist.clear();
        list.forEach(s -> {
            this.playlist.put(s.getSongID(), s);
        });

    }
    
    public void printPlaylist (){
        List <Song> songs = getValues();
        songs.forEach(s -> System.out.println(s.getSongID()+"."+s.getTitle()+
        "\nGenre: "+s.getGenre()+
        "\nYear relased: "+s.getDate()+
        "\nLength (seconds): "+s.getLength()+"\n----------------------------"));
    }
    public void printPlaylistDate (){
        List <Song> songs = getValues();
        songs.forEach(s -> System.out.println(s.getSongID()+"."+s.getTitle()+
        "\nYear relased: "+s.getDate()+"\n"));
    }

    private LinkedHashMap<String, Song> mapOfSongs (String setOfSongs, PlayList initialPlaylist){
        LinkedHashMap<String, Song> mapOfSongs = new LinkedHashMap<>();
        String [] songsId = setOfSongs.split(",");
        for (String song : songsId) {
            if (initialPlaylist.playlist.get(song)!=null){
            mapOfSongs.put(song, initialPlaylist.playlist.get(song));
            }
            else {
            System.out.println("The value "+song+" does not exist in the current playlist");    
            }
        }
        return mapOfSongs;
    }

}
