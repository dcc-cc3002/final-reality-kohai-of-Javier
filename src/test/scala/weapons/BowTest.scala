package weapons
import characters._
import characters.magicalcharacters._
import exceptions.{InvalidStatException, IncompatibleWeaponException}


/** Test class for the Bow Weapon. */
class BowTest extends munit.FunSuite {

    test("Constructor test") {
        val testOwner: WCharacter = new Warrior("Warrior 1", 100, 50, 70)
        val testBow: Option[Weapon] = Some(new Bow("Bow",30, 10, testOwner))
        assert(testBow.isDefined)
        val bow: Weapon = testBow.get
        assertEquals(bow.getName, "Bow")
        assertEquals(bow.getAttackPoints, 30)
        assertEquals(bow.getWeight, 10)

        assertEquals(bow.getOwner, testOwner)
    }


    private def assertCompatibleWeapon(testOwner: WCharacter): Unit = {
        val testWeapon: Weapon = new Bow("Bow",30,10, testOwner)
        testOwner.setWeapon(testWeapon)
        assert(testOwner.getWeapon.isDefined)
        assertEquals(testOwner.getWeapon.get, testWeapon)
    }

    private def assertIncompatibleWeapon(testOwner: WCharacter): Unit = {
        intercept[IncompatibleWeaponException](new Bow("Bow", 30,10, testOwner))
    }

    test("Set to a Paladin") {
        assertIncompatibleWeapon(new Paladin("Paladin 1", 100, 50, 70))
    }

    test("Set to a Warrior") {
        assertCompatibleWeapon(new Warrior("Warrior 1", 100, 50, 70))
    }

    test("Set to a Ninja") {
        assertCompatibleWeapon(new Ninja("Ninja 1", 100, 50, 70))
    }

    test("Set to a Black Mage") {
        assertIncompatibleWeapon(new BlackMage("BlackMage 1", 100, 50, 70, 40))

    }

    test("Set to a White Mage") {
        assertCompatibleWeapon(new WhiteMage("WhiteMage 1", 100, 50, 70, 40))
    }
}
