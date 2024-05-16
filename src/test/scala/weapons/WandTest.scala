import characters.Ninja
import weapons.{MagicWeapon, Wand}

/** Test class for the Wand Weapon. */
class WandTest extends munit.FunSuite {
    var testWand: Option[MagicWeapon] = None

    test("Constructor test") {
        val ninjaOwner = new Ninja("Ninja 1", 100, 50, 70)
        testWand = Some(new Wand("Wand", 30, 40, 10, ninjaOwner))
        assert(testWand.isDefined)
        val wand = testWand.get
        assertEquals(wand.getName, "Wand")
        assertEquals(wand.getAttackPoints, 30)
        assertEquals(wand.getMagicAttack, 40)
        assertEquals(wand.getWeight, 10)

        assertEquals(wand.getOwner, ninjaOwner)
    }
}
