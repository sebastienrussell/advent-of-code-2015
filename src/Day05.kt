fun main() {
    fun String.vowels() = filter { it in listOf('a', 'i', 'e', 'o', 'u') }
    fun String.sameLetterInARow() = windowed(2).any { it[0] == it[1] }
    fun String.isNiceStringPart1() =
        vowels().count() >= 3 && sameLetterInARow() && listOf("ab", "cd", "pq", "xy").none { contains(it) }


    fun part1(input: List<String>): Int =
        input.count { it.isNiceStringPart1() }

    fun String.sameLetterInARowWithoutOverlaps(): Boolean =
        "([a-z][a-z])[a-z]*\\1".toRegex().containsMatchIn(this)

    fun String.sameLettersSeperatedByALetter() =
        "([a-z])[a-z]\\1".toRegex().containsMatchIn(this)

    fun String.isNiceStringPart2() =
        sameLetterInARowWithoutOverlaps() && sameLettersSeperatedByALetter()

    fun part2(input: List<String>): Int =
        input.count { it.isNiceStringPart2() }

    val examplesPart1 = listOf("ugknbfddgicrmopn", "aaa", "jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb")
    check(examplesPart1[0].isNiceStringPart1())
    check(examplesPart1[1].isNiceStringPart1())
    check(!examplesPart1[2].isNiceStringPart1())
    check(!examplesPart1[3].isNiceStringPart1())
    check(!examplesPart1[4].isNiceStringPart1())
    check(part1(examplesPart1) == 2)

    val examplesPart2 = listOf("qjhvhtzxzqqjkmpb", "xxyxx", "uurcxstgmygtbstg", "ieodomkazucvgmuy", "xxxyxx")
    check(examplesPart2[0].isNiceStringPart2())
    check(examplesPart2[1].isNiceStringPart2())
    check(!examplesPart2[2].isNiceStringPart2())
    check(!examplesPart2[3].isNiceStringPart2())
    check(examplesPart2[4].isNiceStringPart2())
    check(part2(examplesPart2) == 3)

    val input = readInput("Day05")
    print("Part 1 :")
    part1(input).println()
    print("Part 2 :")
    part2(input).println()
}
