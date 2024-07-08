package controller.states.magicalstates

import characters.magicalcharacters.MagicalCharacter
import controller.GameController
import controller.states.{AbstractGameState, MagicalChangingWeapon}
import controller.states.magicalstates.ChoosingSpell

/** State class when a magical character must choose an action (attack, spell or changing weapon)
 * @param currChar The current character in play.
 * @param ac Option for testing purposes
 * */
class MagicalChoosingAction(currChar: MagicalCharacter, ac: Option[String] = None) extends AbstractGameState {
  private var action: Option[String] = ac

  /** Handles the input from the user. */
  override def handleInput(controller: GameController): Unit = {
    //Show possible actions
    controller.showMagicalActions()
    //Make the user select an action
    val userInput: Int = controller.getNumericalInput
    if(userInput == 0) action = Some("attack")
    else if(userInput == 1) action = Some("spell")
    else if(userInput == 2) action = Some("weapon")
  }
  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(action.isDefined) {
      if(action.get == "attack")
        controller.state = new MagicalChoosingTarget(currChar)
      else if(action.get == "spell")
        controller.state = new ChoosingSpell(currChar)
      else if(action.get == "weapon")
        controller.state = new MagicalChangingWeapon(currChar)
    }
  }

  /** Returns true because this state is ChoosingAction. */
  override def isMagicalChoosingAction: Boolean = true
}
