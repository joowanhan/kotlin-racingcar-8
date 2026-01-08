package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.strategy.MovingStrategy
import racingcar.dto.CarDto

class Cars(val cars: List<Car>) {
	
	fun moveAll(movingStrategy: MovingStrategy) {
		cars.forEach { car ->
			car.move(movingStrategy)
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