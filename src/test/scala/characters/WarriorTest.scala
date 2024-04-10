import characters.Warrior

class WarriorTest extends munit.FunSuite {
    var testWarrior: Option[Warrior] = None

    test("Constructor test") {
        testWarrior = Some(new Warrior("Warrior 1", 100.0, 50.0, 70.1))
        assert(testWarrior.isDefined)
        val warrior = testWarrior.get
        assertEquals(warrior.name, "Warrior 1")
        assertEquals(warrior.healthPoints, 100.0)
        assertEquals(warrior.defense, 50.0)
        assertEquals(warrior.weight, 70.1)

        assertEquals(warrior.weapon, None)
    }

}
