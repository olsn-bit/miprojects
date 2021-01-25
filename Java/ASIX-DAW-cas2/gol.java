/*
PROG NOTES:

*/
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
public class gol{
    public static int[][] grid1;
    public static int grid1size = 40;
    public static int[][] createGrid(int size){
        int[][] grid = new int[size*size][];
        for (int t = 0;t<size;t++){
          grid[t] = new int[size];
        }
        for (int row = 0;row<size;row++){
            for (int cell = 0;cell<size;cell++){
                grid[row][cell] = 0;
            }
        }
        return grid;
    }
    public static void printarr(int[][] array, int size){
        int count = 0;
        for( int a = 0;a<size; a++ ){
            String line = "";
            for( int b = 0;b<size; b++ ){
                if (array[a][b] == 0){
                    line += " . ";
                }
                else if (array[a][b] == -1){line += " o ";}
                else if (array[a][b] == 2){line += " B ";}
                else{line += " A ";}
                count++;
            }
            System.out.println(line);
        }
    }
    public static void chval(int row, int cell, int[][] array,int size){
        if (array[row][cell] == 0){
            array[row][cell] = 1;
        } else {array[row][cell] = 0;}

    }
    static void update( int[][] array,int size){
        int[][] tmp_grid =new int[size][];
        for (int i = 0; i < tmp_grid.length; ++i) {
            tmp_grid[i] = new int[size];
            for (int j = 0; j < tmp_grid[i].length; ++j) {
              tmp_grid[i][j] = array[i][j];
            }
        }
        final int[][] compare = {{-1,-1},{-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1}};
        for (int row = 0;row<size;row++){
            for (int cell = 0;cell<size;cell++){
              int alive = 0;
              int dead = 0;
              for(int e[] : compare){
                  try{
                      if ( tmp_grid[row+e[0]][cell + e[1]] != 1){
                          dead++;
                      }else{
                          alive++;
                      }
                  }catch(Exception IndexOutOfBoundsException){}
              }
              // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
              if (tmp_grid[row][cell] == 1 && alive < 2){
                array[row][cell] = 0;
              // Any live cell with two or three live neighbours lives on to the next generation.
              }else if(tmp_grid[row][cell] == 1 && alive >= 2 && alive <= 3 ){
                array[row][cell] = 1;}
              // Any live cell with more than three live neighbours dies, as if by overpopulation.
              else if(tmp_grid[row][cell] == 1 && alive > 3){
                  array[row][cell] = 0;
              // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
              }else if(tmp_grid[row][cell] == 0 && alive == 3){
                  array[row][cell] = 1; }
              }
        }
    }
    public static void tmp_tmpl(int[][] grid,int size){
      for(int num = 3;num<9;num+=3){
      chval(num, num, grid,size);
      chval(num, num-1, grid,size);
      chval(num, num-2, grid,size);
      chval(num-1,num,grid,size);
      chval(num-2,num-1,grid,size);
      }
    }
    public static void main(String[] args){
        TimeUnit time = TimeUnit.MILLISECONDS;
        grid1size = gol.grid1size;
        grid1 = gol.grid1;
        gol.grid1 = createGrid(grid1size);
        tmp_tmpl(grid1,grid1size);
        int gen = 1;
        while (true){
          System.out.println("Generation : "+gen);
          printarr(grid1,grid1size);
          update(grid1,grid1size);
          gen++;
          try{
            time.sleep(400);
          }
          catch(InterruptedException a) {
              Thread.currentThread().interrupt();
          }
        }

    }
}
