class WhiteMageTest extends munit.FunSuite {
    var testWhiteMage = Option[WhiteMage] = None

    test("Constructor test") {
        testWhiteMage = Some(new WhiteMage("WhiteMage 1", 100.0, 50.0, 70.1, 200))
        assert(testWhiteMage.isDefined)
        val whiteMage = testWhiteMage.get
        assertEquals(whiteMage.name, "WhiteMage 1")
        assertEquals(whiteMage.healthPoints, 100.0)
        assertEquals(whiteMage.defense, 50.0)
        assertEquals(whiteMage.weight, 70.1)
        assertEquals(whiteMage.manaPoints, 200.0)

        assertEquals(testWhiteMage.weapon, None)

    }

}
