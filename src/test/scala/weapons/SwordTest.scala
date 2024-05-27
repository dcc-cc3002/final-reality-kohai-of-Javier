package weapons
import characters._
import exceptions.{InvalidStatException, IncompatibleWeaponException}

/** Test class for the Sword Weapon. */
class SwordTest extends munit.FunSuite {

    test("Constructor test") {
        val testOwner: WCharacter = new Paladin("Paladin 1", 100, 50, 70)
        val testSword: Option[Weapon] = Some(new Sword("Sword",30, 10, testOwner))
        assert(testSword.isDefined)
        val sword: Weapon = testSword.get
        assertEquals(sword.getName, "Sword")
        assertEquals(sword.getAttackPoints,30)
        assertEquals(sword.getWeight, 10)

        assertEquals(sword.getOwner, testOwner)
    }

    private def assertCompatibleWeapon(testOwner: WCharacter): Unit = {
        val testWeapon: Weapon = new Sword("Sword",30,10, testOwner)
        testOwner.setWeapon(testWeapon)
        assert(testOwner.getWeapon.isDefined)
        assertEquals(testOwner.getWeapon.get, testWeapon)
    }

    private def assertIncompatibleWeapon(testOwner: WCharacter): Unit = {
        intercept[IncompatibleWeaponException](new Sword("Sword",30,10, testOwner))
    }

    test("Set to a Paladin") {
        assertCompatibleWeapon(new Paladin("Paladin 1", 100, 50, 70))
    }

    test("Set to a Warrior") {
        assertCompatibleWeapon(new Warrior("Warrior 1", 100, 50, 70))
    }

    test("Set to a Ninja") {
        assertCompatibleWeapon(new Ninja("Ninja 1", 100, 50, 70))
    }

    test("Set to a Black Mage") {
        assertCompatibleWeapon(new BlackMage("BlackMage 1", 100, 50, 70, 40))

    }

    test("Set to a White Mage") {
        assertIncompatibleWeapon(new WhiteMage("WhiteMage 1", 100, 50, 70, 40))
    }
}
