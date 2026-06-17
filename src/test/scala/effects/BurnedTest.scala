package effects

import characters.enemies.{Enemy, TEnemy}

class BurnedTest extends munit.FunSuite {
  var testEffect: TEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    testEffect = new Burned(30)
  }

  test("getTurns test") {
    assertEquals(testEffect.getTurns, 3)
  }

  test("Apply test") {
    val testEnemy: TEnemy = new Enemy("Enemy", 100, 50, 50, 70)
    testEffect.apply(testEnemy)
    assertEquals(testEnemy.getHealthPoints, 85)
    assertEquals(testEffect.getTurns, 2)
  }
}
