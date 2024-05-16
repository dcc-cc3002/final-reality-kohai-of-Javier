import characters.Warrior
import weapons.{Bow, Weapon}

/** Test class for the Bow Weapon. */
class BowTest extends munit.FunSuite {
    var testBow: Option[Weapon] = None

    test("Constructor test") {
        val warriorOwner = new Warrior("Warrior 1", 100, 50, 70)
        testBow = Some(new Bow("Bow",30, 10, warriorOwner))
        assert(testBow.isDefined)
        val bow = testBow.get
        assertEquals(bow.getName, "Bow")
        assertEquals(bow.getAttackPoints, 30)
        assertEquals(bow.getWeight, 10)

        assertEquals(bow.getOwner, warriorOwner)
    }
}
