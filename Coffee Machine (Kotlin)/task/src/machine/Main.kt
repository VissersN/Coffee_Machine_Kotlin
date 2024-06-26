package machine
//var amountWaterPresent = 400
//var amountCoffeePresent = 120
//var amountMilkPresent = 540
//var amountCupsPresent = 9
//var amountMoneyPresent = 550

enum class States(val description: String) {
    CHOOSE("Choosing Action"),
    BUYING ("Buying product"),
    FILLINGWATER ("Filling Water"),
    FILLINGCOFFEE ("Filling Coffee"),
    FILLINGMILK ("Filling Milk"),
    FILLINGCUPS ("Filling Cups"),
    EXIT ("Exiting")
}

class CoffeeMachine() {
    var amountWaterPresent = 400
    var amountCoffeePresent = 120
    var amountMilkPresent = 540
    var amountCupsPresent = 9
    var amountMoneyPresent = 550
    var state: States = States.CHOOSE
    fun handlingMachine(input: String) {
            when (state) {
                States.CHOOSE -> {
                    when (input) {
                        "buy" -> state = States.BUYING
                        "fill" -> state = States.FILLINGWATER
                        "take" -> {
                            println("I gave you $amountMoneyPresent")
                            amountMoneyPresent = 0
                            state = States.CHOOSE
                        }
                        "remaining" -> {
                            printAmounts(amountWaterPresent, amountMilkPresent, amountCoffeePresent, amountCupsPresent, amountMoneyPresent)
                            state = States.CHOOSE
                        }
                        "exit" -> state = States.EXIT
                    }
                }
                States.BUYING -> {
                    when (input) {
                    "1" -> {
                        if (amountWaterPresent - 250 >= 0) {
                            if (amountCoffeePresent - 16 >= 0) {
                                if (amountCupsPresent - 1 >= 0) {
                                    println("I have enough resources, making you a coffee!")
                                    amountWaterPresent -= 250
                                    amountCoffeePresent -= 16
                                    amountCupsPresent -= 1
                                    amountMoneyPresent += 4
                                } else {
                                    println("Sorry, not enough cups!")
                                }
                            } else {
                                println("Sorry, not enough coffee!")
                            }
                        } else {
                            println("Sorry, not enough water!")
                        }
                        state = States.CHOOSE
                    }
                    "2" -> {
                        if (amountWaterPresent - 350 >= 0) {
                            if (amountCoffeePresent - 20 >= 0) {
                                if (amountCupsPresent - 1 >= 0) {
                                    if (amountMilkPresent - 75 >=0) {
                                        println("I have enough resources, making you a coffee!")
                                        amountWaterPresent -= 350
                                        amountCoffeePresent -= 20
                                        amountCupsPresent -= 1
                                        amountMoneyPresent += 7
                                        amountMilkPresent -= 75
                                    } else {
                                        println("Sorry, not enough milk!")
                                    }
                                } else {
                                    println("Sorry, not enough cups!")
                                }
                            } else {
                                println("Sorry, not enough coffee!")
                            }
                        } else {
                            println("Sorry, not enough water!")
                        }
                        state = States.CHOOSE
                    }
                    "3" -> {
                        if (amountWaterPresent - 200 >= 0) {
                            if (amountCoffeePresent - 12 >= 0) {
                                if (amountCupsPresent - 1 >= 0) {
                                    if (amountMilkPresent - 100 >=0) {
                                        println("I have enough resources, making you a coffee!")
                                        amountWaterPresent -= 200
                                        amountCoffeePresent -= 12
                                        amountMilkPresent -= 100
                                        amountCupsPresent -= 1
                                        amountMoneyPresent +=6
                                    } else {
                                        println("Sorry, not enough milk!")
                                    }
                                } else {
                                    println("Sorry, not enough cups!")
                                }
                            } else {
                                println("Sorry, not enough coffee!")
                            }
                        } else {
                            println("Sorry, not enough water!")
                        }
                        state = States.CHOOSE
                    }
                    "back" -> {
                        state = States.CHOOSE
                    }
                }
                  //  printAmounts(amountWaterPresent, amountMilkPresent, amountCoffeePresent, amountCupsPresent, amountMoneyPresent)
                }
                States.FILLINGWATER -> {
                    amountWaterPresent += input.toInt()
                    state = States.FILLINGMILK
                }
                States.FILLINGMILK -> {
                    amountMilkPresent += input.toInt()
                    state = States.FILLINGCOFFEE
                }
                States.FILLINGCOFFEE -> {
                    amountCoffeePresent += input.toInt()
                    state = States.FILLINGCUPS
                }
                States.FILLINGCUPS -> {
                    amountCupsPresent += input.toInt()
                    state = States.CHOOSE
                }
                States.EXIT -> {
                    state = States.CHOOSE
                }
            }
        }
    }

fun printAmounts(water: Int, milk: Int, coffee:Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffee g of coffee beans")
    println("$cups disposable cups")
    println("$"+"$money of money")
}
fun main() {
    val newCoffee = CoffeeMachine()
    while (true) {
        when (newCoffee.state) {
            States.CHOOSE -> {
                println("Write action (buy, fill, take, remaining, exit):")
            }
            States.BUYING -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back( - to main menu:")
            }
            States.FILLINGWATER -> {
                println("Write how many ml of water you want to add:")
            }
            States.FILLINGCOFFEE -> {
                println("Write how many grams of coffee beans you want to add:")
            }
            States.FILLINGMILK -> {
                println("Write how many ml of milk you want to add:")
            }
            States.FILLINGCUPS -> {
                println("Write how many disposable cups you want to add:")
            }
            States.EXIT -> {
                return
            }
            else -> return
        }
        val input = readln()
        newCoffee.handlingMachine(input)
    }
}

