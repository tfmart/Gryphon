internal sealed class CalculatorError: Exception() {
	class InvalidCharacter: CalculatorError()
	class MultipleCharacters: CalculatorError()
	class NilInput: CalculatorError()
}

internal sealed class OtherError: Exception() {
	class OneInt(val int: Int): OtherError()
	class TwoInts(val int: Int, val int2: Int): OtherError()
	class IntAndString(val int: Int, val string: String): OtherError()
}

internal enum class NoInheritances {
	FOO_BAR,
	BAR_BAZ;

	companion object {
		operator fun invoke(rawValue: String): NoInheritances? {
			return when (rawValue) {
				"foo-bar" -> NoInheritances.FOO_BAR
				"barBaz" -> NoInheritances.BAR_BAZ
				else -> null
			}
		}
	}

	val rawValue: String
		get() {
			return when (this) {
				NoInheritances.FOO_BAR -> "foo-bar"
				NoInheritances.BAR_BAZ -> "barBaz"
			}
		}
}

internal enum class WithMembers {
	FOO_BAR,
	BAZ;

	internal fun a() {
	}

	internal fun b() {
	}
}

internal fun throwingFunc() {
	throw CalculatorError.InvalidCharacter()
}

internal fun otherThrowingFunc() {
	throwingFunc()
}
