fun findNthUglyNumber(n : Int) {
    val uglyNumber = IntArray(1000)
    uglyNumber[0] = 1
    var mul2 = 0
    var mul3 = 0
    var mul5 = 0
    var min2 = 2
    var min3 = 3
    var min5 = 5
    for (i in 1 .. n-1) {
        var nextugly = min(min(min2, min3), min5)
        uglyNumber[i] = nextugly
        if (nextugly == min2) {
            mul2++
            min2 =uglyNumber[mul2] * 2
        }
        if (nextugly == min3) {
            mul3++
            min3 = uglyNumber[mul3] * 3
        }
        if (nextugly == min5) {
            mul5++
            min5 = uglyNumber[mul5] * 5
        }
    }
    print(uglyNumber[n-1])
}

fun main() {
findNthUglyNumber(150) //5832
}
