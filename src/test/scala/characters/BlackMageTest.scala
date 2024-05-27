package characters

class BlackMageTest extends munit.FunSuite {
    var testBlackMage: Option[MagicalCharacter] = None

    test("Constructor and getters test") {
        testBlackMage = Some(new BlackMage("BlackMage", 100, 50, 70, 40))
        assert(testBlackMage.isDefined)
        val blackMage = testBlackMage.get
        assertEquals(blackMage.getName, "BlackMage")
        assertEquals(blackMage.getHealthPoints, 100)
        assertEquals(blackMage.getDefense, 50)
        assertEquals(blackMage.getWeight, 70)
        assertEquals(blackMage.getManaPoints, 40)

    }

}
