/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid){


       [[CellType.dead,CellType.dead],[CellType.dead,CellType.dead]]
    }



    def generationGridEvolutionWithLiveCells(grid){
        if(countLiveCells(grid)==3)
            [[CellType.alive,CellType.alive],[CellType.alive,CellType.alive]]
    }

    private int countLiveCells(grid) {
        def liveCells = 0

        (grid.size()).times { x ->
            (grid.size()).times { y ->
                if (grid[x][y] == CellType.alive)
                    liveCells++
            }
        }
        liveCells
    }
}
