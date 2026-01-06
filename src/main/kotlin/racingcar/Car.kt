package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val threshold = 4

class Car(val name: String = "") {
	
	var step = 0
	
	fun move() {
		val point = Randoms.pickNumberInRange(0, 9)
		if (point >= threshold) {
			++step
		}
		
	}
	
	fun printStep(): String {
		return "-".repeat(step)
		
	}
	
	fun printWinners(cars: List<Car>) {
		val winners = maxStep(cars).map { it.name }
		
		val winningMessage = winners.joinToString(prefix = "최종 우승자 : ")
		println(winningMessage)
	}
	
	fun maxStep(cars: List<Car>): List<Car> {
		val maxStep = cars.maxOfOrNull { it.step } ?: return emptyList()
		
		return cars.filter { it.step == maxStep }
		
	}
	
}