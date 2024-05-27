package characters


class WhiteMageTest extends munit.FunSuite {
    var testWhiteMage: Option[MagicalCharacter] = None

    test("Constructor test") {
        testWhiteMage = Some(new WhiteMage("WhiteMage", 100, 50, 70, 40))
        assert(testWhiteMage.isDefined)
        val whiteMage = testWhiteMage.get
        assertEquals(whiteMage.getName, "WhiteMage")
        assertEquals(whiteMage.getHealthPoints, 100)
        assertEquals(whiteMage.getDefense, 50)
        assertEquals(whiteMage.getWeight, 70)
        assertEquals(whiteMage.getManaPoints, 40)
    }

}
