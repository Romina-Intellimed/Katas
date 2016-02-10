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
                def result = countAliveCellNeighbours(grid, x, y)
                //grid[x][y] = cellType
                println(result)
            }
        }
        grid
    }


    def countAliveCellNeighbours(grid, xPos, yPos) {
        def aliveNeighbours=0
        def neighbours = [[xPos - 1, yPos - 1], [xPos - 1, yPos], [xPos - 1, yPos + 1], [xPos, yPos - 1], [xPos, yPos + 1], [xPos + 1, yPos - 1], [xPos + 1, yPos], [xPos + 1, yPos + 1]]
        def surroundedGrid = Grid.surroundGridwithDeadCells(grid)

        neighbours.size().times { it->
            if(surroundedGrid[neighbours[it][0]][neighbours[it][1]]==CellType.alive)
                aliveNeighbours++

        }
        aliveNeighbours
    }

}



