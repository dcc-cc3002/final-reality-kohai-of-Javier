package controller.states.enemystates

import characters.TCharacter
import characters.enemies.TEnemy
import controller.GameController
import controller.states.{AbstractGameState, CharacterElimination, ChoosingAction, TurnProgramming}

/** State class for applying the effects (paralyzed, burned, poisoned) on the current playing character.
 * @param currChar The current enemy in turn.
 * */
class ApplyingEffects(private val currChar: TEnemy) extends AbstractGameState {

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    currChar.applyEffects()
    if(currChar.getHealthPoints == 0)
      controller.state = new CharacterElimination(currChar)
    else if(currChar.getAction == "skip") {
      controller.turnProgrammer.restartActionBar(currChar)
      controller.state = new TurnProgramming
    } else {
      controller.state = new EnemyChoosingTarget(currChar)
    }
  }

  /** Returns true because this state is ApplyingEffects. */
  override def isApplyingEffects: Boolean = true
}
