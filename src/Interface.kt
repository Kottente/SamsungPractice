import java.util.Scanner


fun gameStarter() {
    println("Welcome to my fantasy game!")
    println("Choose a class:")
    println("Wizard")
    println("Knight")
    println("Robot")
    var fst_answer = readlnOrNull()
    println("You`ve chosen your hero!")
    println("Write down his characteristics(health,power and personal attribute)")
    var input2 = Scanner(System.`in`)
    var health: Double = input2.nextDouble()
    var power: Int = input2.nextInt()
    var attr: Double = input2.nextDouble()
    var class_name: String
    if (attr < 50) {
        println("Sorry but attribute must be more than 50. It was automatically corrected.")
        attr = 50.0
    }
    when (fst_answer) {
        "Wizard" -> {
            if (health > 100) {
                println("Sorry but wizard can only have 100 hp or less.It was automatically corrected.")
                health = 100.0
            }
            if (power > 10) {
                println("Sorry but wizard can only have 10 power or less.It was automatically corrected.")
                power = 10
            }
            if (attr > 200) {
                println("Sorry but wizard can only have  200 mana or less.It was automatically corrected.")
                attr = 200.0
            }
            class_name = "Wizard"
        }

        "Knight" -> {
            if (health > 100) {
                println("Sorry but knight can only have 100 hp or less.It was automatically corrected.")
                health = 100.0
            }
            if (power > 20) {
                println("Sorry but knight can only have 20 power or less.It was automatically corrected.")
                power = 20
            }
            if (attr > 100) {
                println("Sorry but knight can only have 100 armor or less.It was automatically corrected.")
                attr = 100.0
            }
            class_name = "Knight"
        }

        else -> {
            if (health > 10) {
                println("Sorry but robot can only have 10 hp or less.It was automatically corrected.")
                health = 10.0
            }
            if (power > 15) {
                println("Sorry but robot can only have 15 power or less.It was automatically corrected.")
                power = 15
            }
            if (attr > 200) {
                println("Sorry but robot can only have 200 battery or less.It was automatically corrected.")
                attr = 200.0
            }
            class_name = "Robot"
        }
    }
    println("Congratulations!")
    println("You`ve made your character.")
    println("Do you need tutorial?(Yes/No)")
    val input3 = readlnOrNull()
    when (input3) {
        "Yes" -> {
            println("The rules are simple:")
            println("It is a turn-base combat game.")
            println("Your objective is to survive as long as you can by winning your opponents.")
            println("Here are some instructions:")
            println("You have 3 options:")
            println("You can attack,heal and cast a skill.")
            println("To use attack,heal or skill just type in the corresponding action.")
            println("After typing in skill you will need to choose one of them from a list by typing the its` number.")
            println("The game ends when your health drops to zero or further.")
            println("Every kill gives you 10 points.")
            println("After you die you will get an overall score.")
            println("You can end your game earlier if you are tired by typing zero on your next turn.")
            println("That's all.Let`s start the game!")
        }

        "No" -> {
            println("Let`s proceed to the game!")
        }

        else -> {
            println("Let`s say it`s a no and proceed to the game.")
        }
    }
    game(class_name, health, power, attr)
}