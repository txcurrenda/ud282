package com.udacity;

class Result {

    private char[][] grid;

    Result(char[][] grid) {
        this.grid = grid;
    }

    String getResult() {

        String result;

        result = checkRows();
        if (!result.isEmpty()) return result;

        result = checkCollumns();
        if (!result.isEmpty()) return result;

        result = checkLeftDiagonal();
        if (!result.isEmpty()) return result;

        result = checkRightDiagonal();
        if (!result.isEmpty()) return result;

        result = checkNone();
        return !result.isEmpty() ? result : "Tie";

    }

    private String checkRows() {
        for (int row = 0; row <= 2; row++) {
            char ch = grid[row][0];
            boolean won = true;
            for (int col = 0; col <= 2; col++) {
                if (ch != grid[row][col] || isEmptyField(ch)) {
                    won = false;
                    break;
                }
            }
            if (won)
                return String.format("%c wins", ch);
        }

        return "";
    }

    private String checkCollumns() {

        for (int col = 0; col <= 2; col++) {
            char ch = grid[0][col];
            boolean won = true;
            for (int row = 0; row <= 2; row++) {
                if (ch != grid[row][col] || isEmptyField(ch)) {
                    won = false;
                    break;
                }
            }
            if (won)
                return String.format("%c wins", ch);
        }
        return "";
    }

    private String checkLeftDiagonal() {
        boolean won = true;
        char ch = grid[0][0];
        for (int row = 0, col = 0; row <= 2; row++, col++) {
            if (ch != grid[row][col] || isEmptyField(ch)) {
                won = false;
                break;
            }
        }
        return won ? String.format("%c wins", ch) : "";
    }

    private String checkRightDiagonal() {
        char ch = grid[0][2];
        boolean won = true;
        for (int row = 0, col = 2; row <= 2; row++, col--) {
            if (ch != grid[row][col] || isEmptyField(ch)) {
                won = false;
                break;
            }
        }
        return won ? String.format("%c wins", ch) : "";
    }

    private String checkNone() {
        boolean tie = true;
        for (int row = 0; row <= 2; row++) {
            if (!tie) break;

            for (int col = 0; col <= 2; col++) {
                if (isEmptyField(grid[row][col])) {
                    tie = false;
                    break;
                }
            }
        }
        return tie ? "" : "None";
    }

    private boolean isEmptyField(char ch)
    {
        return ch == '-';
    }
}
