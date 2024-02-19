import java.time.*;
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

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public String getDescripcion() {
        return descripcion;
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
        this.descripcion = nuevaDescripcion;
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
