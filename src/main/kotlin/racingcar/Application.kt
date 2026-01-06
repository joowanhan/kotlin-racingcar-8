package racingcar

fun main() {
	// TODO: 프로그램 구현
	val nameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
	val attemptsMessage = "시도할 횟수는 몇 회인가요?"
	val resultMessage = "실행결과"
	println(nameMessage)
	val names = camp.nextstep.edu.missionutils.Console.readLine().split(",")
	
	println(attemptsMessage)
	val attempts = camp.nextstep.edu.missionutils.Console.readLine().toIntOrNull()
		?: throw IllegalArgumentException("Invalid number format")
	
	val cars = names.map { Car(it) }
	
	println(resultMessage)
	for (i in 1 .. attempts) {
		cars.onEach { it.move() }.forEach { println("${it.name} : ${it.printStep()}") }
		
	}
	
}
