package racingcar

fun main() {
	// TODO: 프로그램 구현
	val names = camp.nextstep.edu.missionutils.Console.readLine().split(",")
	val attempts = camp.nextstep.edu.missionutils.Console.readLine().toIntOrNull()
		?: throw IllegalArgumentException("Invalid number format")
	
	val cars = names.map { Car(it) }
	
}
