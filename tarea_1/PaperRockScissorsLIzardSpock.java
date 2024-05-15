import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaperRockScissorsLIzardSpock {
  public static void main(String[] args) {
    List<String[]> partidas = List.of(
      new String[]{"piedra", "tijera"},
      new String[]{"tijera", "piedra"},
      new String[]{"papel", "tijera"}
    );

    System.out.println(determineOverallWinner(partidas));
  }

  public static String determineOverallWinner(List<String[]> partidas) {
    Map<String, Set<String>> reglas = new HashMap<>();
    reglas.put("piedra", new HashSet<>(Set.of("tijera", "lagarto")));
    reglas.put("papel", new HashSet<>(Set.of("piedra", "spock")));
    reglas.put("tijera", new HashSet<>(Set.of("papel", "lagarto")));
    reglas.put("lagarto", new HashSet<>(Set.of("spock", "papel")));
    reglas.put("spock", new HashSet<>(Set.of("tijera", "piedra")));

    int jugadorUnoVictorias = 0;
    int jugadorDosVictorias = 0;

    for (String[] partida : partidas) {
      String jugadorUnoOpcion = partida[0];
      String jugadorDosOpcion = partida[1];
      
      if (jugadorUnoOpcion.equals(jugadorDosOpcion)) {
        continue;
      } else if (reglas.get(jugadorUnoOpcion).contains(jugadorDosOpcion)) {
        jugadorUnoVictorias ++;
      } else if (reglas.get(jugadorDosOpcion).contains(jugadorUnoOpcion)) {
        jugadorDosVictorias ++;
      } else {
        System.out.println("Opciones Invalidas: " + jugadorUnoOpcion + " vs " + jugadorDosOpcion);
      }
    }

    if (jugadorUnoVictorias > jugadorDosVictorias) {
      return "Player 1";
    } else if (jugadorDosVictorias > jugadorUnoVictorias) {
      return "Player 2";
    } else {
      return "Tie";
    }
  }
}
