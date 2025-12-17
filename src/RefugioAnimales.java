import java.util.*;

public class RefugioAnimales {

//================= Globales =============================
    static Scanner sc = new Scanner(System.in);
    static List<String> animales = new ArrayList<>();
    static Set<String> especies = new HashSet<>();
    static Map<String, String> estadoAnimal = new HashMap<>();;
    static Map<String, String> animalEspecie = new HashMap<>();;


//================= Funciones ==============================
    static void menu(){
        System.out.println("\n=== REFUGIO DE ANIMALES ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales disponibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir\n");
    }

    static void registrar () {
        System.out.print("Ingrese el nombre del animal: ");
        String animal = sc.nextLine().trim();

        System.out.println("Ingrese especie: ");
        String especie = sc.nextLine();

        if (animal.isEmpty() || especie.isEmpty()) {
            System.out.println("Nombre o especies invalido");
            return;
        }

        if(!especies.contains(especie)) {
            System.out.println("Esa especie no existe, registrala en la opción 2");
            return;
        }

        if(animales.contains(animal)) {
            System.out.println("Ese animal ya está registrado");
            return;
        }

        animales.add(animal);
        animalEspecie.put(animal, especie);
        estadoAnimal.put(animal, "Disponible");
        System.out.println("Animal añadido con exito");

    }

    static void registrarEspecie(){
        System.out.print("Ingrese especie del animal:");
        String animalEspecie = sc.nextLine().trim();

        if (animalEspecie.isEmpty()) {
            System.out.println("Especie invalida");
            return;
        }

        // Esto devuelve false si ya existía en el set
        if (especies.add(animalEspecie)){
            System.out.println("Especie añadida con exito");
        }else{
            System.out.println("La especie ya existe");
        }
    }

    static void marcarAnimalAdoptado() {
        animalesDisponibles();
        System.out.println("Desea Adoptar alguna de nuestras mascotas disponibles? (si/no) ");
        String deseaAdoptar = sc.nextLine().trim();
        if (deseaAdoptar.equalsIgnoreCase("si")) {
            System.out.println("Seleccione el animal a adoptar: ");
            String animalSelect = sc.nextLine();
            for (Map.Entry<String, String> entry : estadoAnimal.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(animalSelect)) {
                    System.out.println("Felicidades por adoptar al animalito!");
                    entry.setValue("Adoptado");
                }
            }
        } else {
            System.out.println("Gracias por la intencion");
        }
    }

    static void animalesDisponibles (){
        System.out.println("=============== Animales Disponibles ===============");
        for (Map.Entry<String, String> entry : estadoAnimal.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Disponible")) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }
        }
        System.out.println("====================================================");


    //        System.out.print("Ingrese el animal que desea:");
    //        animal = sc.nextLine();
    //
    //        if(animales.contains(animal)) {
    //            System.out.println("==== Animales Disponibles ====");
    //            for(String ani : animales) {
    //                System.out.println(ani);
    //            }
    //        } else {
    //            System.out.println("No hay animales disponibles");
    //        }
    }

    static void animalesAdoptados(){
        if (estadoAnimal.containsValue("Adoptado")){
            System.out.println("=============== Animales Adoptados ================");
            for (Map.Entry<String, String> entry : estadoAnimal.entrySet()) {
                if (entry.getValue().equalsIgnoreCase("Adoptado")) {
                    System.out.println(entry.getKey() + " → " + entry.getValue());
                }
            }
            System.out.println("====================================================");
        }else {
            System.out.println("No existen animales adoptados");
        }

    }

    static void reporteGeneral() {
        System.out.printf("%-15s | %-15s | %-12s%n", "nombre", "especie", "estadp");
        System.out.println("---------------------------------"); // Separador

        for(String animal : animales) {
            String especie = animalEspecie.getOrDefault(animal, "Sin especie");
            String estado = estadoAnimal.getOrDefault(animal, "Disponible");

            System.out.printf("%-15s | %-15s | %-12s%n", animal, especie, estado);
        }

        if (animales.isEmpty()) {
            System.out.println("No hay registrados");
        }
    }


//   ================= Flujo del programa ==================
    public static void main(String[] args) {
        int opcion;

        do {
            menu();
            System.out.println("Ingrese una opción");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> registrarEspecie();
                case 3 -> marcarAnimalAdoptado();
                case 4 -> animalesDisponibles();
                case 5 -> animalesAdoptados();
                case 6 -> reporteGeneral();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
