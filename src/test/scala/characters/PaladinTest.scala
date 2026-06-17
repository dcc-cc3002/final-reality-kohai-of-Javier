package characters

class PaladinTest extends munit.FunSuite {
    var testPaladin: Option[WCharacter] = None

    test("Constructor test") {
        testPaladin = Some(new Paladin("Paladin", 100, 50, 70))
        assert(testPaladin.isDefined)
        val paladin = testPaladin.get
        assertEquals(paladin.getName, "Paladin")
        assertEquals(paladin.getHealthPoints, 100)
        assertEquals(paladin.getDefense,50)
        assertEquals(paladin.getWeight, 70)
    }

}
