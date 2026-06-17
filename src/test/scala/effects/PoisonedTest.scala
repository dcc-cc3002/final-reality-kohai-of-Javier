package effects

import characters.enemies.{Enemy, TEnemy}

class PoisonedTest extends munit.FunSuite {
  var testEffect: TEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    testEffect = new Poisoned(30)
  }

  test("getTurns test") {
    assertEquals(testEffect.getTurns, 4)
  }

  test("Apply test") {
    val testEnemy: TEnemy = new Enemy("Enemy", 100, 50, 50, 70)
    testEffect.apply(testEnemy)
    assertEquals(testEnemy.getHealthPoints, 90)
    assertEquals(testEffect.getTurns, 3)
  }
}
