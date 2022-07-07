import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Main class of the app
 * Manages the library of music
 * 
 * The app gathers the information from a csv data base and arrange it into a
 * map containing all the information
 * 
 * @author Isan Eduardo Franco Miranda <isan.9.9f@gmail.com>
 * @version 1.0.0
 */
public class Runing {

    public static void main(String[] args) {
        LinkedHashMap<String, PlayList> playlistLibrary = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        playlistLibrary.put(mainLibrary.getPlayListName(), mainLibrary);
        mainLibrary.printPlaylist();
        Input in = new Input();
        boolean sporafy = true;
        System.out.println("Welcome to sporafy\nThis is the list of songs currently available in the library");

        while (sporafy == true) {

            int index = printMainManu(in);

            switch (index) {
                case 0 -> {
                    sporafy = false;

                }
                case 1 -> {
                    System.out.println(
                            "To create a play list type a set of songs IDs separated by ',' (coma) and then press enter");
                    String setOfSongs = sc.nextLine();
                    System.out.println("Now type the name for the new playlist");
                    String playlistName = sc.nextLine();
                    playlistLibrary.put(playlistName, new PlayList(playlistName, setOfSongs, mainLibrary));
                    System.out.println("The play list " + playlistName + " has been created");
                }
                case 2 -> {
                    System.out.println("-----------------------------------------------------" +
                            "\n--------------------Playlist menu--------------------");
                    System.out.println("----This are playlists available at the moment:");
                    String currentPlaylist = indexPlaylist(playlistLibrary, in);
                    System.out.println("--The selected playlist is :" + currentPlaylist);
                    System.out.println("--To select an option type a number between 1 and 6");
                    System.out.println("--1--Filter the playlist by year of relase");
                    System.out.println("--2--Filter the playlist by genre");
                    System.out.println("--3--Sort the playlist by year of relase");
                    System.out.println("--4--Sort the playlist by length");
                    System.out.println("--5--Print playlist's songs");
                    System.out.println("--6--Show the existing playlist");
                    System.out.println("--0--Return to main menu");
                    int index2 = in.inputIndex("----------------------------------------------------", 7);

                    switch (index2) {
                        case 1 -> {
                            String playListName = currentPlaylist + " filterd by date";
                            PlayList dinamicPlaylist = playlistLibrary.get(currentPlaylist).filterByDate(playListName);
                            int answ = in.intInput(
                                    "Would you like to save the play list?\nType 1 to save the play list\nType 2 to discartit");
                            if (answ == 1) {
                                System.out.println("Type the name for the new playlist");
                                String playlistName = sc.nextLine();
                                playlistLibrary.put(playlistName, dinamicPlaylist);
                                System.out.println("The play list " + playlistName + " has been created");
                            }

                        }
                        case 2 -> {
                            String playListName = currentPlaylist + " filterd by genre";
                            PlayList dinamicPlaylist = playlistLibrary.get(currentPlaylist).filterByGenre(playListName);
                            int answ = in.intInput(
                                    "Would you like to save the play list?\nType 1 to save the play list\nType 2 to discartit");
                            if (answ == 1) {
                                System.out.println("Type the name for the new playlist");
                                String playlistName = sc.nextLine();
                                playlistLibrary.put(playlistName, dinamicPlaylist);
                                System.out.println("The play list " + playlistName + " has been created");
                            }
                        }
                        case 3 -> {
                            playlistLibrary.get(currentPlaylist).sortByDate();
                        }
                        case 4 -> {
                            playlistLibrary.get(currentPlaylist).sortByLength();
                        }
                        case 5 -> {
                            playlistLibrary.get(currentPlaylist).printPlaylist();
                        }
                        case 6 -> {
                            printPlaylistList(playlistLibrary);
                        }
                        case 0 -> {
                            break;
                        }
                    }
                }
                case 3 -> {
                    mainLibrary.printPlaylist();
                }
            }
        }
        sc.close();
    }

    public static String indexPlaylist(LinkedHashMap<String, PlayList> playlistLibrary, Input in) {
        List<String> listOfPlaylist = printPlaylistList(playlistLibrary);
        int index = in.inputIndex("Enter the index of the playlist you whish to \ninteract to(for exaple, enter 0 for "
                + listOfPlaylist.get(0) + " )", listOfPlaylist.size());
        return listOfPlaylist.get(index);
    }

    public static List<String> printPlaylistList(LinkedHashMap<String, PlayList> playlistLibrary) {
        List<String> listOfPlaylist = new ArrayList<String>();
        playlistLibrary.keySet().forEach(s -> listOfPlaylist.add(s));
        listOfPlaylist.forEach(s -> System.out.println(listOfPlaylist.indexOf(s) + ". " + s));
        return listOfPlaylist;
    }

    /*
     * 
     * 
     * 
     */
    public static int printMainManu(Input in) {
        System.out.println("----------------------Main menu----------------------");
        System.out.println("--To select an option type a number between 1 and 3");
        System.out.println("--1--Create a play list from a set of songs of your choise");
        System.out.println("--2--Select an playlist to interact");
        System.out.println("--3--Show the songs currently available in the library");
        System.out.println("--0--End the program");

        return in.inputIndex("----------------------------------------------------", 4);
    }

}
