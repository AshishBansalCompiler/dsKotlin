package tictactoe

import kotlin.math.max

/*Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
Explanation:
The longest common substring is “abcdez” and is of length 6.

*/

fun longestCommonSubString(str1 :String, str2 : String, m : Int, n : Int, count : Int) : Int{

    if (m < 0 || n< 0) {
        return 0
    }
    if (str1[m].equals(str2[n])) {
        return  longestCommonSubString(str1, str2, m-1, n-1, count+1)
    } else {
        return max(count,max(longestCommonSubString(str1,str2, m-1, n, 0), longestCommonSubString(str1, str2, m, n-1, 0)))
    }
}

fun dpLongestCommonSubString(str1 : String, str2 : String) : Int {

    val temp = Array(str1.length+1){IntArray(str2.length+1)}
    var result = 0
    for (i in 0 .. str1.length) {
        for (j in 0 .. str2.length) {
            if (i == 0 || j == 0) {
                    temp[i][j] = 0
            }
            else if (str1[i-1] == str2[j-1]) {
                temp[i][j] = 1 + temp[i-1][j-1]
                result =  max(result, temp[i][j])
            } else {
                temp[i][j] = 0
            }
        }
    }
    return result
}

fun main() {
    //val str1 = "GeeksforGeeks"
    //val str2 = "GeeksQuiz"
    val str1 = "zxabcdezy"
    val str2 = "yzabcdezx"
    println(longestCommonSubString(str1, str2, str1.length-1, str2.length-1, 0))
    println(dpLongestCommonSubString(str1, str2))
}
