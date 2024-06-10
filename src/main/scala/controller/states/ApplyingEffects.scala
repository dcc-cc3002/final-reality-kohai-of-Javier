package controller.states

import characters.TCharacter
import controller.GameController

/** State class for applying the effects (paralyzed, burned, poisoned) on the current playing character.
 * @param currChar The current character in turn.
 * */
class ApplyingEffects(currChar: TCharacter) extends AbstractGameState {
  def update(controller: GameController): Unit = {
    currChar.applyEffects()
    if(currChar.getHealthPoints == 0)
      controller.state = new CharacterElimination(currChar)
    else {
      controller.state = new ChoosingAction(currChar)
    }
  }
}
