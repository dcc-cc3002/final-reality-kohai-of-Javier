package characters
import exceptions.{Require, InvalidStatException, NoMagicWeaponException, InsufficientManaException}

/** Abstract class for a Magical Character.
 * A magical character also has mana points
 * There are two concrete classes for magical characters: BlackMage and WhiteMage
 * @see AbstractCharacter
 */
abstract class AbstractMagicalCharacter(name: String, healthPoints: Int, defense: Int, weight: Int, private var manaPoints: Int) extends AbstractWCharacter(name, healthPoints, defense, weight) with MagicalCharacter {

    Require.Stat(manaPoints, "manaPoints") atLeast 0

    /** Return the number of mana points of the character.*/
    def getManaPoints(): Int = manaPoints


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
