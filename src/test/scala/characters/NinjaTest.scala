import characters.{TEnemy, Enemy, WCharacter, Ninja}
import weapons.Weapon
import weapons.Bow
import exceptions.{InvalidStatException, SameTypeException}

class NinjaTest extends munit.FunSuite {
    var testNinja: Option[WCharacter] = None
    var testEnemy: Option[TEnemy] = None
    var weapon: Option[Weapon] = None

    override def beforeEach(context: BeforeEach) = {
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
        testEnemy = Some(new Enemy("Enemy", 100, 33, 50,70))
        weapon = Some(new Bow("Bow", 60, 10, testNinja.get))
    }

    test("Constructor test") {
        assert(testNinja.isDefined)
        val ninja = testNinja.get
        assertEquals(ninja.getName, "Ninja")
        assertEquals(ninja.getHealthPoints, 100)
        assertEquals(ninja.getDefense, 50)
        assertEquals(ninja.getWeight, 70)
    }

    test("Constructor test with an empty name") {
        intercept[InvalidStatException] {
            testNinja = Some(new Ninja("", 100, 50, 70))
        }
    }

    test("Constructor test with invalid hp") {
        intercept[InvalidStatException]{
            testNinja = Some(new Ninja("Ninja", -100, 50, 70))
        }
    }

    test("setWeapon test") {
        testNinja.get.setWeapon(weapon.get)
        assertEquals(testNinja.get.getWeapon.get, weapon.get)
    }

    test("fullActionBar") {
        testNinja.get.setWeapon(new Bow("Bow", 33, 10, testNinja.get))
        assertEquals(testNinja.get.fullActionBar, 75)
    }

    test("attack test") {
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
        testNinja.get.setWeapon(new Bow("Bow", 60, 10, testNinja.get))

        testNinja.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 90)
    }

    test("attack test with overkiller weapon") {
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
        weapon = Some(new Bow("Bow", 10000, 10, testNinja.get))
        testNinja.get.setWeapon(weapon.get)
        testNinja.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 0)
    }

    test("attack test with too weak weapon") {
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
        weapon = Some(new Bow("Bow", 10, 10, testNinja.get))
        testNinja.get.setWeapon(weapon.get)

        testNinja.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 100)
    }

    test("attack test without weapon") {
        testNinja = Some(new Ninja("Ninja", 100, 50, 70))
        intercept[Exception](testNinja.get.attack(testEnemy.get))
    }

    test("Character tries to attack another playable Character") {
        val testNinja2: WCharacter = new Ninja("Ninja 2", 100, 50, 70)
        intercept[SameTypeException](testNinja.get.attack(testNinja2))
    }

    private def testUnsetWeapon = {
        assert(testNinja.isDefined)
        testNinja.get.unsetWeapon
        assertEquals(false, testNinja.get.getWeapon.isDefined)
    }

    test("unsetWeapon with weapon") {
        testNinja.get.setWeapon(weapon.get)
        testUnsetWeapon
    }

    test("unsetWeapon without weapon") {
        testUnsetWeapon
    }
}
