import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;


public class PlayList {
    private String playListName;
    LinkedHashMap<String, Song> playList = new LinkedHashMap<>();
    
    
    
    public PlayList(String playListName, LinkedHashMap<String, Song> playList) {
        this.playListName = playListName;
        this.playList = playList;

    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public ArrayList<String> getKeys() {
        Collection<Song> songs = getValues();
        ArrayList<String> songsKeys = new ArrayList<>();
        for (Song keys : songs) {
            songsKeys.add(keys.getTitle());
        }
        return songsKeys;
    }

    private Collection<Song> getValues() {
        return this.playList.values();
    }

    public ArrayList<String> getNames() {
        Collection<Song> songs = getValues();
        ArrayList<String> songsNames = new ArrayList<>();
        for (Song song : songs) {
            songsNames.add(song.getTitle());
        }
        return songsNames;

    }

    public void sortPlaylist(char sortKey) {
        // Set<String, Song> set = this.playList.entrySet();
        // Iterator iterator = set.iterator();
    }

    public void sortByDate() {
        LinkedHashMap<Integer, Song> sortByDate = new LinkedHashMap<>();
        Collection<Song> songs = getValues();
        for (Song song : songs) {
            sortByDate.put(song.getDate(), song);
        }
    }
         
    public void sortByLength() {
        LinkedHashMap<Integer, Song> sortByLength = new LinkedHashMap<>();
        Collection<Song> songs = getValues();
        for (Song song : songs) {
            sortByLength.put(song.getLength(), song);
        }
    }
        
    
}
