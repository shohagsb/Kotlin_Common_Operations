fun main(args: Array<String>) {
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE),
    )


    // Phase-1

    /** first, firstOrNull, last, lastOrNull * */
    println("First hero name of the list: ${heroes.first().name}")
    println("First hero name of the list: ${heroes.firstOrNull()?.name}")
    println("Hero name who's age is 30: ${heroes.firstOrNull { it.age == 30 }?.name}")

    /** Map, Distinct */
    println("Map: ${heroes.map { it.age }}")
    println("Distinct: ${heroes.map { it.age }.distinct()}")
    println("Distinct: ${heroes.map { it.age }.distinct().size}")

    /** Filter */
    println("Filter: ${heroes.filter { it.age < 30 }.size}")

    /** Partition */
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println("Partition- Youngest: ${youngest.size}, Oldest: ${oldest.size}") //Youngest: 3, Oldest: 3

    /** maxBy */
    println("maxBy: ${heroes.maxBy { it.age < 30 }.name}") //The Kid


    /** all, any, none : Kotlin predicates */

    /** all */
    println("all: ${heroes.all { it.age < 50 }}")  // false

    /** any */
    println("any: ${heroes.any { it.gender == Gender.FEMALE }}") // true

    /** any */
    println("none: ${heroes.none { it.gender == Gender.FEMALE }}") // false

    // Phase: 2

    /** groupBy, maxBy */
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    println("groupBy : $mapByAge")

    val (age, group) = mapByAge.maxBy { (_, group) ->
        group.size
    }

    /** associateBy, associate */
    val mapByName = heroes.associateBy { it.name }
    mapByName["unknown"]?.age  // null
    mapByName.getValue("unknown").age  // NoSuchElementException

    val mapByAssociate = heroes.associate { it.name to it.age } // map of name and age
    mapByAssociate.getOrElse("unknown") { 0 } // 0


    println("maxBy: $age : ${group.size}")

}