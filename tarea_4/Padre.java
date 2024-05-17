public class Padre extends Persona{
  // Atributos
  private Estudiante descendiente;

  // Constructor
  Padre(String nombre, int edad, Estudiante descendiente) {
    super(nombre, edad);
    this.descendiente = descendiente;
  }

  // Metodos
  public void reclamar() {
    System.out.println("Porque no has hecho tu tarea, " + descendiente.getNombre());
  }

  // Encapsulamiento
  public Estudiante getDescendiente() {
    return descendiente;
  }

  public void setDescendiente(Estudiante descendiente) {
    this.descendiente = descendiente;
  }

  public static void main(String[] args) {
    Estudiante jose = new Estudiante("Jose", 24);
    Padre padre = new Padre("Luis", 46, jose);
    padre.mostrarInformacion();
    padre.reclamar();
  }
}
