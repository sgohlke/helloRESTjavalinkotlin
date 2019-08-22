import com.apurebase.kgraphql.KGraphQL

object PersonStorage {
    val personList: MutableList<Person> = mutableListOf()

    init {
        personList.add(Person("Meier", "Hans", 40))
        personList.add(Person("Mahler", "Sandra", 32))
        personList.add(Person("Huber", "Franz", 56))
    }

    val personSchema = KGraphQL.schema {
        configure {
            useDefaultPrettyPrinter = true
        }
        // create query "persons" which returns the persons list
        query("persons") {
            resolver { lastName: String?, firstName: String?, age: Int? ->
                getPersonsMatchingFilter(lastName, firstName, age)
            }
        }
        type<Person>()
    }

    private fun getPersonsMatchingFilter(lastName: String?, firstName: String?, age: Int?): MutableList<Person> =
            personList.filter { person: Person ->
                (lastName == null || lastName.equals(person.lastName))
                        && (firstName == null || firstName.equals(person.firstName))
                        && (age == null || age == person.age)
            }.toMutableList()
}