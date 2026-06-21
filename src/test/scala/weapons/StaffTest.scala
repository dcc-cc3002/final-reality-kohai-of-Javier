import weapons.Staff
import weapons.MagicWeapon
import characters.Paladin

/** Test class for the Staff Weapon. */
class StaffTest extends munit.FunSuite {
    var testStaff: Option[MagicWeapon] = None

    test("Constructor test") {
        val paladinOwner = new Paladin("Paladin 1", 100, 50, 70)
        testStaff = Some(new Staff("Staff", 30, 40, 10, paladinOwner))
        assert(testStaff.isDefined)
        val staff = testStaff.get
        assertEquals(staff.getName, "Staff")
        assertEquals(staff.getAttackPoints, 30)
        assertEquals(staff.getMagicAttack, 40)
        assertEquals(staff.getWeight, 10)

        assertEquals(staff.getOwner, paladinOwner)
    }
}
