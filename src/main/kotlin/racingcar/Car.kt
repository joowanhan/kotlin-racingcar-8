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
	
}