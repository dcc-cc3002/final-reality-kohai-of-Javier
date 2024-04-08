class PaladinTest extends munit.FunSuite {
    var testPaladin = Option[Paladin] = None

    test("Constructor test") {
        testPaladin = Some(new Paladin("Paladin 1", 100.0, 50.0, 70.1))
        assert(testPaladin.isDefined)
        val paladin = testPaladin.get
        assertEquals(paladin.name, "Paladin 1")
        assertEquals(paladin.healthPoints, 100.0)
        assertEquals(paladin.defense, 50.0)
        assertEquals(paladin.weight, 70.1)

        assertEquals(testPaladin.weapon, None)

}
