package controller.states

import characters.{TCharacter, WCharacter}
import characters.enemies.TEnemy
import controller.GameController
import spells.Spell

/** State class for choosing a target
 *
 * @param attackingChar The character currently attacking or throwing a spell.
 * @param ta Option for testing purposes.
 * */
class ChoosingTarget(attackingChar: TCharacter, ta: Option[TCharacter] = None) extends AbstractGameState {
  private var target: Option[TCharacter] = ta

  /** Handles the input from the user */
  override def handleInput(controller: GameController): Unit = {
      controller.showEnemies()
      val userInput: Int = controller.getNumericalInput
      val enemiesArray: Array[TEnemy] = controller.getEnemies
      if (userInput >= 0 && userInput < enemiesArray.length)
        target = Some(enemiesArray(userInput))
  }

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(target.isDefined)
      controller.state = new DoingAction(attackingChar, target.get)
  }

  /** Returns true because this state is ChoosingTarget. */
  override def isChoosingTarget(): Boolean = true
}
