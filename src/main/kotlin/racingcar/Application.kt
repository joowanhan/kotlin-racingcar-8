package racingcar

import camp.nextstep.edu.missionutils.Console.*
import camp.nextstep.edu.missionutils.Randoms

fun main() {
	// TODO: 프로그램 구현
	val nameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
	val attemptsMessage = "시도할 횟수는 몇 회인가요?"
	val resultMessage = "실행결과"
	
	println(nameMessage)
	val names = readLine().split(",").filter { it.isNotBlank() }.map { it.trim() } // 빈 이름 전처리
	require(names.isNotEmpty()) { "이름이 빈칸으로 입력될 수 없습니다." }
	names.forEach { require(it.length <= 5) { "이름이 5자 초과입니다. (\"$it\" 등)" } }
	val validNames = resolveDuplicateName(names)
	
	
	
	println(attemptsMessage)
	val attempts = readLine().toIntOrNull() ?: throw IllegalArgumentException("Invalid number format")
	require(attempts > 0) { "시도 횟수는 1 이상이어야 합니다." }
	
	val cars = validNames.map { Car(it) }
	
	
	println(resultMessage)
	repeat(attempts) {
		cars.forEach {
			val point = Randoms.pickNumberInRange(0, 9)
			it.move(point)
			println("${it.name} : ${it.printStep()}")
		}
		
	}
	
	println(Car.winningMessage(cars))
	
}

fun resolveDuplicateName(names: List<String>): List<String> {
	val frequency = mutableMapOf<String, Int>() // name, count
	
	return names.map { name ->
		val count = frequency.getOrDefault(name, 0) + 1
		frequency[name] = count
		if (count > 1) {
			"$name(${count - 1})"
		} else {
			name
		}
	}
	
}