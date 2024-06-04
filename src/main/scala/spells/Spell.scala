package spells

import characters._
import characters.magicalcharacters._

/** Trait for a spell.
 * The idea is to make easy to add a new spell.
*/
trait Spell {
    /** Executes the spell.
     * @param user The Magical Character who throws the spell.
     * @param target The target of the spell.
     */
    def execute(user: MagicalCharacter, target: TCharacter): Unit
}
