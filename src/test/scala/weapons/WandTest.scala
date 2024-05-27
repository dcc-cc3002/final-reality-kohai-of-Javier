package weapons
import characters._
import exceptions.{InvalidStatException, IncompatibleWeaponException}

/** Test class for the Wand Weapon. */
class WandTest extends munit.FunSuite {

    test("Constructor test") {
        val testOwner = new Ninja("Ninja 1", 100, 50, 70)
        val testWeapon: Option[MagicWeapon] = Some(new Wand("Wand", 30, 40, 10, testOwner))
        assert(testWeapon.isDefined)
        val wand: MagicWeapon = testWeapon.get
        assertEquals(wand.getName, "Wand")
        assertEquals(wand.getAttackPoints, 30)
        assertEquals(wand.getMagicAttack, 40)
        assertEquals(wand.getWeight, 10)

        assertEquals(wand.getOwner, testOwner)
    }

    private def assertCompatibleWeapon(testOwner: WCharacter): Unit = {
        val testWeapon: MagicWeapon = new Wand("Wand",30, 30,10, testOwner)
        testOwner.setWeapon(testWeapon)
        assert(testOwner.getWeapon.isDefined)
        assertEquals(testOwner.getWeapon.get, testWeapon)
    }

    private def assertIncompatibleWeapon(testOwner: WCharacter): Unit = {
        intercept[IncompatibleWeaponException](new Wand("Wand",30, 30,10, testOwner))
    }

    test("Set to a Paladin") {
        assertIncompatibleWeapon(new Paladin("Paladin 1", 100, 50, 70))
    }

    test("Set to a Warrior") {
        assertIncompatibleWeapon(new Warrior("Warrior 1", 100, 50, 70))
    }

    test("Set to a Ninja") {
        assertCompatibleWeapon(new Ninja("Ninja 1", 100, 50, 70))
    }

    test("Set to a Black Mage") {
        assertCompatibleWeapon(new BlackMage("BlackMage 1", 100, 50, 70, 40))

    }

    test("Set to a White Mage") {
        assertCompatibleWeapon(new WhiteMage("WhiteMage 1", 100, 50, 70, 40))
    }
}
