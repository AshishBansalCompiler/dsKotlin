package tictactoe

/*
*
* Given a binary N x N matrix, we need to find the total number of matrix positions from which there is an endless path. Any position (i, j) is said to have an endless path if and only if the position (i,j) has the value 1 and all of the next positions in its row(i) and its column(j) should have value 1. If any position next to (i,j) either in row(i) or in column(j) will have 0 then position (i,j) doesn’t have any endless path.

Examples:

Input :  0 1 0
         1 1 1
         0 1 1
Output : 4
Endless points are (1, 1), (1, 2),
(2, 1) and (2, 2). For all other
points path to some corner is
blocked at some point.

* */

fun main() {
    val array = arrayOf(arrayOf(false, true, false),
                        arrayOf(true, true, true),
                        arrayOf(false, true, true))
    val numberOfEndLessPoints = NumberOfEndLessPoints(array)

    println(numberOfEndLessPoints.calculateEndLessPoint())
}

class NumberOfEndLessPoints(val array : Array<Array<Boolean>>) {

    fun calculateEndLessPoint() : Int {
        val rowEndless = Array(array.size){BooleanArray(array[0].size)}
        val colEndless = Array(array.size){BooleanArray(array[0].size)}

        for (i in 0 until array.size) {
            var endless = true
            for (j in array.size-1 downTo 0) {
                if (array[i][j] == false) {
                    endless = false
                }
                rowEndless[i][j] = endless
            }
        }

        for (j in 0 until array.size) {
            var endless = true
            for (i in array.size-1 downTo 0) {
                if (array[i][j] == false) {
                    endless = false
                }
                colEndless[i][j] = endless
            }
        }
        var ans = 0

        for (i in 0 until array.size) {
            for (j in 0 until array.size) {
                if (rowEndless[i][j] && colEndless[i][j]) {
                    ans ++
                }
            }
        }
        return ans
    }
}
