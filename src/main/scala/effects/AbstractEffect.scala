package effects

import characters.enemies.TEnemy
import exceptions.Require

/** Abstract class for the effect of throwing a spell on the target.
 * @param turns The number of turns this effect to be applied.
 * @param damage The damage made by this effect to the target.
 * */
abstract class AbstractEffect(protected var turns: Int = 0, protected val damage: Int = 0) extends TEffect {

  Require.Stat(turns, "Turns") atLeast 0

  /** Getter for the number of turns remaining. */
  def getTurns: Int = turns

  /** Apply the effect on the given character. */
  def apply(char: TEnemy): Unit = {
    if(turns > 0) {
      turns -= 1
      char.receiveMagicDamage(damage)
    }
  }
}
