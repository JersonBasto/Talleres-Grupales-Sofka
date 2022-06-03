
public class Runing {

    public static void main(String[] args) {
        
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        Input in = new Input();
        //System.out.println(mainLibrary);
        //mainLibrary.sortByDate();
        int cont = 0;
        //mainLibrary.filterByDate();
        while (cont == 0) {
            mainLibrary.filterByDate();
            int cont2 = in.intInput ("If you whant to continue enter anything but 1");
            if (cont2==1){
                cont=1;
            }
        }
        /*for (int x = 0; x < mainLibrary.getSizeLibrary(); x++) {
            System.out.println(mainLibrary.getKeys().get(x) + " : "+mainLibrary.getNames().get(x));
        }*/
        //System.out.println(mainLibrary.filterGenere());
    }
}