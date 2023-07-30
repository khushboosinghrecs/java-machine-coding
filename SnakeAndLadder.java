import java.util.*;

class Player {
    String name;
    int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }
}

public class SnakeAndLadder {
    private static Map<Integer, Integer> snakes;
    private static Map<Integer, Integer> ladders;
    private static List<Player> players;
    private static int diceSides = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new ArrayList<>();

        int numSnakes = scanner.nextInt();
        for (int i = 0; i < numSnakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head, tail);
        }

        int numLadders = scanner.nextInt();
        for (int i = 0; i < numLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.put(start, end);
        }

        int numPlayers = scanner.nextInt();
        for (int i = 0; i < numPlayers; i++) {
            String name = scanner.next();
            players.add(new Player(name));
        }

        playGame();
    }

    private static void playGame() {
        Random random = new Random();

        while (true) {
            for (Player player : players) {
                int diceRoll = random.nextInt(diceSides) + 1;
                int prevPosition = player.position;
                player.position += diceRoll;

                if (player.position > 100) {
                    player.position = prevPosition;
                } else {
                    if (snakes.containsKey(player.position)) {
                        player.position = snakes.get(player.position);
                    } else if (ladders.containsKey(player.position)) {
                        player.position = ladders.get(player.position);
                    }
                }

                System.out.println(player.name + " rolled a " + diceRoll +
                        " and moved from " + prevPosition + " to " + player.position);

                if (player.position == 100) {
                    System.out.println(player.name + " wins the game");
                    return;
                }
            }
        }
    }
}
