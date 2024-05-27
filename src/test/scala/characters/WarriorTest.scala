package characters


class WarriorTest extends munit.FunSuite {
    var testWarrior: Option[WCharacter] = None

    test("Constructor test") {
        testWarrior = Some(new Warrior("Warrior", 100, 50, 70))
        assert(testWarrior.isDefined)
        val warrior = testWarrior.get
        assertEquals(warrior.getName, "Warrior")
        assertEquals(warrior.getHealthPoints, 100)
        assertEquals(warrior.getDefense, 50)
        assertEquals(warrior.getWeight, 70)
    }

}
