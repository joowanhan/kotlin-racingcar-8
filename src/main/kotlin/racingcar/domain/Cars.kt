package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.dto.CarDto

class Cars(val cars: List<Car>) {
	
	fun moveAll() {
		cars.forEach { car ->
			val point = Randoms.pickNumberInRange(0, 9)
			car.move(point)
		}
	}
	
	fun toDtoList(): List<CarDto> {
		return cars.map { car ->
			car.toDto()
		}
		
	}
	
	fun extractWinner(): List<String> {
		val maxStep = cars.maxOfOrNull { car ->
			car.step
		}
		val winners = cars.filter { car -> car.step == maxStep }.map { car -> car.name }
		return winners
	}
	
}