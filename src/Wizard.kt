import java.math.RoundingMode
import kotlin.random.Random

class Wizard(health: Double, power: Int, var mana: Double) : Human(health, power) {
    companion object {
        var stackOfSphere = 0
    }

    override fun skill(typeOfSkill: String, other: Human) {
        when (typeOfSkill) {
            "1" -> {
                if (other.javaClass.name != "Robot" && other.javaClass.name != "Wizard") {
                    val a = Random.nextDouble(10.0, mana / 2)
                    mana -= a
                    other.health -= (a + power)
                } else {
                    val a = Random.nextDouble(10.0, mana / 2)
                    mana -= a
                    other.defence(a + 10)
                }
                println("The wizard used a ring of fire")
            }

            "2" -> {
                println("Amount of fire spheres: $stackOfSphere")
                stackOfSphere += 1
                if (stackOfSphere > 8) {
                    stackOfSphere = 8
                }
                mana -= 30
                val damage = (power * stackOfSphere) * Random.nextDouble(0.1, 1.0)
                other.defence(damage)
                println("The wizard used a fire sphere")
            }

            "3" -> {
                mana -= 50
                other.defence(damage = power.toDouble())
                println("The wizard used an ice castle")
            }

            "4" -> {
                mana -= 30
                val reducer = Random.nextInt(0, 5)
                if (reducer == 0) {
                    println("Couldn`t do anything")
                }
                other.power -= reducer
                println("The wizard used an ice hell")
            }
        }
    }

    override fun heal() {
        if (mana > 40) {
            mana -= 40
            health += 10 * Random.nextDouble(1.0, 5.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        }
        else{
            mana += 30
        }
        println("The wizard used healing prayers")
    }

    override fun defence(damage: Double) {
        health -= damage
        if (health > 0) {
            mana += (Random.nextInt(1, 10) * Random.nextDouble(1.0, 5.0)).toBigDecimal()
                .setScale(0, RoundingMode.UP).toDouble()
        }
    }

    override fun attack_power(): Double {
        if (mana > 20) {
            mana -= 20
            println("A Fireball Has been casted")
            if (Random.nextInt(1, 11) >= 9) {
                return (power * 2 * Random.nextDouble(1.0, 2.0)).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
            } else {
                return (power).toBigDecimal().setScale(0, RoundingMode.UP)
                    .toDouble()
            }
        } else if (mana in 10.0..20.0) {
            mana -= (mana - 1)
            println("Wizard`v fired a big piece of ice")
            return (power * mana * Random.nextDouble(0.01, 5.0)).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()

        } else {
            println("Wizards` mana is low wait for a turn")
            mana += 5 * Random.nextDouble(0.1, 5.0)
            return 0.0
        }

    }

    override fun toString(): String {
        return "Wizard" + super.toString() + " mana is: $mana"
    }
}