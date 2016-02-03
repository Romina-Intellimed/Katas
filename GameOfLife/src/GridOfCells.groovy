/**
 * Created by romina on 03.02.2016.
 */



class GridOfCells {
    //GameOfLifeCell[][] gameOfLifeGrid
    def gameOfLifeGrid = []
    def liveCells = 0;
    def deadCells = 0;


    GridOfCells (){
    }

    def gridEvolution(){

        gameOfLifeGrid.size().times { i->
            gameOfLifeGrid.size().times {j->
                if (gameOfLifeGrid[i][j].state == false)
                    deadCells++
            }
        }
   return gameOfLifeGrid;
    }






}
