class EnemyTest extends munit.FunSuite {
    var testEnemy: Option[Enemy] = None

    test("Constructor test") {
        testEnemy = Some(new Enemy("Enemy 1", 100.0, 33.3, 50.0, 70.1))
        assert(testEnemy.isDefined)
        val enemy = testEnemy.get
        assertEquals(enemy.name, "Enemy 1")
        assertEquals(enemy.healthPoints, 100.0)
        assertEquals(enemy.attack, 33.3)
        assertEquals(enemy.defense, 50.0)
        assertEquals(enemy.weight, 70.1)

    }
}
