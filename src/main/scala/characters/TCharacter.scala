package characters

/** Generic trait for a Character.*/
trait TCharacter {
    /** Returns the value of the action bar to be attained for the character to play.*/
    def fullActionBar(): Int

    /** Attack another character.*/
    def attack(other: TCharacter): Unit


    /** Function that is called when the character is attacked by another.*/
    def receiveDamage(attackPoints: Int): Unit

    /** Receive damage from a playable character.*/
    def receiveDamagePlayer(attackPoints: Int): Unit

    /** Receive damage from an enemy.*/
    def receiveDamageEnemy(attackPoints: Int): Unit


    /** Getter for the name of the character.*/
    def getName(): String

    /** Getter for the number of defense points of the character.*/
    def getDefense(): Int

    /** Getter for the weight of the character.*/
    def getWeight(): Int

    /** Getter for the number of health points of the character.*/
    def getHealthPoints(): Int


    /** Receives a negative spell.*/
    def negativeSpell: Unit

    /** Receives a positive spell.*/
    def positiveSpell: Unit
}
