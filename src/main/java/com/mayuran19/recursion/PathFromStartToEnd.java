package com.mayuran19.recursion;

import java.util.Arrays;

/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 20/8/24
 * @license iLex
 */
public class PathFromStartToEnd {
    public static void main(String[] args) {
        var mazeQueen = new boolean[][]{{
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }, {
                false, false, false, false, false, false, false
        }};

        nqueen(mazeQueen);
    }

    public static void printPath(String processed, int row, int col) {
        if (row == 0 && col == 0) {
            //System.out.println(processed);
            return;
        }
        // Move right
        if (col > 0) {
            printPath(processed + "R", row, col - 1);
        }
        if (row > 0) {
            printPath(processed + "D", row - 1, col);
        }
    }

    public static void printPathWithObstacle(String processed, int currentRow, int currentCol, int targetRow, int targetCol, boolean[][] maze) {
        if (currentRow == targetRow && currentCol == targetCol) {
            System.out.println(processed);
            return;
        }
        // Move right
        if (currentCol < targetCol) {
            if (maze[currentRow][currentCol]) {
                printPathWithObstacle(processed + "R", currentRow, currentCol + 1, targetRow, targetCol, maze);
            }
        }
        if (currentRow < targetRow) {
            if (maze[currentRow][currentCol]) {
                printPathWithObstacle(processed + "D", currentRow + 1, currentCol, targetRow, targetCol, maze);
            }
        }
    }

    public static void printPathWithObstacleTopAndLeft(String processed, int currentRow, int currentCol, boolean[][] maze) {
        if (currentRow == maze.length - 1 && currentCol == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        // Move right
        maze[currentRow][currentCol] = false;
        if (currentCol < maze[0].length - 1) {
            if (maze[currentRow][currentCol + 1]) {
                printPathWithObstacleTopAndLeft(processed + "R", currentRow, currentCol + 1, maze);
            }
        }
        // Move left
        if (currentCol > 0) {
            if (maze[currentRow][currentCol - 1]) {
                printPathWithObstacleTopAndLeft(processed + "L", currentRow, currentCol - 1, maze);
            }
        }
        if (currentRow < maze.length - 1) {
            if (maze[currentRow + 1][currentCol]) {
                printPathWithObstacleTopAndLeft(processed + "D", currentRow + 1, currentCol, maze);
            }
        }
        if (currentRow > 0) {
            if (maze[currentRow - 1][currentCol]) {
                printPathWithObstacleTopAndLeft(processed + "U", currentRow - 1, currentCol, maze);
            }
        }
        maze[currentRow][currentCol] = true;
    }

    public static void nqueen(boolean[][] maze) {
        for(int i = 0; i < maze[0].length; i++){
            nqueen(0, i, maze);
        }
    }

    public static void nqueen(int currentRow, int currentCol, boolean[][] maze) {
        maze[currentRow][currentCol] = true;
        if (isSafe(currentRow, currentCol, maze)) {
            // Place the next queen
            if(currentRow == maze.length - 1){
                // the solution is found
                System.out.println(Arrays.deepToString(maze));
            }else{
                nqueen(currentRow+1, 0, maze);
                maze[currentRow][currentCol] = false;
            }
        } else {
            maze[currentRow][currentCol] = false;
            // check the next column
            if(currentCol == maze[0].length - 1){
                // can't place the queen, backtrack
            }else{
                nqueen(currentRow, currentCol + 1, maze);
            }
        }
        maze[currentRow][currentCol] = false;
    }

    public static boolean isSafe(int currentRow, int currentCol, boolean[][] maze) {
        // check all columns of this row are safe
        for (int i = 0; i < maze[0].length; i++) {
            if(i == currentCol){
                continue;
            }
            if (maze[currentRow][i]) {
                return false;
            }
        }

        // check all rows of this columns are safe
        for (int i = 0; i < maze.length; i++) {
            if(i == currentRow){
                continue;
            }
            if (maze[i][currentCol]) {
                return false;
            }
        }

        // check all left corner cells are safe
        int tmpCurrentRow = currentRow;
        int tmpCurrentCol = currentCol;
        while (tmpCurrentCol >= 0 && tmpCurrentRow >= 0) {
            if(tmpCurrentCol == currentCol && tmpCurrentRow == currentRow){
                tmpCurrentCol--;
                tmpCurrentRow--;
                continue;
            }
            if (maze[tmpCurrentRow][tmpCurrentCol]) {
                return false;
            }
            tmpCurrentCol--;
            tmpCurrentRow--;
        }

        tmpCurrentRow = currentRow;
        tmpCurrentCol = currentCol;
        while (tmpCurrentCol < maze[0].length && tmpCurrentRow < maze.length) {
            if(tmpCurrentCol == currentCol && tmpCurrentRow == currentRow){
                tmpCurrentCol++;
                tmpCurrentRow++;
                continue;
            }
            if (maze[tmpCurrentRow][tmpCurrentCol]) {
                return false;
            }
            tmpCurrentCol++;
            tmpCurrentRow++;
        }

        // check all right corner cells are safe
        tmpCurrentRow = currentRow;
        tmpCurrentCol = currentCol;
        while (tmpCurrentCol >= 0 && tmpCurrentRow < maze.length) {
            if(tmpCurrentCol == currentCol && tmpCurrentRow == currentRow){
                tmpCurrentCol--;
                tmpCurrentRow++;
                continue;
            }
            if (maze[tmpCurrentRow][tmpCurrentCol]) {
                return false;
            }
            tmpCurrentCol--;
            tmpCurrentRow++;
        }

        tmpCurrentRow = currentRow;
        tmpCurrentCol = currentCol;
        while (tmpCurrentCol < maze[0].length && tmpCurrentRow >= 0) {
            if(tmpCurrentCol == currentCol && tmpCurrentRow == currentRow){
                tmpCurrentCol++;
                tmpCurrentRow--;
                continue;
            }
            if (maze[tmpCurrentRow][tmpCurrentCol]) {
                return false;
            }
            tmpCurrentCol++;
            tmpCurrentRow--;
        }

        return true;
    }
}
