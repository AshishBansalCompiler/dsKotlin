package tictactoe

/*Given an integer represented as a string, we need to get the sum of all possible substrings of this string.
Examples:

Input  : num = “1234”
Output : 1670
Sum = 1 + 2 + 3 + 4 + 12 + 23 +
       34 + 123 + 234 + 1234
    = 1670

Input  : num = “421”
Output : 491
Sum = 4 + 2 + 1 + 42 + 21 + 421 = 491
*/


/*fun subStringsSum( p : String, start : Int, end : Int)  : Int{

}*/

fun main() {
    val str = "421"
    recurSolution(str)
    dpSumOfAllSubString(str)
}

fun dpSumOfAllSubString(string: String) {

    // there is a relation if we see sum of 1 digit and then 2 digit follow
/*
*  IN CASE OF 1234
* SUM OF 1 DIGIT = 1
* sum of 2 digit = 2+12
* sum of 3 digit = 3 + 23 + 123
* sum of 4 digit (call ot 4th) = 4 + 34 + 234 + 1234
*  4th = 4 + 30 + 4 + 230 + 4 + 1230 +4
* 4th = 4 * 4 + (30 + 230 + 1230)
* 4th = 4*4  + (3+23+123) * 10
* 4th = 4*4 + (3rd) * 10
*
* same way lets take
* 3rd = 3 + 23 + 123
* 3rd = 3 + 20 + 3 + 120 + 3
* 3rd = 3*3 + (20 + 120)
* 3rd = 3*3 + (2 + 12)10
* 3rd = 3*3 + (2nd) 10
* */

    val length = string.length
    val temp = IntArray(length+1)
    var sum = 0
    temp[0] = 0
    for (i in 1 .. length) {
        val c = string[i-1].toString()
        temp[i] = i * c.toInt() + (temp[i-1]) *10
        sum = sum + temp[i]
    }
    println(sum)
}

fun recurSolution(string: String) {

    var sum = 0

    for (i in 0 until string.length) {
        for (j in i+1 .. string.length) {
            var s = string.subSequence(i , j).toString()
            sum = sum + s.toInt()
        }
    }
    println(sum)
}
