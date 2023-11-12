import java.util.*;
import java.io.*;

public class Battleship {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] playerOneBoard = new char[5][5];
    char[][] playerTwoBoard = new char[5][5];
    char[][] playerOneShots = new char[5][5];
    char[][] playerTwoShots = new char[5][5];

    initializeBoard(playerOneBoard);
    initializeBoard(playerTwoBoard);
    initializeBoard(playerOneShots);
    initializeBoard(playerTwoShots);

    System.out.println("Welcome to Battleship!");

    setup(sc, playerOneBoard, "PLAYER 1");
    printBattleShip(playerOneBoard);
    printClearLines();

    setup(sc, playerTwoBoard, "PLAYER 2");
    printBattleShip(playerTwoBoard);
    printClearLines();

    while (true) {
      if (takeTurn(sc, playerOneShots, playerTwoBoard, "PLAYER 1", 1)) {
        System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        break;
      }
      if (takeTurn(sc, playerTwoShots, playerOneBoard, "PLAYER 2", 2)) {
        System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        break;
      }
    }

    printFinalBoards(playerOneBoard, playerTwoBoard);

    sc.close();
  }

  private static void initializeBoard(char[][] board) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        board[i][j] = '-';
      }
    }
  }

  private static void setup(Scanner sc, char[][] board, String player) {
    System.out.println(player + ", ENTER YOUR SHIPS’ COORDINATES.");
    for (int i = 0; i < 5; i++) {
      do {
        System.out.println("Enter ship " + (i + 1) + " location:");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (isValidCoordinate(row, col) && board[row][col] == '-') {
          board[row][col] = '@';
          break;
        } else if (isValidCoordinate(row, col)) {
          System.out.println("You already have a ship there. Choose different coordinates.");
        } else {
          System.out.println("Invalid coordinates. Choose different coordinates.");
        }
      } while (true);
    }
  }

  private static boolean isValidCoordinate(int row, int col) {
    return row >= 0 && row < 5 && col >= 0 && col < 5;
  }

  private static boolean takeTurn(Scanner sc, char[][] shotBoard, char[][] opponentBoard, String player, int playerId) {
    while (true) {
      System.out.println("Player " + playerId + ", enter hit row/column:");
      int row = sc.nextInt();
      int col = sc.nextInt();

      if (!isValidCoordinate(row, col)) {
        System.out.println("Invalid coordinates. Choose different coordinates.");
        continue;
      }

      if (shotBoard[row][col] != '-') {
        System.out.println("You already fired on this spot. Choose different coordinates.");
        continue;
      }

      if (opponentBoard[row][col] == '@') {
        opponentBoard[row][col] = 'X';
        shotBoard[row][col] = 'X';
        System.out.println(player + " HIT " + (player.equals("PLAYER 1") ? "PLAYER 2" : "PLAYER 1") + "’s SHIP!");
      } else {
        opponentBoard[row][col] = 'O';
        shotBoard[row][col] = 'O';
        System.out.println(player + " MISSED!");
      }

      printBattleShip(shotBoard);

      if (isGameOver(opponentBoard)) {
        return true;
      }
      break;
    }
    return false;
  }

  private static boolean isGameOver(char[][] board) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (board[i][j] == '@') {
          return false;
        }
      }
    }
    return true;
  }

  private static void printFinalBoards(char[][] playerOneBoard, char[][] playerTwoBoard) {
    System.out.println("Final boards:");
    printBattleShip(playerOneBoard);
    printBattleShip(playerTwoBoard);
  }

  // Use this method to print game boards to the console.
  private static void printBattleShip(char[][] player) {
    System.out.print("  ");
    for (int row = -1; row < 5; row++) {
      if (row > -1) {
        System.out.print(row + " ");
      }
      for (int column = 0; column < 5; column++) {
        if (row == -1) {
          System.out.print(column + " ");
        } else {
          System.out.print(player[row][column] + " ");
        }
      }
      System.out.println("");
    }
  }

  private static void printClearLines() {
    for (int i = 0; i < 100; i++) {
      System.out.println();
    }
  }
}
