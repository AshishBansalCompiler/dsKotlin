package tictactoe

import kotlin.math.min

/*We need to write N same characters on a screen and each time we can insert a character, delete the last character and copy and paste all written characters i.e. after copy operation count of total written character will become twice. Now we are given time for insertion, deletion and copying. We need to output minimum time to write N characters on the screen using these operations.

Examples:

Input : N = 9
        insert time = 1
        removal time = 2
        copy time = 1
Output : 5
N character can be written on screen in 5 time units as shown below,
insert a character
characters = 1  total time = 1
again insert character
characters = 2  total time = 2
copy characters
characters = 4  total time = 3
copy characters
characters = 8  total time = 4
insert character
characters = 9  total time = 5
 */

fun minWrite(n : Int, insertioncost : Int, removalCost : Int, copyCost : Int) : Int {

    if (n == 0) {
        return 0
    }
    if (n ==1) {
        return insertioncost
    }
    if(n %2 == 0) {
        return min(insertioncost + minWrite(n-1, insertioncost, removalCost, copyCost), copyCost + minWrite(n/2, insertioncost, removalCost, copyCost))
    } else {
        return min(insertioncost + minWrite(n-1, insertioncost, removalCost, copyCost),
            copyCost + removalCost + minWrite((n+1)/2, insertioncost, removalCost, copyCost))
    }
}

fun dpminwrite(n : Int, insertioncost : Int, removalCost : Int, copyCost : Int) : Int {
    if (n == 0) {
        return 0
    }
    if (n ==1) {
        return insertioncost
    }
    val temp = IntArray(n+1)
    temp[1] = insertioncost

    for (i in 2 .. n) {
        if (i%2 == 0) {
            temp[i] = min(insertioncost+temp[i-1], copyCost + temp[i/2])
        } else {
            temp[i] = min(insertioncost+ temp[i-1], copyCost + removalCost + temp[(i+1)/2])
        }
    }
    return temp[n]
}

fun main() {
    val n = 9
    val insertioncost = 1
    val removalCost = 2
    val copyCost = 1

    println(minWrite(n, insertioncost, removalCost, copyCost))
    println(dpminwrite(n, insertioncost, removalCost, copyCost))
}
