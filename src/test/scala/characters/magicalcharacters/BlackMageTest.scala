package characters.magicalcharacters

import characters._
import characters.enemies._
import weapons.magicweapons._

class BlackMageTest extends munit.FunSuite {
    var testBlackMage: Option[MagicalCharacter] = None

    override def beforeEach(context: BeforeEach) = {
        testBlackMage = Some(new BlackMage("BlackMage", 100, 50, 70, 40))
    }

    test("Constructor and getters test") {
        assert(testBlackMage.isDefined)
        val blackMage = testBlackMage.get
        assertEquals(blackMage.getName, "BlackMage")
        assertEquals(blackMage.getHealthPoints, 100)
        assertEquals(blackMage.getDefense, 50)
        assertEquals(blackMage.getWeight, 70)
        assertEquals(blackMage.getManaPoints, 40)

    }

    test("setWeapon and unsetWeapon test") {
        assert(!testBlackMage.get.getMagicWeapon.isDefined)

        val testStaff: MagicWeapon = new Staff("Staff", 30, 40, 10, testBlackMage.get)
        assert(testBlackMage.get.getMagicWeapon.isDefined)
        assertEquals(testBlackMage.get.getMagicWeapon.get, testStaff)

        testBlackMage.get.unsetWeapon
        assert(!testBlackMage.get.getMagicWeapon.isDefined)
    }
}
