package controller.states

import characters.magicalcharacters.MagicalCharacter
import controller.GameController
import weapons.Weapon

/** State class for changing the weapon of a character.
 *
 * @param currChar The character whose weapon is to be changed.
 * @param we Option for testing purposes
 * */
class MagicalChangingWeapon(currChar: MagicalCharacter, we: Option[Weapon] = None) extends AbstractGameState {
  private var weapon: Option[Weapon] = we

  /** Handles the input from the user. */
  override def handleInput(controller: GameController): Unit = {
    //List available weapons to the user
    //Make him/her select one of them
    controller.showWeapons
    val userInput: Int = controller.getNumericalInput
    val weaponsArray: Array[Weapon] = controller.getWeapons
    if(userInput >= 0 && userInput < weaponsArray.size)
      weapon = Some(weaponsArray(userInput))

  }
  /** Changes the state of the game controller.*/
  def update(controller: GameController): Unit = {
    if(weapon.isDefined) {
      currChar.changeWeapon(weapon.get)
      controller.state = new ChoosingAction(currChar)
    }
  }

  /** Returns true because this state is ChangingWeapon. */
  override def isMagicalChangingWeapon: Boolean = true
}
