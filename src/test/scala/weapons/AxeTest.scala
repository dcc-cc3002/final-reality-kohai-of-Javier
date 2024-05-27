package weapons
import characters._
import exceptions._

/** Test class for the Axe Weapon. */
class AxeTest extends munit.FunSuite {

    test("Constructor test") {
        val testOwner: Option[WCharacter] = Some(new Paladin("Paladin 1", 100, 50, 70))
        val testAxe: Option[Weapon] = Some(new Axe("Axe",30, 10, testOwner.get))
        assert(testAxe.isDefined)
        val axe: Weapon = testAxe.get
        assertEquals(axe.getName, "Axe")
        assertEquals(axe.getAttackPoints,30)
        assertEquals(axe.getWeight, 10)

        assertEquals(axe.getOwner, testOwner.get)
    }

    test("Constructor test with an empty name") {
        intercept[InvalidStatException] {
            val testAxe: Weapon = new Axe("", 30, 10, new Paladin("Paladin 1", 100, 50, 70))
        }
    }

    test("Set Axe to another owner") {
        val testOwner1 = new Paladin("Paladin 1", 100, 50, 70)
        val testOwner2 = new Paladin("Paladin 2", 100, 50, 70)
        val testAxe = new Axe("Axe", 30, 10, testOwner1)
        intercept[DoubleEquipmentException](testOwner2.setWeapon(testAxe))
    }

    private def assertCompatibleWeapon(testOwner: WCharacter): Unit = {
        val testWeapon: Weapon = new Axe("Axe",30,10, testOwner)
        testOwner.setWeapon(testWeapon)
        assert(testOwner.getWeapon.isDefined)
        assertEquals(testOwner.getWeapon.get, testWeapon)
    }

    private def assertIncompatibleWeapon(testOwner: WCharacter): Unit = {
        intercept[IncompatibleWeaponException](new Axe("Axe",30,10, testOwner))
    }

    test("Set to a Paladin") {
        assertCompatibleWeapon(new Paladin("Paladin 1", 100, 50, 70))
    }

    test("Set to a Warrior") {
        assertCompatibleWeapon(new Warrior("Warrior 1", 100, 50, 70))
    }

    test("Set to a Ninja") {
        assertIncompatibleWeapon(new Ninja("Ninja 1", 100, 50, 70))
    }

    test("Set to a Black Mage") {
        assertIncompatibleWeapon(new BlackMage("BlackMage 1", 100, 50, 70, 40))

    }

    test("Set to a White Mage") {
        assertIncompatibleWeapon(new WhiteMage("WhiteMage 1", 100, 50, 70, 40))
    }
}
