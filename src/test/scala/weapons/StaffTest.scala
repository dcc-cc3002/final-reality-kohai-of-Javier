class StaffTest extends munit.FunSuite {
    var testStaff = Option[Staff] = None

    test("Constructor test") {
        testStaff = Some(new Staff("Staff 1", 33.3, 20.5, new Paladin("Paladin 1", 100.0, 50.0, 70.1)))
        assert(testStaff.isDefined)
        val staff = testStaff.get
        assertEquals(staff.name, "Staff 1")
        assertEquals(staff.attackPoints, 33.3)
        assertEquals(staff.weight, 20.5)

        assertEquals(testStaff.owner, new Paladin("Paladin 1", 100.0, 50.0, 70.1))

}
