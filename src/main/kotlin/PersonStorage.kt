object PersonStorage {
    val personList: MutableList<Person> = mutableListOf()

    init {
        personList.add(Person("Meier", "Hans", 40 ))
        personList.add(Person("Mahler", "Sandra", 32))
        personList.add(Person("Huber", "Franz", 56))
    }
}