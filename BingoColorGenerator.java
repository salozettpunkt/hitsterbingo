import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoColorGenerator {
    private static final String[] COLORS = {"#FFD700", "#800080", "#FFC0CB", "#0000FF", "#008000"}; // Gelb, Lila, Pink, Blau, Grün

    public static String[][] generateBingoBoard() {
        String[][] board = new String[5][5];
        List<String> colorList = new ArrayList<>();

        // Füge max. zweimal jede Farbe zur Liste hinzu
        for (String color : COLORS) {
            colorList.add(color);
            colorList.add(color);
        }

        // Leere Zellen hinzufügen, um die Liste auf 25 zu erweitern
        while (colorList.size() < 25) {
            colorList.add("#FFFFFF"); // Füge eine weiße Farbe hinzu
        }

        // Liste mischen
        Collections.shuffle(colorList);

        // Farben im 5x5 Raster platzieren
        int index = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                board[row][col] = colorList.get(index++);
            }
        }

        return board;
    }

    public static void main(String[] args) {
        String[][] board = generateBingoBoard();
        for (String[] row : board) {
            for (String color : row) {
                System.out.print(color + " ");
            }
            System.out.println();
        }
    }
}
