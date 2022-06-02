
public class Runing {

    public static void main(String[] args) {
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        System.out.println(mainLibrary.getSizeLibrary());

        for (int x = 0; x < mainLibrary.getSizeLibrary(); x++) {
            System.out.println(mainLibrary.getKeys().get(x) + " : "+mainLibrary.getNames().get(x));
        }

        System.out.println(mainLibrary.filterYear());
    }
}