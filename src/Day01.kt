fun main() {
    fun part1(input: List<String>): Int {
        return input.asSequence()
                .map { Regex("""\d""").findAll(it) }
                .map { it -> it.map { it.value } }
                .map { it.toList() }
                .filter { it.isNotEmpty() }
                .map { it[0].plus(it[it.count() - 1]) }
                .sumOf { it.toInt() };
    }

    fun convertWrittenDigitsToNumbers(line: String): String {
        val digits = arrayOfNulls<String>(line.length);
        Regex("One", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "1"
        }
        Regex("Two", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "2"
        }
        Regex("Three", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "3"
        }
        Regex("Four", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "4"
        }
        Regex("Five", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "5"
        }
        Regex("Six", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "6"
        }
        Regex("Seven", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "7"
        }
        Regex("Eight", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "8"
        }
        Regex("Nine", RegexOption.IGNORE_CASE).findAll(line).forEach {
            digits[it.range.first] = "9"
        }

        var result = line

        digits.forEachIndexed() { i, it ->
            if (it != null) {
                result = result.replaceRange(i, i + 1, it)
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val toList = input.map { convertWrittenDigitsToNumbers(it) }
                .toList()
        return part1(toList)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_1_test")
    val testInput2 = readInput("Day01_2_test")
    check(part1(testInput) == 142)
    check(part2(testInput2) == 281)


    val input = readInput("Day01")
    "Day 01, part 1: ${part1(input)}".println();
    "Day 01, part 2: ${part2(input)}".println();
}
