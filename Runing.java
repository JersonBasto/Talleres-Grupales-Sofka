
public class Runing {

    public static void main(String[] args) {
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        System.out.println(mainLibrary.getKeys());
        System.out.println(mainLibrary.getNames());
    }
}