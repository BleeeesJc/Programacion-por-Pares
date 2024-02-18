import java.util.ArrayList;
import java.util.List;

public class PantallaPrincipal {
    private List<String> integrantes;

    public PantallaPrincipal() {
        this.integrantes = new ArrayList<>();
        this.integrantes.add("Fernanda Mattos Teran");
        this.integrantes.add("Mateo Joaquin Valenzuela Rivera");
    }

    public void mostrarPantallaPrincipal() {
        System.out.println("=== Lista de Tareas ===\n");
        System.out.println("Integrantes del Equipo:");
        for (String integrante : integrantes) {
            System.out.println("- " + integrante);
        }
        System.out.println("\nPresione enter para continuar");

        System.out.println("\nSeleccione una opción del Menú:");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Ver el listado de todas las tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Ver tareas completadas");
        System.out.println("5. Ver tareas NO completadas");
        System.out.println("6. Eliminar tareas ");
        System.out.println("7. Ver tareas en curso");
        System.out.println("8. Salir");

    }

    public static void main(String[] args) {
        PantallaPrincipal app = new PantallaPrincipal();
        app.mostrarPantallaPrincipal();
    }
}