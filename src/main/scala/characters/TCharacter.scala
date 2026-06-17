package characters

import effects.TEffect
import spells.Spell
import weapons.Weapon

/** Generic trait for a Character.*/
trait TCharacter {
    /** Returns the value of the action bar to be attained for the character to play.*/
    def fullActionBar: Int

    /** Attack another character.*/
    def attack(other: TCharacter): Unit


    /** Function that is called when the character is attacked by another.*/
    def receiveDamage(attackPoints: Int): Unit

    /** Receive damage from a playable character.*/
    def receiveDamagePlayer(attackPoints: Int): Unit

    /** Receive damage from an enemy.*/
    def receiveDamageEnemy(attackPoints: Int): Unit

    /** Getter for the name of the character.*/
    def getName: String

    /** Getter for the number of defense points of the character.*/
    def getDefense: Int

    /** Getter for the weight of the character.*/
    def getWeight: Int

    /** Getter for the number of health points of the character.*/
    def getHealthPoints: Int

    /** Getter for the maximum number of health points of the character.*/
    def getMaxHealthPoints: Int

    /** Receive damage from a spell.*/
    def receiveMagicDamage(magicDamage: Int): Unit

    /** Receive healing from a spell.*/
    def receiveMagicHealing(magicHealing: Int): Unit

    /** Receives a negative spell.*/
    def negativeSpell(): Unit

    /** Receives a positive spell.*/
    def positiveSpell(): Unit

    /** Changes weapon, for the characters who can carry a weapon.
     *  If they can't, then this function does nothing. */
    def changeWeapon(wp: Weapon): Unit

    /** Cast a spell, for the magical characters who can,
     * Else this function does nothing.*/
    def castSpell(target: TCharacter, spell: Spell): Unit

    /** Add an effect of a spell to be applied on the character. */
    def addEffect(e: TEffect): Unit

    /** Apply effects of spells on the character.*/
    def applyEffects(): Unit
}
