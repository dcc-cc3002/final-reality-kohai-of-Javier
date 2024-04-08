class SwordTest extends munit.FunSuite {
    var testSword = Option[Sword] = None

    test("Constructor test") {
        testSword = Some(new Sword("Sword 1", 33.3, 20.5, new Paladin("Paladin 1", 100.0, 50.0, 70.1)))
        assert(testSword.isDefined)
        val sword = testSword.get
        assertEquals(sword.name, "Sword 1")
        assertEquals(sword.attackPoints, 33.3)
        assertEquals(sword.weight, 20.5)

        assertEquals(testSword.owner, new Paladin("Paladin 1", 100.0, 50.0, 70.1))

}
