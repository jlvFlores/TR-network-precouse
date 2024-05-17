abstract class Persona {
  // Atributos
  private String nombre;
  private int edad;

  // Constructor
  public Persona(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  // Encapsulamiento
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  // Métodos
  public void mostrarInformacion() {
    System.out.println(nombre + " tiene " + edad + " años de edad.");
  }
}
