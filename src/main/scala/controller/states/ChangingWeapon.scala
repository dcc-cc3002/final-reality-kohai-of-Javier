package controller.states

import characters.TCharacter
import controller.GameController
import weapons.Weapon

/** State class for changing the weapon of a character.
 *
 * @param currChar The character whose weapon is to be changed. */
class ChangingWeapon(currChar: TCharacter) extends AbstractGameState {
  private var weapon: Option[Weapon] = None

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(weapon.isDefined) {
      currChar.changeWeapon(weapon.get)
      controller.state = new ChoosingAction(currChar)
    }
  }

  /** Returns true because this state is ChangingWeapon. */
  override def isChangingWeapon(): Boolean = true
}
