package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.strategy.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
	
	fun run() {
		val names = resolveDuplicateName(InputView.readCarNames())
		val cars = Cars(names.map { Car(it) })
		val attempts = InputView.readAttemptCount()
		
		val movingStrategy = RandomMovingStrategy()
		
		OutputView.printStart()
		repeat(attempts) {
			cars.moveAll(movingStrategy)
			OutputView.printRacingAll(cars.toDtoList())
			
		}
		val winners = cars.extractWinner()
		OutputView.printWinners(winners)
		
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
}