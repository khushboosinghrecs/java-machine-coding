import java.util.*;

class SnakeLadder {
    private static int[] board;
    private static Map<Integer, Integer> snakes;
    private static Map<Integer, Integer> ladders;
    private static Map<Integer, String> players;
    private static int currentPlayerIndex;
    private static final int WINNING_POSITION = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of snakes:");
        int s = scanner.nextInt();
        scanner.nextLine();

        snakes = new HashMap<>();
        for (int i = 0; i < s; i++) {
         //   System.out.println("Enter head and tail positions for snake " + (i + 1) + ":");
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head, tail);
            scanner.nextLine();
        }

        System.out.println("Enter the number of ladders:");
        int l = scanner.nextInt();
        scanner.nextLine();

        ladders = new HashMap<>();
        for (int i = 0; i < l; i++) {
           // System.out.println("Enter start and end positions for ladder " + (i + 1) + ":");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.put(start, end);
            scanner.nextLine();
        }

        System.out.println("Enter the number of players:");
        int p = scanner.nextInt();
        scanner.nextLine();

        players = new HashMap<>();
        for (int i = 0; i < p; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String playerName = scanner.nextLine();
            players.put(i, playerName);
        }

        currentPlayerIndex = 0;
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        board = new int[WINNING_POSITION + 1];
        for (int i = 0; i <= WINNING_POSITION; i++) {
            board[i] = i;
        }
        for (int head : snakes.keySet()) {
            board[head] = snakes.get(head);
        }
        for (int start : ladders.keySet()) {
            board[start] = ladders.get(start);
        }
    }

    private static void playGame() {
        Random random = new Random();
        while (true) {
            int diceValue = random.nextInt(6) + 1;
            int currentPlayerPosition = board[currentPlayerIndex];
            int newPosition = currentPlayerPosition + diceValue;

            if (newPosition <= WINNING_POSITION) {
                System.out.println(players.get(currentPlayerIndex) + " rolled a " + diceValue +
                        " and moved from " + currentPlayerPosition + " to " + newPosition);

                if (newPosition == WINNING_POSITION) {
                    System.out.println(players.get(currentPlayerIndex) + " wins the game");
                    break;
                }

                // Check if the new position is the head of a snake or the start of a ladder
                int updatedPosition = board[newPosition];
                if (newPosition != updatedPosition) {
                    System.out.println("Landed on a " + (newPosition > updatedPosition ? "ladder" : "snake") +
                            " and moved to position " + updatedPosition);
                }

                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
    }
}
