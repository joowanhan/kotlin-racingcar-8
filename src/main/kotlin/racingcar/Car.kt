package racingcar

const val threshold = 4

class Car(name: String) {
	
	var step = 0
	
	fun move() {
		val point = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)
		if (point >= threshold) {
			++step
		}
		
	}
	
}