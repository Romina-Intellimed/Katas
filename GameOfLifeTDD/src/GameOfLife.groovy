/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        if (countLiveCells(grid) >= 3 && grid.size == 2)
            nextGenerationGridWithTheSameTypeCells(grid, CellType.alive)
        else if (grid.size == 2)
            nextGenerationGridWithTheSameTypeCells(grid, CellType.dead)
        else if (grid.size > 2)
       //     nextGenerationGridWithDifferentTypeCells(grid)
           nextGenerationGridWithTheSameTypeCells(grid, CellType.dead)
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

    def nextGenerationGridWithTheSameTypeCells(grid, cellType) {
        (grid.size()).times { x ->
            (grid.size()).times { y ->
                grid[x][y] = cellType
            }
        }
        grid
    }


    def nextGenerationGridWithDifferentTypeCells(grid) {
        (grid.size()).times { x ->
            (grid.size()).times { y ->
                def result = countDeadCellNeighbours(grid, x, y)
                //grid[x][y] = cellType
                println(result)
            }
        }
        grid
    }

    def surroundGridwithDeadCells(grid) {
        def gridToCheck = []
        (grid.size()+2).times { x ->
            gridToCheck[x]=[]
            (grid.size()+2).times { y ->
                gridToCheck[x][y] = CellType.dead
            }
        }

        (gridToCheck.size()-2).times{ x->
            (gridToCheck.size()-2).times { y ->
                gridToCheck[x+1][y+1] = grid[x][y]
            }
        }
        gridToCheck
    }

    def countDeadCellNeighbours(grid, xPos, yPos) {
        def deadNeighbours=0
        def neighbours = [[xPos - 1, yPos - 1], [xPos - 1, yPos], [xPos - 1, yPos + 1], [xPos, yPos - 1], [xPos, yPos + 1], [xPos + 1, yPos - 1], [xPos + 1, yPos], [xPos + 1, yPos + 1]]
        def surroundedGrid = surroundGridwithDeadCells(grid)

        neighbours.size().times { it->
            if(surroundedGrid[neighbours[it][0]][neighbours[it][1]]==CellType.dead)
                deadNeighbours++

        }
        deadNeighbours
    }

}



