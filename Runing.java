
public class Runing {

    public static void main(String[] args) {
        
        MainLibrary library = new MainLibrary();
        PlayList mainLibrary = library.createMainLibrary("C:Libro1.csv");
        Input in = new Input();

        System.out.println("A continuacion el usuario creara una playlist");
        System.out.println("Se presentara 3 opciones para crear la playlist ");
        System.out.println("Seleccionar las cancion desde la biblioteca : 0 ");
        System.out.println("Crear una biblioteca filtrando por genero : 1");
        System.out.println("Crear una biblioteca filtrando por año : 2");

        int indice = in.intInput("Ingrese el indice seleccionado");

        switch (indice) {
            case 0 -> {
            mainLibrary.getValues().forEach(s -> System.out.println(s.getSongID() + " : " + s.getTitle()));  
            }
            case 1 -> {
                System.out.println(mainLibrary.filterByGenre());
            }
            case 2 -> {
                System.out.println(mainLibrary.filterByDate());
            }
        }

    }
}