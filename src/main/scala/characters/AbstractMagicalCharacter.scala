package characters

abstract class AbstractMagicalCharacter(name: String, healthPoints: Double, defense: Double, weight: Double, var manaPoints: Double) extends AbstractCharacter(name, healthPoints, defense, weight) with MagicalCharacter {

}
