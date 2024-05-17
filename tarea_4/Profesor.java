public class Profesor extends Persona{
  // Atributos
  private String clase;

  // Constructor
  Profesor(String nombre, int edad, String clase) {
    super(nombre, edad);
    this.clase = clase;
  }

  // Metodos
  public void presentar() {
    System.out.println("Hola a todos, hoy les hablare de " + clase);
  }

  // Encapsulamiento
  public String getClase() {
    return clase;
  }

  public void setClase(String clase) {
    this.clase = clase;
  }

  public static void main(String[] args) {
    Profesor profesor = new Profesor("Sunny", 42, "Guitarra");
    profesor.setClase("Canto");
    profesor.mostrarInformacion();
    profesor.presentar();
  }
}
