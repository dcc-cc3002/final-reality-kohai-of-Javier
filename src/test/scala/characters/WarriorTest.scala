package characters

import characters.enemies._
import weapons.Weapon
import weapons.Bow
import exceptions.{InvalidStatException, SameTypeException}

class WarriorTest extends munit.FunSuite {
    var testWarrior: Option[WCharacter] = None
    var testEnemy: Option[TEnemy] = None
    var weapon: Option[Weapon] = None

    override def beforeEach(context: BeforeEach) = {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        testEnemy = Some(new Enemy("Enemy", 100, 33, 50,70))
        weapon = Some(new Bow("Bow", 60, 10, testWarrior.get))
    }

    test("Constructor test") {
        assert(testWarrior.isDefined)
        val warrior = testWarrior.get
        assertEquals(warrior.getName, "Warrior")
        assertEquals(warrior.getHealthPoints, 100)
        assertEquals(warrior.getDefense, 50)
        assertEquals(warrior.getWeight, 70)
    }

    test("Constructor test with an empty name") {
        intercept[InvalidStatException] {
            testWarrior = Some(new Warrior("", 100, 50, 70))
        }
    }

    test("Constructor test with invalid hp") {
        intercept[InvalidStatException]{
            testWarrior = Some(new Warrior("Warrior", -100, 50, 70))
        }
    }

    test("setWeapon test") {
        testWarrior.get.setWeapon(weapon.get)
        assertEquals(testWarrior.get.getWeapon.get, weapon.get)
    }

    test("fullActionBar") {
        testWarrior.get.setWeapon(new Bow("Bow", 33, 10, testWarrior.get))
        assertEquals(testWarrior.get.fullActionBar, 75)
    }

    test("attack test") {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        testWarrior.get.setWeapon(new Bow("Bow", 60, 10, testWarrior.get))

        testWarrior.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 90)
    }

    test("attack test with overkiller weapon") {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        weapon = Some(new Bow("Bow", 10000, 10, testWarrior.get))
        testWarrior.get.setWeapon(weapon.get)
        testWarrior.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 0)
    }

    test("attack test with too weak weapon") {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        weapon = Some(new Bow("Bow", 10, 10, testWarrior.get))
        testWarrior.get.setWeapon(weapon.get)

        testWarrior.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 100)
    }

    test("attack test without weapon") {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        intercept[Exception](testWarrior.get.attack(testEnemy.get))
    }

    test("Character tries to attack another playable Character") {
        val testWarrior2: WCharacter = new Warrior("Warrior 2", 100, 50, 70)
        intercept[SameTypeException](testWarrior.get.attack(testWarrior2))
    }

    private def testUnsetWeapon = {
        assert(testWarrior.isDefined)
        testWarrior.get.unsetWeapon
        assertEquals(false, testWarrior.get.getWeapon.isDefined)
    }

    test("unsetWeapon with weapon") {
        testWarrior.get.setWeapon(weapon.get)
        testUnsetWeapon
    }

    test("unsetWeapon without weapon") {
        testUnsetWeapon
    }
}
