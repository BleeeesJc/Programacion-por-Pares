package desarrollo_Tareas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tareas> listaTareas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido al programa de Gestión de Tareas :D!");

        while (true) {
            System.out.println("\nSeleccione una opción del Menú:");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Ver el listado de todas las tareas");
            System.out.println("3. Marcar tarea como 'En proceso'");
            System.out.println("4. Marcar tarea como 'Completada'");
            System.out.println("5. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Agrege una nueva tarea: ");
                    String nuevaDesc = sc.nextLine();
                    Tareas nuevaT = new Tareas(nuevaDesc);
                    listaTareas.add(nuevaT);
                    System.out.println("¡Tarea agregada exitosamente!");
                    break;

                case 2:
                    System.out.println("\nListado de todas las tareas:");
                    for (int i = 0; i < listaTareas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaTareas.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Escriba el número de la tarea que desea marcar como 'En proceso': ");
                    int numTareaProceso = sc.nextInt();
                    if (numTareaProceso >= 1 && numTareaProceso <= listaTareas.size()) {
                        Tareas tareaSeleccionada = listaTareas.get(numTareaProceso - 1);
                        tareaSeleccionada.marcarEnProceso();
                        System.out.println("¡Tarea marcada como 'En proceso'!");
                    } else {
                        System.out.println("Ese número de tarea no existe :(");
                    }
                    break;

                case 4:
                    System.out.print("Escriba el número de la tarea que desea marcar como 'Completada': ");
                    int numTareaCompletada = sc.nextInt();
                    if (numTareaCompletada >= 1 && numTareaCompletada <= listaTareas.size()) {
                        Tareas tareaSeleccionada = listaTareas.get(numTareaCompletada - 1);
                        tareaSeleccionada.marcarCompletado();
                        System.out.println("¡Tarea marcada como 'Completada'!");
                    } else {
                        System.out.println("Ese número de tarea no existe :(");
                    }
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el programa, ¡hasta pronto!");
                    return;

                default:
                    System.out.println("Esa opción no se encuentra en el menú, por favor, presione un número del 1 al 9");
            }
        }
    }
}
