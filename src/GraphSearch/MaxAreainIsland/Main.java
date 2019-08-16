package GraphSearch.MaxAreainIsland;

public class Main {

    public static void main(String args[]) {

        System.out.println(maxAreaofIsland(
                new int[][] { { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1, } }));

    }

    static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static boolean isValid(int grid[][], int row, int col) {
        return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
    }

    public static int maxAreaofIsland(int grid[][]) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfsMaxArea(grid, i, j));
            }
        }

        return maxArea;

    }

    public static int dfsMaxArea(int grid[][], int row, int col) {

        if (!isValid(grid, row, col) || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;

        int count = 1;

        for (int i = 0; i < directions.length; i++) {
            count += dfsMaxArea(grid, row + directions[i][0], col + directions[i][1]);
        }

        return count;

    }

}
