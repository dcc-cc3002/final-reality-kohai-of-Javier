import characters.Paladin
import weapons.Wand

class WandTest extends munit.FunSuite {
    var testWand: Option[Wand] = None

    test("Constructor test") {
        val paladinOwner = new Paladin("Paladin 1", 100.0, 50.0, 70.1)
        testWand = Some(new Wand("Wand 1", 33.3, 44.4, 20.5, paladinOwner))
        assert(testWand.isDefined)
        val wand = testWand.get
        assertEquals(wand.name, "Wand 1")
        assertEquals(wand.attackPoints, 33.3)
        assertEquals(wand.weight, 20.5)

        assertEquals(wand.owner, paladinOwner)
    }
}
