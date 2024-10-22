import java.math.RoundingMode
import kotlin.random.Random

class Robot(health: Double, power: Int, var battery: Double) : Human(health, power) {
    override fun skill(typeOfSkill: String, other: Human) {
        when (typeOfSkill) {
            "1" -> {
                if (battery > 60) {
                    battery -= 60
                    val damage = Random.nextDouble(1.5, 2.0) * 60
                    other.defence(damage.toBigDecimal().setScale(0, RoundingMode.UP).toDouble())
                    println("The robot used laser beam")
                } else {
                    println("Don`t have enough battery")
                    battery += 10
                }
            }

            "2" -> {
                if (battery > 30) {
                    battery -= 30
                    power += Random.nextInt(1, 2) * 5
                    println("The robot raised its` power limits")
                }
                else{
                    println("Don`t have enough battery")
                    battery += 10
                }
            }
        }
    }

    override fun heal() {
        println("Robot went to eat in the midst of the battle")
        battery += 40
    }

    override fun attack_power(): Double {
        if (battery > 10) {
            battery -= 10
            println("Robot used left hook")
            return power * Random.nextDouble(0.5, 2.0)
        } else {
            println("Robot have used it`s full power!")
            battery += 10
            return 1.0
        }
    }

    override fun defence(damage: Double) {
        if (battery > damage) {
            val bef = battery
            battery -= damage.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
            println("Robot is looking for a way to fix it`s battery...")
            if (bef > damage * 2 && Random.nextInt(0, 20) > 18) {
                println("It was lucky enough to do so!")
                battery += (damage * 2).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
            } else {
                println("It`s has repaired it somehow...")
                battery += (damage * Random.nextDouble(0.01, 0.1)).toBigDecimal().setScale(0, RoundingMode.UP)
                    .toDouble()
            }
        }
    }

    override fun toString(): String {
        return "Robot" + super.toString() + " Robots` battery is: $battery "
    }
}