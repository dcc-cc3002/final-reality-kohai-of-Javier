import characters.Paladin
import weapons.Bow

class BowTest extends munit.FunSuite {
    var testBow: Option[Bow] = None

    test("Constructor test") {
        val paladinOwner = new Paladin("Paladin 1", 100.0, 50.0, 70.1)
        testBow = Some(new Bow("Bow 1", 33.3, 20.5, paladinOwner))
        assert(testBow.isDefined)
        val bow = testBow.get
        assertEquals(bow.name, "Bow 1")
        assertEquals(bow.attackPoints, 33.3)
        assertEquals(bow.weight, 20.5)

        assertEquals(bow.owner, paladinOwner)
    }
}
