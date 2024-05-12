import characters.Paladin
import weapons.{Sword, Weapon}

/** Test class for the Sword Weapon. */
class SwordTest extends munit.FunSuite {
    var testSword: Option[Weapon] = None

    test("Constructor test") {
        val paladinOwner = new Paladin("Paladin 1", 100, 50, 70)
        testSword = Some(new Sword("Sword",30, 10, paladinOwner))
        assert(testSword.isDefined)
        val sword = testSword.get
        assertEquals(sword.getName, "Sword")
        assertEquals(sword.getAttackPoints,30)
        assertEquals(sword.getWeight, 10)

        assertEquals(sword.getOwner, paladinOwner)
    }
}
