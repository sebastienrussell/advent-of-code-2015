fun main() {

    fun part1(input: String): Long {
        var currentVal = 0L
        while (!input.plus(currentVal).md5().startsWith("00000")) {
            currentVal++
        }
        return currentVal
    }

    fun part2(input: String): Long {
        var currentVal = 0L
        while (!input.plus(currentVal).md5().startsWith("000000")) {
            currentVal++
        }
        return currentVal
    }

    check(part1("abcdef") == 609043L)
    check(part1("pqrstuv") == 1048970L)

    print("Part 1 :")
    part1("bgvyzdsv").println()
    print("Part 2 :")
    part2("bgvyzdsv").println()
}
