import characters.{Paladin, WCharacter}
import weapons.{Axe, Weapon}
import exceptions.InvalidStatException

/** Test class for the Axe Weapon. */
class AxeTest extends munit.FunSuite {
    var testOwner: Option[WCharacter] = None
    var testAxe: Option[Weapon] = None

    override def beforeEach(context: BeforeEach) {
        testOwner = Some(new Paladin("Paladin 1", 100, 50, 70))
        testAxe = Some(new Axe("Axe",30, 10, testOwner.get))
    }

    test("Constructor test") {
        assert(testAxe.isDefined)
        val axe = testAxe.get
        assertEquals(axe.getName, "Axe")
        assertEquals(axe.getAttackPoints,30)
        assertEquals(axe.getWeight, 10)

        assertEquals(axe.getOwner, testOwner.get)
    }

    test("Constructor test with an empty name") {
        intercept[InvalidStatException] {
            testAxe = Some(new Axe("", 30, 10, testOwner.get))
        }
    }
}
