import kotlin.random.Random

fun createWizardBot(class_name: String, health: Double, power: Int, attr: Double): Wizard {
    var bot: Wizard
    if (class_name == "Robot") {
        bot = Wizard(health + 100, Random.nextInt(power - 2, power), Random.nextDouble(50.0, 200.0))
    } else {
        bot = Wizard(health + 10, Random.nextInt(power - 2, power), Random.nextDouble(50.0, 200.0))
    }
    return bot
}

fun createKnightBot(class_name: String, health: Double, power: Int, attr: Double): Knight {
    var bot: Knight
    if (class_name == "Robot") {
        bot = Knight(health + 120, Random.nextInt(1, 5), Random.nextDouble(attr - 50, attr + 50))
    } else {
        bot = Knight(health + 20, Random.nextInt(1, 5), Random.nextDouble(attr - 50, attr + 50))
    }
    return bot
}

fun createRobotBot(class_name: String, health: Double, power: Int, attr: Double): Robot {
    var bot: Robot
    if (class_name == "Robot") {
        bot = Robot(health, Random.nextInt(1, 5), Random.nextDouble(attr - 50, attr + 50))
    } else {
        bot = Robot(10.0, Random.nextInt(1, 5), Random.nextDouble(attr - 50, attr + 50))
    }
    return bot
}

var avatar: Human = Wizard(10.0, 10, 10.0)
var bot1 = Wizard(10.0, 10, 10.0)
var bot2 = Knight(10.0, 10, 10.0)
var bot3 = Robot(10.0, 10, 10.0)
var skip = 0
var skipEnemy = 0
fun game(class_name: String, health: Double, power: Int, attr: Double) {
    if (class_name == "Wizard") {
        avatar = Wizard(health, power, attr)
    } else if (class_name == "Knight") {
        avatar = Knight(health, power, attr)
    } else {
        avatar = Robot(health, power, attr)
    }
    var score = 0
    var game_ender = 1
    while (true) {
        when (Random.nextInt(1, 4)) {
            1 -> {
                bot1 = createWizardBot(class_name, health, power, attr)
                println("Enemy approaches you!")
                println("Their characteristics:")
                println(bot1)
                while (true) {
                    if (skipEnemy == 1) {
                        skipEnemy = 0
                    } else {
                        println("Your turn")
                        if (turnOfPlayer(class_name, avatar, bot1)) {
                            game_ender = 0
                            break
                        }
                    }
                    if (skip == 1) {
                        skip = 0
                    } else {
                        println("It`s turn of your enemy now")
                        turn_wizard(bot1)
                        println("Enemies characteristics: $bot1")
                        println("Your characteristics: $avatar")
                    }
                    if (bot1.health <= 0) {
                        score += 10
                        break
                    }

                }
            }

            2 -> {
                bot2 = createKnightBot(class_name, health, power, attr)
                println("Enemy approaches you!")
                println("Their characteristics:")
                println(bot2)
                while (true) {
                    if (skipEnemy == 1) {
                        skipEnemy = 0
                    } else {
                        println("Your turn")
                        if (turnOfPlayer(class_name, avatar, bot2)) {
                            game_ender = 0
                            break
                        }
                    }
                    if (skip == 1) {
                        skip = 0
                    } else {
                        println("It`s turn of your enemy now")
                        turn_knight(bot2)
                        println("Enemies characteristics: $bot2")
                        println("Your characteristics: $avatar")
                    }
                    if (bot2.health <= 0) {
                        score += 10
                        break
                    }

                }
            }

            3 -> {
                bot3 = createRobotBot(class_name, health, power, attr)
                println("Enemy approaches you!")
                println("Their characteristics:")
                println(bot3)
                while (true) {
                    if (skipEnemy == 1) {
                        skipEnemy = 0
                    } else {
                        println("Your turn")
                        if (turnOfPlayer(class_name, avatar, bot3)) {
                            game_ender = 0
                            break
                        }
                    }
                    if (skip == 1) {
                        skip = 0
                    } else {
                        println("It`s turn of your enemy now")
                        turn_robot(bot3)
                        println("Enemies characteristics: $bot3")
                        println("Your characteristics: $avatar")
                    }
                    if (bot3.health <= 0) {
                        score += 10
                        break
                    }

                }
            }

            4 -> {
                bot3 = createRobotBot(class_name, health, power, attr)
                println("Enemy approaches you!")
                println("Their characteristics:")
                println(bot3)
                while (true) {
                    if (skipEnemy == 1) {
                        skipEnemy = 0
                    } else {
                        println("Your turn")
                        if (turnOfPlayer(class_name, avatar, bot3)) {
                            game_ender = 0
                            break
                        }
                    }
                    if (skip == 1) {
                        skip = 0
                    } else {
                        println("It`s turn of your enemy now")
                        turn_robot(bot3)
                        println("Enemies characteristics: $bot3")
                        println("Your characteristics: $avatar")
                    }
                    if (bot3.health <= 0) {
                        score += 10
                        break
                    }

                }
            }
        }


        if (game_ender == 0) {
            break
        } else {
            println("Your current score: $score")
        }
    }
    println("Your game has ended. Here are the results:")
    println(score)
}

fun turnOfPlayer(class_name: String, avatar: Human, bot: Human): Boolean {
    println("Choose what do:")
    println("1.attack")
    println("2.heal")
    println("3.Use a skill(to use it type in 'skill')")
    var input = readln()
    var game_ender = false
    if (input == "0") {
        game_ender = true
        return game_ender
    } else if (input == "attack") {
        avatar.attack(bot)
        if (bot.health <= 0) {
            return game_ender
        }
    } else if (input == "heal") {
        avatar.heal()
    } else if (input == "skill") {
        println("Choose one of the following skills by typing in its` number")
        when (class_name) {
            "Wizard" -> {
                println("1.The ring of fire(Ignores defence).Need 20 or more mana")
                println("2.The fire sphere(Damage stacks).Need 30 mana")
                println("3.Ice castle(Freeze your enemy for a turn and do a little of damage).Need 50 mana")
                println("4.Ice hell(Lowers damage of your enemy).Need 30 mana")
                input = readln()
                when (input) {
                    "1" -> {
                        avatar.skill("1", bot)
                    }

                    "2" -> {
                        avatar.skill("2", bot)
                    }

                    "3" -> {
                        avatar.skill("3", bot)
                        skip = 1
                    }

                    "4" -> {
                        avatar.skill("4", bot)
                    }
                }
            }

            "Knight" -> {
                println("1.Imbue weapon with aura(Higher damage on next turns in return of armor)")
                println("2.Defence stance(Higher durability)")
                input = readln()
                when (input) {
                    "1" -> {
                        avatar.skill("1", bot)
                    }

                    "2" -> {
                        avatar.skill("2", bot)
                        avatar.health += Random.nextInt(20, 40)
                    }
                }
            }

            "Robot" -> {
                println("1.Laser beam(A powerful skill to finish your enemies with)")
                println("2.Raise limits of power(Higher damage on next turns)")
                input = readln()
                when (input) {
                    "1" -> {
                        avatar.skill("1", bot)
                    }

                    "2" -> {
                        avatar.skill("2", bot)
                    }
                }
            }
        }
    }
    println("Your characteristics are:")
    println(avatar)
    println("Enemy`s characteristics are:")
    println(bot)
    return game_ender
}

fun turn_wizard(bot: Wizard) {
    var choice = Random.nextInt(1, 4)
    if (bot.mana < 20 && choice == 3) {
        choice = 1
    } else if (choice == 4) {
        choice = 3
    }
    when (choice) {
        1 -> {
            bot.attack(avatar)
        }

        2 -> {
            bot.heal()
        }

        3 -> {
            if (bot.mana > 50) {
                choice = Random.nextInt(1, 3)
            } else if (bot.mana > 40) {
                choice = Random.nextInt(1, 2)
            } else {
                choice = 1
            }
            when (choice) {
                1 -> {
                    bot.skill("1", avatar)
                }

                2 -> {
                    bot.skill("3", avatar)
                    skipEnemy = 1
                }

                3 -> {
                    bot.skill("4", avatar)
                }
            }
        }
    }


}

fun turn_knight(bot: Knight) {
    var choice = Random.nextInt(1, 3)
    when (choice) {
        1 -> {
            bot.attack(avatar)
        }

        2 -> {
            bot.heal()
        }

        3 -> {
            choice = Random.nextInt(1, 2)
            when (choice) {
                1 -> {
                    bot.skill("1", avatar)
                }

                2 -> {
                    bot.skill("2", avatar)
                    bot.health += Random.nextInt(1, 20)
                }
            }
        }
    }

}

fun turn_robot(bot: Robot) {
    var choice = Random.nextInt(1, 3)
    if (choice == 3 && bot.battery < 30) {
        choice = 1
    }
    when (choice) {
        1 -> {
            bot.attack(avatar)
        }

        2 -> {
            bot.heal()
        }

        3 -> {
            if (bot.battery < 60) {
                bot.skill("1", avatar)
            } else {
                choice = Random.nextInt(1, 2)
                when (choice) {
                    1 -> {
                        bot.skill("1", avatar)
                    }

                    2 -> {
                        bot.skill("2", avatar)
                    }
                }
            }
        }
    }

}