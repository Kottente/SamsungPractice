import java.math.RoundingMode
import kotlin.random.Random

abstract class Human(var health: Double, var power: Int) {
    abstract fun defence(damage: Double)
    abstract fun heal()
    abstract fun skill(typeOfSkill: String, other: Human)
    abstract fun attack_power(): Double
    fun attack(other: Human) {
        if (other.javaClass.name == "Knight") {
            val damage: Double
            damage = attack_power()
            other.defence(damage)
        } else if (other.javaClass.name == "Robot") {
            other.defence(attack_power())
        } else {
            other.defence(attack_power())
        }
    }

    override fun toString(): String {
        return " Current health: $health and power: $power"
    }

}