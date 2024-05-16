import weapons.Staff
import weapons.MagicWeapon
import characters.WhiteMage

/** Test class for the Staff Weapon. */
class StaffTest extends munit.FunSuite {
    var testStaff: Option[MagicWeapon] = None

    test("Constructor test") {
        val whiteMageOwner = new WhiteMage("WhiteMage 1", 100, 50, 70, 40)
        testStaff = Some(new Staff("Staff", 30, 40, 10, whiteMageOwner))
        assert(testStaff.isDefined)
        val staff = testStaff.get
        assertEquals(staff.getName, "Staff")
        assertEquals(staff.getAttackPoints, 30)
        assertEquals(staff.getMagicAttack, 40)
        assertEquals(staff.getWeight, 10)

        assertEquals(staff.getOwner, whiteMageOwner)
    }
}
