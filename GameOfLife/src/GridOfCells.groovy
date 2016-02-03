/**
 * Created by romina on 03.02.2016.
 */


class GridOfCells {
    //GameOfLifeCell[][] gameOfLifeGrid
    def gameOfLifeGrid = []
    def liveCells = 0;
    def deadCells = 0;
    static def MIN_X = 0
    static def MIN_Y = 0
    def MAX_X = gameOfLifeGrid.size()
    def MAX_Y = gameOfLifeGrid.size()




    GridOfCells() {

    }



    def countNeighboursLiveCells(thisPosX, thisPosY){
        def neighboursLiveCells=0
        int startPosX = (thisPosX - 1 < MIN_X) ? thisPosX : thisPosX-1;
        int startPosY = (thisPosY - 1 < MIN_Y) ? thisPosY : thisPosY-1;
        int endPosX =   (thisPosX + 1 > MAX_X) ? thisPosX : thisPosX+1;
        int endPosY =   (thisPosY + 1 > MAX_Y) ? thisPosY : thisPosY+1;
        println " thisPosX = ${thisPosX} and thisPosY=${thisPosY}"

        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                // All the neighbors will be grid[rowNum][colNum]
                println " cell with rowNum = ${rowNum} and colNum=${colNum} is ${gameOfLifeGrid[rowNum][colNum]}"
                if(gameOfLifeGrid[rowNum][colNum].state == true)
                    neighboursLiveCells++

            }
        }

        return neighboursLiveCells

    }

    def gridEvolution() {
        println "grid: ${gameOfLifeGrid}"
        (gameOfLifeGrid.size()).times { i ->
            (gameOfLifeGrid.size()).times { j ->
               // println " cell with i = ${i} and j=${j} is ${gameOfLifeGrid[i][j]}"
                println " liveCells = ${liveCells} and deadCells=${deadCells} "
                if (gameOfLifeGrid[i][j].state==true &&  (countNeighboursLiveCells(i,j)>=2 || countNeighboursLiveCells(i,j)<=3)) {
                    gameOfLifeGrid[i][j].state == true

                }
                else   if (gameOfLifeGrid[i][j].state==true &&  countNeighboursLiveCells(i,j)<2 ){
                    gameOfLifeGrid[i][j].state == false

                }
                else   if (gameOfLifeGrid[i][j].state==true &&  countNeighboursLiveCells(i,j)>3 ){
                    gameOfLifeGrid[i][j].state == false
                }
                else if (gameOfLifeGrid[i][j].state == false && countNeighboursLiveCells(i, j) == 3) {
                    gameOfLifeGrid[i][j].state == true

                } else if (gameOfLifeGrid[i][j].state == false && (countNeighboursLiveCells(i,j)<2 || countNeighboursLiveCells(i,j)>3)) {
                    gameOfLifeGrid[i][j].state ==false

                }
          }
        }
        return gameOfLifeGrid;
    }

    def countTypeOfCells(){
        gameOfLifeGrid.size().times { i ->
            gameOfLifeGrid.size().times { j ->
                if(gameOfLifeGrid[i][j].state == false)
                    deadCells++
                else if (gameOfLifeGrid[i][j].state == true)
                    liveCells++
            }
        }
    }


}
