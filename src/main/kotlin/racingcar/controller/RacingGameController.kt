package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
	
	fun run() {
		val names = resolveDuplicateName(InputView.readCarNames())
		val cars = names.map { Car(it) }
		val attempts = InputView.readAttemptCount()
		
		OutputView.printStart()
		repeat(attempts) {
			cars.forEach { car ->
				racing(car)
				OutputView.printRacing(car.toDto())
			}
			
		}
		val winners = Car.extractWinner(cars)
		OutputView.printWinners(winners)
		
	}
	
	fun racing(car: Car) {
		val point = Randoms.pickNumberInRange(0, 9)
		car.move(point)
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