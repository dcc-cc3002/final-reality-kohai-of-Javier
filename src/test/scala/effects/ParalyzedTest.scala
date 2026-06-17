package effects

import characters.enemies.{Enemy, TEnemy}

class ParalyzedTest extends munit.FunSuite {
  var testEffect: TEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    testEffect = new Paralyzed
  }

  test("getTurns test") {
    assertEquals(testEffect.getTurns, 1)
  }

  test("apply test") {
    val testEnemy: TEnemy = new Enemy("Enemy", 100, 50, 50, 70)
    testEffect.apply(testEnemy)
    assertEquals(testEffect.getTurns, 0)
    assertEquals(testEnemy.getAction, "skip")

    testEffect.apply(testEnemy)
    assertEquals(testEffect.getTurns, 0)
    assertEquals(testEnemy.getAction, "attack")
  }
}
