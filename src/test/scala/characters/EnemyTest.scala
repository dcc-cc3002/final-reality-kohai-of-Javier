package characters
import exceptions.SameTypeException

class EnemyTest extends munit.FunSuite {
    var testEnemy: Option[TEnemy] = None
    var testNinja: Option[WCharacter] = None

    override def beforeEach(context: BeforeEach): Unit = {
        testEnemy = Some(new Enemy("Enemy", 100, 60, 50, 70))
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
    }

    test("Constructor and getters test") {
        assert(testEnemy.isDefined)
        val enemy = testEnemy.get
        assertEquals(enemy.getName, "Enemy")
        assertEquals(enemy.getHealthPoints, 100)
        assertEquals(enemy.getAttack, 60)
        assertEquals(enemy.getDefense, 50)
        assertEquals(enemy.getWeight, 70)

    }

    test("fullActionBar") {
        assertEquals(testEnemy.get.fullActionBar, 70)
    }

    test("attack test") {
        testEnemy.get.attack(testNinja.get)
        assertEquals(testNinja.get.getHealthPoints, 90)
    }

    test("overkill attack test") {
        testEnemy = Some(new Enemy("Enemy", 100, 10000, 50, 70))
        testEnemy.get.attack(testNinja.get)
        assertEquals(testNinja.get.getHealthPoints, 0)
    }

    test("too weak attack test") {
        testEnemy = Some(new Enemy("Enemy", 100, 10, 50, 70))
        testEnemy.get.attack(testNinja.get)
        assertEquals(testNinja.get.getHealthPoints, 100)
    }

    test("Enemy tries to attack another Enemy") {
        val testEnemy2: TEnemy = new Enemy("Enemy 2", 100, 60, 50, 70)
        intercept[SameTypeException](testEnemy.get.attack(testEnemy2))
    }
}
