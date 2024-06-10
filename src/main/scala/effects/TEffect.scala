package effects

import characters.enemies.TEnemy

trait TEffect {

  /** Getter for the number of turns remaining. */
  def getTurns: Int

  /** Apply the effect on the given character. */
  def apply(char: TEnemy): Unit
}
