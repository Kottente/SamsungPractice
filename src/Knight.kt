import java.math.RoundingMode
import kotlin.math.abs
import kotlin.random.Random

class Knight(health: Double, power: Int, private var armor: Double) : Human(health, power) {
    override fun skill(typeOfSkill: String, other: Human) {
        when (typeOfSkill) {
            "1" -> {
                val aura = Random.nextDouble(1.0, armor / 20).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
                armor -= aura * 10
                power += aura.toInt()
                println("The knight used aura to enhance his weapon")
            }

            "2" -> {
                println("The knight used a defence stance")
                armor += 20
            }
        }
    }

    override fun heal() {
        println("The knight is using aura to heal up")
        health += 12 * Random.nextDouble(1.0, 2.0).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
    }

    override fun attack_power(): Double {
        if (armor > 50) {
            return power * 0.5
        } else if (armor > 20) {
            return power * 0.8
        } else if (armor > 10) {
            return power * 0.9
        }
        println("The knight used attack.")
        return power.toDouble()
    }

    override fun toString(): String {
        return "Knight" + super.toString() + " Current endurance of armor: $armor"
    }

    override fun defence(damage: Double) {
        if (damage > health && damage < health + armor) {
            armor -= abs(health - damage).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
            health = 1.0

        } else {
            if (damage * 0.5 <= armor) {
                val dmg = damage * Random.nextDouble(0.5, 1.0)
                armor -= (damage - dmg).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
                health -= dmg.toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
            } else {
                health -= damage.toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
            }
        }
        armor += (damage * 0.01 * Random.nextDouble(0.01, 1.0)).toBigDecimal().setScale(0, RoundingMode.UP).toDouble()
    }
}
