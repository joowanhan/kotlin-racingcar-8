package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.strategy.MovingStrategy

class CarTest {
	
	@Test
	fun `이름이 5글자가 넘어가면 예외 발생`() {
		// given
		val name = "123456"
		// when, then
		assertThatThrownBy { Car(name) }.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("이름이 5자 초과입니다.")
		
	}
	
	@Test
	fun `전진 되는지 테스트`() {
		// given
		val trueStrategy = MovingStrategy { true }
		val carTrue = Car("true")
		// when
		carTrue.move(trueStrategy)
		// then
		assertThat(carTrue.step).isEqualTo(1)
	}
	
	@Test
	fun `전진 안되는지 테스트`() {
		// given
		val falseStrategy = MovingStrategy { false }
		val carFalse = Car("false")
		// when
		carFalse.move(falseStrategy)
		// then
		assertThat(carFalse.step).isEqualTo(0)
	}
	
}