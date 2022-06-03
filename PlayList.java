import java.util.ArrayList;
import java.util.Comparator;
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

    public List<Song> getValues() {
        return new ArrayList<Song>(this.playList.values());
    }

    public ArrayList<String> getKeys() {
        List<Song> songs = getValues();
        ArrayList<String> songsKeys = new ArrayList<>();
        songs.forEach(s -> songsKeys.add(s.getSongID()));
        return songsKeys;
    }

    public ArrayList<String> getNames() {
        List<Song> songs = getValues();
        ArrayList<String> songNames = new ArrayList<>();
        songs.forEach(s -> songNames.add(s.getSongID()));
        return songNames;
    }

    public ArrayList<String> getGener() {
        List<Song> songs = getValues();
        ArrayList<String> songGeners = new ArrayList<>();
        songs.forEach(s -> songGeners.add(s.getGenre()));
        return songGeners;
    }

    public ArrayList<Integer> getDate() {
        List<Song> songs = getValues();
        ArrayList<Integer> songDates = new ArrayList<>();
        songs.forEach(s -> songDates.add(s.getDate()));
        return songDates;
    }

    public LinkedHashMap<String, Song> filterByGenre() {
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
        return filterdByGenre;
    }

    public LinkedHashMap<String, Song> filterByDate() {
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
        return filterdByDate;
    }

    /*
     * public ArrayList<String> filterYear() {
     * ArrayList<String> years = new ArrayList<>();
     * ArrayList<Integer> yearsBySong = new ArrayList<>();
     * Collection<Song> songs = getValues();
     * for (Song song : songs) {
     * yearsBySong.add(song.getDate());
     * }
     * List<Integer> unique =
     * yearsBySong.stream().distinct().collect(Collectors.toList());
     * 
     * for (int i = 0; i < unique.size(); i++) {
     * System.out.println((i) + " : " + unique.get(i));
     * }
     * 
     * int indexGenre = in.intInput("Ingrese el indice del año");
     * int Year = unique.get(indexGenre);
     * int z = 0;
     * for (Song song : songs) {
     * if (song.getDate() == Year) {
     * years.add(z + " : " + song.getTitle());
     * z++;
     * }
     * }
     * return years;
     * }
     */

    public /* PlayList */void sortByDate() {
        List<Song> list = new ArrayList<Song>(this.playList.values());
        list.sort(Comparator.comparingInt(Song::getDate));
        this.playList.clear();
        list.forEach(s -> {
            this.playList.put(s.getSongID(), s);
        });

    }

    public /* PlayList */void sortByLength() {
        List<Song> list = new ArrayList<Song>(this.playList.values());
        list.sort(Comparator.comparingInt(Song::getLength));
        this.playList.clear();
        list.forEach(s -> {
            this.playList.put(s.getSongID(), s);
        });

    }

}
