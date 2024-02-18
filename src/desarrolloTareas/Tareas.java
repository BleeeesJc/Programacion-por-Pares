package desarrolloTareas;


public class Tareas {
 
 private String descripcion;
 private boolean completado;
 private boolean enProceso;

 public Tareas(String descripcion) {
     this.descripcion = descripcion;
     this.completado = false;
     this.enProceso = false;
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
     completado = true;
     enProceso = false; // Cuando una tarea se marca como completada, ya no puede estar en proceso
 }

 public void marcarEnProceso() {
     completado = false; // Cuando una tarea se marca como en proceso, ya no puede estar completada
     enProceso = true;
 }

 @Override
 public String toString() {
     String estado = completado ? "✓ Completada" : (enProceso ? "En proceso" : " X Pendiente");
     return "(" + estado + ") " + descripcion;
 }
}


