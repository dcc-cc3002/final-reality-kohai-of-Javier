package controller.states

class ChangingWeaponTest extends AbstractGameStateTest {

  test("update test") {
    controller.state = new ChangingWeapon(characters.head)
    controller.update

    assert(controller.state.isChangingWeapon())
  }
}
