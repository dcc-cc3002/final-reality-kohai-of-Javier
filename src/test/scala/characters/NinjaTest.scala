class NinjaTest extends munit.FunSuite {
    var testNinja = Option[Ninja] = None

    test("Constructor test") {
        testNinja = Some(new Ninja("Ninja 1", 100.0, 50.0, 70.1))
        assert(testNinja.isDefined)
        val ninja = testNinja.get
        assertEquals(ninja.name, "Ninja 1")
        assertEquals(ninja.healthPoints, 100.0)
        assertEquals(ninja.defense, 50.0)
        assertEquals(ninja.weight, 70.1)

        assertEquals(testNinja.weapon, None)

}
