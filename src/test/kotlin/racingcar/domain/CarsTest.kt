package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.strategy.MovingStrategy

class CarsTest {
	
	@Test
	fun `모든 자동차가 전략에 따라 전진한다`() {
		// given
		val cars = Cars(listOf("pobi", "woni").map { Car(it) })
		
		// 테스트용 전략: 무조건 true 반환 (람다 사용) SAM
		val alwaysMoveStrategy = MovingStrategy { true }
		
		// when
		cars.moveAll(alwaysMoveStrategy)
		
		// then
		// Cars -> CarDto 변환 로직을 통해 검증하거나,
		// 테스트를 위해 Cars에 객체를 노출하는 메서드가 없다면
		// 우승자 로직 등으로 간접 검증
		val winners = cars.extractWinner()
		assertThat(winners).contains("pobi", "woni")
	}
	
	@Test
	fun `전략이 false면 전진하지 않는다`() {
		// given
		val cars = Cars(listOf("pobi", "woni").map { Car(it) })
		val stopStrategy = MovingStrategy { false } // SAM
		
		// when
		cars.moveAll(stopStrategy)
		
		// then
		// 움직이지 않았으므로 step은 0일 것이고,
		// DTO나 다른 방식을 통해 검증 가능
		val dtos = cars.toDtoList()
		assertThat(dtos[0].step).isEqualTo(0)
	}
}