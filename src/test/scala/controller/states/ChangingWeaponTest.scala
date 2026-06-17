package controller.states

import characters.Warrior
import weapons.{Axe, Weapon}

class ChangingWeaponTest extends AbstractGameStateTest {

  test("update test with no weapon") {
    controller.state = new ChangingWeapon(characters.head)
    controller.update

    assert(controller.state.isChangingWeapon)
  }

  test("update test with new weapon") {
    val newWeapon: Weapon = new Axe("Axe", 50, 50, new Warrior("Auxiliary warrior", 50, 50, 50))
    controller.state = new ChangingWeapon(characters.head, Some(newWeapon))
    controller.update

    assertEquals(characters.head, newWeapon.getOwner)
    assert(controller.state.isChoosingAction)
  }
}
