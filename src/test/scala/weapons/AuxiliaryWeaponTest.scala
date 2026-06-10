import weapons.AuxiliaryWeapon
import characters.Paladin

class AuxiliaryWeaponTest extends munit.FunSuite {
    var testAuxiliaryWeapon: Option[AuxiliaryWeapon] = None

    test("Constructor test") {
        val enemyOwner = new Enemy("Enemy 1", 100.0, 33.3, 50.0, 70.1)
        testAuxiliaryWeapon = Some(new AuxiliaryWeapon("AuxiliaryWeapon 1", 33.3, 20.5, enemyOwner))
        assert(testAuxiliaryWeapon.isDefined)
        val auxiliaryWeapon = testAuxiliaryWeapon.get
        assertEquals(auxiliaryWeapon.name, "AuxiliaryWeapon 1")
        assertEquals(auxiliaryWeapon.attackPoints, 33.3)
        assertEquals(auxiliaryWeapon.weight, 20.5)

        assertEquals(auxiliaryWeapon.owner, enemyOwner)
    }

}
