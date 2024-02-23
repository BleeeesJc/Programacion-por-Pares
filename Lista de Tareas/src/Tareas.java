import java.time.*; //Librerias para poder usar el LocalDate
public class Tareas {

    private String descripcion;
    private boolean completado;
    private boolean enProceso;
    private LocalDate inicio;
    private LocalDate fin;

    public Tareas(String descripcion) {
        this.descripcion = descripcion;
        this.completado = false;
        this.enProceso = false;
        this.inicio=null;
        this.fin=null;
    }

    public boolean estaCompletado() {
        return completado;
    }

    public boolean estaEnProceso() {
        return enProceso;
    }

    public void marcarCompletado() {
        fin=LocalDate.now();
        completado = true;
        enProceso = false; // Cuando una tarea se marca como completada, ya no puede estar en proceso
    }

    public void marcarEnProceso() {
        inicio=LocalDate.now();
        completado = false; // Cuando una tarea se marca como en proceso, ya no puede estar completada
        enProceso = true;
    }
    public void modificar(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion; // Modifica la descripcion de la tarea
    }

    @Override
    public String toString() {
        String estado = completado ? "✓ Completada" : (enProceso ? "En proceso" : "X Pendiente");
        if (completado){
            return "(" + estado + ") " + descripcion + " Fecha Inicio: "+inicio+ " Fecha Fin: "+fin;
        }else{
            if (enProceso){
                return "(" + estado + ") " + descripcion + " Fecha Inicio: "+inicio;
            }else{
                return "(" + estado + ") " + descripcion;
            }
        }
    }
}