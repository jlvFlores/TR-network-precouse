import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
  public static void main(String[] args) {
    // TODO:
    // El usuario puede introducir una palabra (de la misma longitud que la palabra a adivinar)

    Random azar = new Random();
    List<String> palabras = List.of("madurar", "aprendizaje", "ejercicio", "crecer", "sobresalir");
    String palabraElegida = palabras.get(azar.nextInt(palabras.size()));
        
    int longitudDePalabra = palabraElegida.length();
    int letrasPorRevelar = (int) Math.ceil(longitudDePalabra * 0.6);

    char[] charsVisibles = new char[longitudDePalabra];
    for (int i = 0; i < longitudDePalabra; i++) {
      charsVisibles[i] = '_';
    }

    int charsRevelados = 0;
    while (charsRevelados < letrasPorRevelar) {
      int indice = azar.nextInt(longitudDePalabra);
      if (charsVisibles[indice] == '_') {
        charsVisibles[indice] = palabraElegida.charAt(indice);
        charsRevelados++;
      }
    }

    int intentosRestantes = 5;
    List<Character> letrasAdivinadas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    while (intentosRestantes > 0) {
      System.out.println("Palabra actual: " + String.valueOf(charsVisibles));
      System.out.println("Letras adivinadas: " + letrasAdivinadas);
      System.out.println("Intentos restantes: " + intentosRestantes);
      System.out.print("Ingresa una letra: ");
      char entrada = scanner.nextLine().toLowerCase().charAt(0);
      
      if (letrasAdivinadas.contains(entrada)) {
        System.out.println("Ya usaste esa letra, intentalo de nueve.");
        continue;
      }

      letrasAdivinadas.add(entrada);

      if (palabraElegida.indexOf(entrada) >= 0) {
        revelarLetras(palabraElegida, charsVisibles, entrada);
        if (String.valueOf(charsVisibles).equals(palabraElegida)) {
          System.out.println("Felicidades, la palabra era: " + palabraElegida);
          break;
        }
      } else {
        intentosRestantes--;
        System.out.println("Entrada errónea");
      }
    }

    if (intentosRestantes == 0) {
      System.out.println("Se te acabaron los intentos, la palabra era: " + palabraElegida);
    }

    scanner.close();
  }

  private static void revelarLetras(String palabraElegida, char[] charsVisibles, char entrada) {
    for (int i = 0; i < palabraElegida.length(); i++) {
      if (palabraElegida.charAt(i) == entrada) {
        charsVisibles[i] = entrada;
      }
    }
  }
}
