import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tareas> listaTareas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t=== Lista de Tareas ===\n");
        System.out.println("¡Bienvenido al programa de Gestión de Tareas :D!");
        System.out.println("Integrantes del Equipo:");
        System.out.println("\tFernanda Mattos Teran");
        System.out.println("\tMateo Joaquin Valenzuela Rivera");
        System.out.println("Presiona Enter para mostrar el menú de opciones...");

        sc.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {
            System.out.println("\nSeleccione una opción del Menú:");
            System.out.println("1. Agregar nueva tarea");//
            System.out.println("2. Ver el listado de todas las tareas");
            System.out.println("3. Marcar tarea como 'En proceso'");
            System.out.println("4. Marcar tarea como 'Completada'");
            System.out.println("5. Ver tareas completadas");
            System.out.println("6. Ver tareas en proceso");
            System.out.println("7. Ver tareas NO completadas");
            System.out.println("8. Eliminar tarea No completada");
            System.out.println("9. Modificar Tarea");
            System.out.println("10. Salir");

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
                    System.out.println("\nTareas completadas:");
                    for (Tareas tarea : listaTareas) {
                        if (tarea.estaCompletado()) {
                            System.out.println("- " + tarea);
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nTareas en proceso:");
                    for (Tareas tarea : listaTareas) {
                        if (tarea.estaEnProceso()) {
                            System.out.println("- " + tarea);
                        }
                    }
                    break;


                case 7:
                    System.out.println("\nTareas NO completadas:");
                    for (Tareas tarea : listaTareas) {
                        if (!tarea.estaCompletado() && !tarea.estaEnProceso()) {
                            System.out.println("- " + tarea);
                        }
                    }
                    break;

                case 8:
                    System.out.println("\nTareas NO completadas:");
                    int tareaNoCompletadaIndex = 1;
                    ArrayList<Tareas> tareasNoCompletadas = new ArrayList<>();
                    for (Tareas tarea : listaTareas) {
                        if (!tarea.estaCompletado()) {
                            System.out.println(tareaNoCompletadaIndex + ". " + tarea);
                            tareasNoCompletadas.add(tarea);
                            tareaNoCompletadaIndex++;
                        }
                    }
                    if (!tareasNoCompletadas.isEmpty()) {
                        System.out.print("Escriba el número de la tarea no completada que desea eliminar: ");
                        int numTareaEliminar = sc.nextInt();
                        if (numTareaEliminar >= 1 && numTareaEliminar <= tareasNoCompletadas.size()) {
                            Tareas tareaEliminar = tareasNoCompletadas.get(numTareaEliminar - 1);
                            listaTareas.remove(tareaEliminar);
                            System.out.println("¡Tarea eliminada!");
                        } else {
                            System.out.println("Ese número de tarea no existe :(");
                        }
                    } else {
                        System.out.println("No hay tareas NO completadas para eliminar.");
                    }
                    break;
                case 9:
                    System.out.print("Escriba el número de la tarea que desea modificar: ");
                    int numTarea= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nueva descripcion: ");
                    String nuevadesc = sc.nextLine();
                    if (numTarea >= 1 && numTarea <= listaTareas.size()) {
                        Tareas tareaSeleccionada = listaTareas.get(numTarea - 1);
                        tareaSeleccionada.modificar(nuevadesc);
                        System.out.println("¡Tarea modificada!");
                    } else {
                        System.out.println("Ese número de tarea no existe :(");
                    }
                    break;
                case 10:
                    System.out.println("Gracias por utilizar el programa, ¡hasta pronto!");
                    return;

                default:
                    System.out.println("Esa opción no se encuentra en el menú, por favor, presione un número del 1 al 9");
            }
        }
    }
}