import java.util.ArrayList;

public class Estudiante extends Persona {
  // Atributos
  private ArrayList<Integer> notas = new ArrayList<>();

  // Constructor
  public Estudiante(String nombre, int edad) {
    super(nombre, edad);
  }

  // Métodos
  public void agregarNota(int nota) {
    notas.add(nota);
  }

  public double calcularPromedio() {
    if (notas.isEmpty()) {
      return 0;
    }
    double total = 0;
    for (Integer nota : notas) {
      total += nota;
    }
    return total / notas.size();
  }

  // Encapsulamiento
  public ArrayList<Integer> getNotas() {
    return new ArrayList<>(notas);
  }

  public void setNotas(ArrayList<Integer> notas) {
    this.notas = new ArrayList<>(notas);
  }

  // Polimorfismo
  @Override
  public void mostrarInformacion() {
    System.out.println(getNombre() + " tiene " + getEdad() + " años de edad y su promedio es de " + calcularPromedio());
  }

  public static void main(String[] args) {
    Estudiante estudiante = new Estudiante("Jose", 24);
    estudiante.agregarNota(10);
    estudiante.agregarNota(8);
    estudiante.agregarNota(10);
    System.out.println(estudiante.calcularPromedio());
    estudiante.mostrarInformacion();
  }
}
