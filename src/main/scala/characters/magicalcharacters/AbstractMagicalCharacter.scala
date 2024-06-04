package characters.magicalcharacters

import characters._
import weapons.{Weapon}
import weapons.magicweapons.MagicWeapon
import exceptions.{Require, InvalidStatException, NoMagicWeaponException, InsufficientManaException}

/** Abstract class for a Magical Character.
 * A magical character also has mana points
 * There are two concrete classes for magical characters: BlackMage and WhiteMage
 * @see AbstractCharacter
 */
abstract class AbstractMagicalCharacter(name: String, healthPoints: Int, defense: Int, weight: Int, private var manaPoints: Int) extends AbstractWCharacter(name, healthPoints, defense, weight) with MagicalCharacter {

    Require.Stat(manaPoints, "manaPoints") atLeast 0

    protected var magicAttack: Int = 0
    protected var magicWeapon: Option[MagicWeapon] = None

    /** Returns the number of mana points of the character.*/
    def getManaPoints(): Int = manaPoints

    /** Returns an Option with the current magic weapon the character carries.*/
    def getMagicWeapon: Option[MagicWeapon] = magicWeapon

    /** Setter for the character's magical weapon.
     * It does nothing and the method is overriden for Magical characters.*/
    override def setMagicWeapon(newWeapon: MagicWeapon): Unit = magicWeapon = Some(newWeapon)

    /** Unequip the current weapon.
        If the character has no weapon, then this function has no effect.
    */
    override def unsetWeapon: Unit = {
        weapon = None
        magicWeapon = None
    }

    /** Apply a spell.
     * It checks whether there is enough mana and a magic weapon is equiped.
     * @param manaCost The number of manaPoints required to apply the spell.
     */
    protected def applySpell(manaCost: Int): Unit = {
        if(manaCost > manaPoints) throw new InsufficientManaException(manaCost, manaPoints)
        if(weapon.isDefined == false) throw new NoMagicWeaponException
        if(weapon.get.isMagical == false) throw new NoMagicWeaponException

        manaPoints -= manaCost
    }

}
