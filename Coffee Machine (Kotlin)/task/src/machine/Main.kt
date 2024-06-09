package machine

fun main() {
    val waterUse = 200
    val milkUse = 50
    val coffeeUse = 15
    println("Write how many cups of coffee you will need:")
    val numberCups = readLine()!!.toInt()
    val usedWater = numberCups * waterUse
    val usedMilk = numberCups * milkUse
    val usedCoffee = numberCups * coffeeUse
    println("For $numberCups cups of coffee you will need:")
    println("$usedWater ml of water")
    println("$usedMilk ml of milk")
    println("$usedCoffee g of coffee beans")
}
