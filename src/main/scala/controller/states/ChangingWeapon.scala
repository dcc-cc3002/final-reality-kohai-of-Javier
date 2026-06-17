package controller.states

import characters.TCharacter
import controller.GameController
import weapons.Weapon

/** State class for changing the weapon of a character.
 *
 * @param currChar The character whose weapon is to be changed. */
class ChangingWeapon(currChar: TCharacter) extends AbstractGameState {
  private var weapon: Option[Weapon] = None
  def update(controller: GameController): Unit = {
    if(weapon.isDefined) {
      currChar.changeWeapon(weapon.get)
      controller.state = new ChoosingAction(currChar)
    }
  }
}
