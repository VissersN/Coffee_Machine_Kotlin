fun main() {
    // put your code here
    val boy1 = readln().toInt()
    val boy2 = readln().toInt()
    val boy3 = readln().toInt()
    println((boy1 <= boy2 && boy2 <= boy3) || (boy1 >= boy2 && boy2 >= boy3))
}