import weapons.Staff
import weapons.MagicWeapon
import characters._
import exceptions.{InvalidStatException, IncompatibleWeaponException}


/** Test class for the Staff Weapon. */
class StaffTest extends munit.FunSuite {

    test("Constructor test") {
        val testOwner: MagicalCharacter = new WhiteMage("WhiteMage 1", 100, 50, 70, 40)
        val testStaff: Option[MagicWeapon] = Some(new Staff("Staff", 30, 40, 10, testOwner))
        assert(testStaff.isDefined)
        val staff: MagicWeapon = testStaff.get
        assertEquals(staff.getName, "Staff")
        assertEquals(staff.getAttackPoints, 30)
        assertEquals(staff.getMagicAttack, 40)
        assertEquals(staff.getWeight, 10)

        assertEquals(staff.getOwner, testOwner)
    }


    private def assertCompatibleWeapon(testOwner: WCharacter): Unit = {
        val testWeapon: MagicWeapon = new Staff("Staff",30, 30,10, testOwner)
        testOwner.setWeapon(testWeapon)
        assert(testOwner.getWeapon.isDefined)
        assertEquals(testOwner.getWeapon.get, testWeapon)
    }

    private def assertIncompatibleWeapon(testOwner: WCharacter): Unit = {
        intercept[IncompatibleWeaponException](new Staff("Staff",30, 30,10, testOwner))
    }

    test("Set to a Paladin") {
        assertIncompatibleWeapon(new Paladin("Paladin 1", 100, 50, 70))
    }

    test("Set to a Warrior") {
        assertIncompatibleWeapon(new Warrior("Warrior 1", 100, 50, 70))
    }

    test("Set to a Ninja") {
        assertIncompatibleWeapon(new Ninja("Ninja 1", 100, 50, 70))
    }

    test("Set to a Black Mage") {
        assertCompatibleWeapon(new BlackMage("BlackMage 1", 100, 50, 70, 40))

    }

    test("Set to a White Mage") {
        assertCompatibleWeapon(new WhiteMage("WhiteMage 1", 100, 50, 70, 40))
    }
}
