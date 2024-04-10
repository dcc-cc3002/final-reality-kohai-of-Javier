import characters.BlackMage

class BlackMageTest extends munit.FunSuite {
    var testBlackMage: Option[BlackMage] = None

    test("Constructor test") {
        testBlackMage = Some(new BlackMage("BlackMage 1", 100.0, 50.0, 70.1, 200))
        assert(testBlackMage.isDefined)
        val blackMage = testBlackMage.get
        assertEquals(blackMage.name, "BlackMage 1")
        assertEquals(blackMage.healthPoints, 100.0)
        assertEquals(blackMage.defense, 50.0)
        assertEquals(blackMage.weight, 70.1)
        assertEquals(blackMage.manaPoints, 200.0)

        assertEquals(blackMage.weapon, None)

    }

}
