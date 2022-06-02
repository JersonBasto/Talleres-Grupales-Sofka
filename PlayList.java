import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlayList {
    private String playListName;
    LinkedHashMap<String, Song> playList = new LinkedHashMap<>();
    Input in = new Input();

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
            songsKeys.add(keys.getSongID());
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

    public Integer getSizeLibrary() {
        int size = 0;
        Collection<Song> songs = getValues();
        for (Song song : songs) {
            size += 1;
        }
        return size;
    }

    public ArrayList<String> filterGenere() {
        ArrayList<String> generes = new ArrayList<>();
        ArrayList<String> generesBySong = new ArrayList<>();
        Collection<Song> songs = getValues();
        for (Song song : songs) {
            generesBySong.add(song.getGenre());
        }
        List<String> unique = generesBySong.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < unique.size(); i++) {
            System.out.println((i) + " : " + unique.get(i));
        }

        int indexGenre = in.intInput("Ingrese el indice del genero");
        String Genre = unique.get(indexGenre);
        int z = 0;
        for (Song song : songs) {
            System.out.println(song.getGenre() + " : " + Genre);
            if (song.getGenre().equals(Genre)) {
                generes.add(z+" : "+song.getTitle());
                z++;
            }
        }
        return generes;
    }
    public ArrayList<String> filterYear() {
        ArrayList<String> years = new ArrayList<>();
        ArrayList<Integer> yearsBySong = new ArrayList<>();
        Collection<Song> songs = getValues();
        for (Song song : songs) {
            yearsBySong.add(song.getDate());
        }
        List<Integer> unique = yearsBySong.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < unique.size(); i++) {
            System.out.println((i) + " : " + unique.get(i));
        }

        int indexGenre = in.intInput("Ingrese el indice del año");
        int Year = unique.get(indexGenre);
        int z = 0;
        for (Song song : songs) {
            if (song.getDate()==Year) {
                years.add(z+" : "+song.getTitle());
                z++;
            }
        }
        return years;
    }
    
}
