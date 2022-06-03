import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Runing {

    public static void main(String[] args) {
        LinkedHashMap<String, PlayList> playlistLibrary = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        playlistLibrary.put(mainLibrary.getPlayListName(), mainLibrary);
        Input in = new Input();
        boolean sporafy = true;
        System.out.println("Welcome to sporafy\nThis is the list of songs currently available in the library");
        //mainLibrary.printPlaylist();
        //System.out.println(playlistLibrary);

        /*
         * System.out.println("Ingrese una lista de id para crear una nueva Play list");
         * String setOfSongs = sc.nextLine();
         * System.out.println("Type the name for the new playlist");
         * String playlistName = sc.nextLine();
         * 
         * playlistLibrary.put(playlistName,new PlayList(playlistName, setOfSongs,
         * mainLibrary));
         * System.out.println("The play list has been created");
         * 
         * System.out.println("the list of play list is "+playlistLibrary.keySet());
         * 
         * System.out.println("The play list " + playlistName + " contains: ");
         * 
         * playlistLibrary.get(playlistName).printPlaylist();
         */

        while (sporafy = true) {
            System.out.println("----------------------Main menu----------------------");
            System.out.println("--To select an option type a number between 1 and 3");
            System.out.println("----Create a play list from a set of songs of your choise: type 1");
            /*System.out.println("----Filter an existing playlist by year of relase: 2");
            System.out.println("----Filter an existing playlist by genre: 3");
            System.out.println("----Sort an existing playlist by year of relase: 4");
            System.out.println("----Sort an existing playlist by year of relase: 5");
            System.out.println("----Show the existing playlist: 6");*/
            System.out.println("----Select an playlist to interact: 2");
            System.out.println("----Show the songs currently available in the library: 3");
            System.out.println("----End the program: 0");

            int index = in.intInput("--------------------------------------------");

            switch (index) {
                case 0 -> {
                sporafy = false;
                }
                case 1 -> {
                    System.out.println("To create a play list type a set of songs IDs separated by ',' (coma) and then press enter");
                    String setOfSongs = sc.nextLine();
                    System.out.println("Now type the name for the new playlist");
                    String playlistName = sc.nextLine();
                    playlistLibrary.put(playlistName, new PlayList(playlistName, setOfSongs, mainLibrary));
                    System.out.println("The play list "+playlistName+" has been created");
                }
                case 2 -> {
                    int index2 = 1;
                    System.out.println("This are playlists available at the moment:");
                    //playlistLibrary.keySet().forEach(s -> System.out.println(s));
                    indexPlaylist(playlistLibrary);
                    System.out.println("Type the exact name of the play list you would like to interact to");
                    String currentPlaylist = sc.nextLine();
                    if (playlistLibrary.get(currentPlaylist)!=null){
                        
                        switch (index2){

                        }
                    }
                }
                case -1 -> {

                }
            }
        }
        sc.close();
    }
    public static String indexPlaylist (LinkedHashMap<String, PlayList> playlistLibrary, Input in){
        List <String> listOfPlaylist = new ArrayList<String>();
        playlistLibrary.keySet().forEach(s -> listOfPlaylist.add(s));
        listOfPlaylist.forEach(s -> System.out.println(listOfPlaylist.indexOf(s)+". "+s));
        int index = in.intInput("--------------------------------------------");
    } 
}

