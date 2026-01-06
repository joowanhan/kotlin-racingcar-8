package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val threshold = 4

class Car(val name: String) {
	
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
	
	fun maxStep(cars: List<Car>): List<Car> {
		val stepList = cars.map { it.step }
		val maxStep = stepList.max()
		
		return cars.filter { it.step == maxStep }
		
	}
	
}