package GraphSearch.numberofisland;

public class Main {

    public static void main(String args[]){

        System.out.println(numberofIsland(new int [][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}}));

    }

    public static int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int numberofIsland(int [][]graph){

        int numberofisland = 0;

        for(int i = 0; i < graph.length; i++){

            for(int j = 0; j < graph[0].length; j++){

                if(graph[i][j] == 1){
                    depthFirstSearch(graph, i, j);
                    numberofisland++;
                }

            }

        }

        return  numberofisland;

    }

    public static void depthFirstSearch(int [][]graph, int row, int col){

        if(!isValid(graph,row,col) || graph[row][col] == 0)
            return;

        graph[row][col] = 0;

        for(int i = 0; i < direction.length; i++){
            depthFirstSearch(graph, row + direction[i][0], col + direction[i][1]);
        }

        return;

    }

    public static boolean isValid(int [][]graph, int row, int col){

        return ((row >= 0 && row < graph.length) && (col >= 0 && col < graph[0].length));

    }


}
