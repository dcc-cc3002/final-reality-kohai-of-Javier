package controller.states.magicalstates

import characters.{TCharacter, WCharacter}
import characters.enemies.TEnemy
import characters.magicalcharacters.MagicalCharacter
import controller.GameController
import controller.states.AbstractGameState
import spells.Spell

/** State class for choosing a target
 *
 * @param attackingChar The character currently attacking or throwing a spell.
 * @param spell Option with the spell to be thrown.
 * @param ta Option for testing purposes.
 * */
class MagicalChoosingTarget(private val attackingChar: MagicalCharacter, private val spell: Option[Spell] = None, private val ta: Option[TCharacter] = None) extends AbstractGameState {
  private var target: Option[TCharacter] = ta

  /** Handles the input from the user */
  override def handleInput(controller: GameController): Unit = {
    controller.showCharacters()
    val userInput: Int = controller.getNumericalInput
    val charArray: Array[TCharacter] = controller.getCharacters
    if(userInput >= 0 && userInput < charArray.length)
      target = Some(charArray(userInput))
  }

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(target.isDefined)
      controller.state = new MagicalDoingAction(attackingChar, target.get, spell)
  }

  /** Returns true because this state is ChoosingTarget. */
  override def isMagicalChoosingTarget: Boolean = true
}
