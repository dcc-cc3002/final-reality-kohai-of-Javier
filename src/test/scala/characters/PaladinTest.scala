package characters

import characters.enemies._
import weapons.Weapon
import weapons.Sword
import exceptions.{InvalidStatException, SameTypeException}

class PaladinTest extends munit.FunSuite {
    var testPaladin: Option[WCharacter] = None
    var testEnemy: Option[TEnemy] = None
    var weapon: Option[Weapon] = None

    override def beforeEach(context: BeforeEach) = {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        testEnemy = Some(new Enemy("Enemy", 100, 33, 50,70))
        weapon = Some(new Sword("Sword", 60, 10, testPaladin.get))
    }

    test("Constructor test") {
        assert(testPaladin.isDefined)
        val paladin = testPaladin.get
        assertEquals(paladin.getName, "Paladin")
        assertEquals(paladin.getHealthPoints, 100)
        assertEquals(paladin.getDefense, 50)
        assertEquals(paladin.getWeight, 70)
    }

    test("Constructor test with an empty name") {
        intercept[InvalidStatException] {
            testPaladin = Some(new Paladin("", 100, 50, 70))
        }
    }

    test("Constructor test with invalid hp") {
        intercept[InvalidStatException]{
            testPaladin = Some(new Paladin("Paladin", -100, 50, 70))
        }
    }

    test("setWeapon test") {
        testPaladin.get.setWeapon(weapon.get)
        assertEquals(testPaladin.get.getWeapon.get, weapon.get)
    }

    test("fullActionBar") {
        testPaladin.get.setWeapon(new Sword("Sword", 33, 10, testPaladin.get))
        assertEquals(testPaladin.get.fullActionBar, 75)
    }

    test("attack test") {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        testPaladin.get.setWeapon(new Sword("Sword", 60, 10, testPaladin.get))

        testPaladin.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 90)
    }

    test("attack test with overkiller weapon") {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        weapon = Some(new Sword("Sword", 10000, 10, testPaladin.get))
        testPaladin.get.setWeapon(weapon.get)
        testPaladin.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 0)
    }

    test("attack test with too weak weapon") {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        weapon = Some(new Sword("Sword", 10, 10, testPaladin.get))
        testPaladin.get.setWeapon(weapon.get)

        testPaladin.get.attack(testEnemy.get)
        assertEquals(testEnemy.get.getHealthPoints, 100)
    }

    test("attack test without weapon") {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        intercept[Exception](testPaladin.get.attack(testEnemy.get))
    }

    test("Character tries to attack another playable Character") {
        val testPaladin2: WCharacter = new Paladin("Paladin 2", 100, 50, 70)
        intercept[SameTypeException](testPaladin.get.attack(testPaladin2))
    }

    private def testUnsetWeapon = {
        assert(testPaladin.isDefined)
        testPaladin.get.unsetWeapon
        assertEquals(false, testPaladin.get.getWeapon.isDefined)
    }

    test("unsetWeapon with weapon") {
        testPaladin.get.setWeapon(weapon.get)
        testUnsetWeapon
    }

    test("unsetWeapon without weapon") {
        testUnsetWeapon
    }
}
