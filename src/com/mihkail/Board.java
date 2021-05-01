package com.mihkail;

import java.util.Scanner;

public class Board {
    private int[][] pole;
    private String player1;
    private String player2;

    Board(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        pole = new int[3][3];
    }

    public void startGame() {
        Scanner in = new Scanner(System.in);
        int count = 0; // количество сделанных ходов
        int hod = 1; // очередь какого игрока сейчас ходить
        int x, y;
        boolean end = false;

        while (end == false && count != 9) {
            if (hod == 1) {
                System.out.println(player1 + " ходите: ");
                x = in.nextInt();
                y = in.nextInt();

                if (pole[x-1][y-1] == 0) {
                    pole[x-1][y-1] = 1;
                    hod = 2;
                }
                else {
                    System.out.println("Это поле уже занято, попробуйте снова");
                    continue;
                }
            }
            else if (hod == 2) {
                System.out.println(player2 + " ходите");
                x = in.nextInt();
                y = in.nextInt();

                if (pole[x-1][y-1] == 0) {
                    pole[x-1][y-1] = 2;
                    hod = 1;
                }
                else {
                    System.out.println("Это поле уже занято, попробуйте снова");
                    continue;
                }
            }
            end = checkPosition();
            count++;

            displayBoard();
        }

        if (end == true) {
            if (hod == 2) {
                System.out.println("Конец игры. " + player1 + " поздравляю с победой");
            }
            else {
                System.out.println("Конец игры. " + player2 + " поздравляю с победой");
            }
        }
        else {
            System.out.println("Конец игры. Никто не победил. Объявлена ничья");
        }

    }

    private boolean checkPosition() {
        if (pole[0][0] != 0 && pole[0][0] == pole[0][1] && pole[0][0] == pole[0][2]) {
            return true;
        }
        else if (pole[1][0] != 0 && pole[1][0] == pole[1][1] && pole[1][0] == pole[1][2]) {
            return true;
        }
        else if (pole[2][0] != 0 && pole[2][0] == pole[2][1] && pole[2][0] == pole[2][2]) {
            return true;
        }
        else if (pole[0][0] != 0 && pole[0][0] == pole[0][1] && pole[0][0] == pole[0][2]) {
            return true;
        }
        else if (pole[0][1] != 0 && pole[0][1] == pole[1][1] && pole[0][1] == pole[2][1]) {
            return true;
        }
        else if (pole[0][2] != 0 && pole[0][2] == pole[1][2] && pole[0][2] == pole[2][2]) {
            return true;
        }
        else if (pole[0][0] != 0 && pole[0][0] == pole[1][1] && pole[0][0] == pole[2][2]) {
            return true;
        }
        else if (pole[0][2] != 0 && pole[0][2] == pole[1][1] && pole[0][2] == pole[2][0]) {
            return true;
        }
        else {
            return false;
        }
    }

    private void displayBoard() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(pole[i][j]);
            }
            System.out.println();
        }
    }

}
