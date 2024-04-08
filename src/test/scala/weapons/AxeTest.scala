class AxeTest extends munit.FunSuite {
    var testAxe = Option[Axe] = None

    test("Constructor test") {
        testAxe = Some(new Axe("Axe 1", 33.3, 20.5, new Paladin("Paladin 1", 100.0, 50.0, 70.1)))
        assert(testAxe.isDefined)
        val axe = testAxe.get
        assertEquals(axe.name, "Axe 1")
        assertEquals(axe.attackPoints, 33.3)
        assertEquals(axe.weight, 20.5)

        assertEquals(testAxe.owner, new Paladin("Paladin 1", 100.0, 50.0, 70.1))

}
