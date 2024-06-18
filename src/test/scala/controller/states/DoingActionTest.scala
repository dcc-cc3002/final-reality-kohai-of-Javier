package controller.states

import characters.{TCharacter, WCharacter}
import characters.enemies.Enemy
import characters.magicalcharacters.BlackMage
import spells.Thunder
import weapons.Weapon
import weapons.magicweapons.{MagicWeapon, Wand}


class DoingActionTest extends AbstractGameStateTest {

  test("update test with attack that does kill the target") {
    val attackingChar: WCharacter = new BlackMage("Black Mage", 100, 100, 100, 100)
    val wp: Weapon = new Wand("Wand", 100, 100, 100, attackingChar)
    val testEnemy: TCharacter = new Enemy("Enemy", 10, 10, 10, 10)
    controller.state = new DoingAction(attackingChar, testEnemy)
    controller.update

    assertEquals(testEnemy.getHealthPoints, 0)
    assert(controller.state.isCharacterElimination())
  }

  test("update test with attack that does not kill the target") {
    val attackingChar: WCharacter = new BlackMage("Black Mage", 100, 100, 100, 100)
    val wp: Weapon = new Wand("Wand", 100, 100, 100, attackingChar)
    val testEnemy: TCharacter = new Enemy("Enemy", 10000, 10, 10, 10)
    controller.state = new DoingAction(attackingChar, testEnemy)
    controller.update

    assertNotEquals(testEnemy.getHealthPoints, 0)
    assert(controller.state.isTurnProgramming())
  }
}
