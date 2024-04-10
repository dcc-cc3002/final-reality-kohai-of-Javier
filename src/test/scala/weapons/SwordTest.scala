import characters.Paladin
import weapons.Sword

class SwordTest extends munit.FunSuite {
    var testSword: Option[Sword] = None

    test("Constructor test") {
        val paladinOwner = new Paladin("Paladin 1", 100.0, 50.0, 70.1)
        testSword = Some(new Sword("Sword 1", 33.3, 20.5, paladinOwner))
        assert(testSword.isDefined)
        val sword = testSword.get
        assertEquals(sword.name, "Sword 1")
        assertEquals(sword.attackPoints, 33.3)
        assertEquals(sword.weight, 20.5)

        assertEquals(sword.owner, paladinOwner)
    }
}
