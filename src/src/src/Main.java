package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public Main() {
        Ubicacion clase = new Ubicacion(0, "Estás sentado en la clase de programacion.");
        Ubicacion montaña = new Ubicacion(1, "Estás en la cima de una montaña.");
        Ubicacion playa = new Ubicacion(2, "Estás bañándote en el mar.");
        Ubicacion edificio = new Ubicacion(3, "Estás dentro de un edificio muy alto.");
        Ubicacion puente = new Ubicacion(4, "Estás de pie en un puente.");
        Ubicacion bosque = new Ubicacion(5, "Estás en un bosque.");
        ubicaciones.put(0, clase);
        ubicaciones.put(1, montaña);
        ubicaciones.put(2, playa);
        ubicaciones.put(3, edificio);
        ubicaciones.put(4, puente);
        ubicaciones.put(5, bosque);


        montaña.addExit("N",5);
        montaña.addExit("S",4);
        montaña.addExit("E",3);
        montaña.addExit("O",2);
        playa.addExit("N",5);
        edificio.addExit("E",1);
        puente.addExit("N",1);
        puente.addExit("E",2);
        bosque.addExit("S",1);
        bosque.addExit("E",2);
    }
    public static void main(String[] args) {
        Main ubi = new Main();
        Scanner sc = new Scanner(System.in);
        String dir = "";
        int valor = 1;
        boolean fin = true;
        boolean mal;

        while (fin) {
            System.out.println(ubicaciones.get(valor).getDescripcion());
            System.out.print("Tus salidas validas son ");
            for (String cor : ubicaciones.get(valor).getExits().keySet()) {
                System.out.print(cor + ", ");
            }
            System.out.println("Q");
            System.out.println("¿A donde quieres ir?");
            do {
                mal = true;
                try {
                    dir = sc.nextLine();
                    if (dir.matches("Q|q")) {
                        System.out.println("Has salido del juego, hasta la proxima");
                        System.exit(0);
                    } else {
                        mal = true;
                    }
                    valor = ubicaciones.get(valor).getExits().get(dir.toUpperCase());
                } catch (NullPointerException e) {
                    System.out.println("Introduce una direccion valida");
                    mal=false;
                }
            }while (mal == false);
        }
    }
}