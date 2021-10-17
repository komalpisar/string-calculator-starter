package calculator;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class StringCalculatorShould {

	//1. take 0,1,2 number and sum 
		@Test
		public void sumsEmptyStringTo0() {
			assertThat(StringCalculator.add(""), is(0));
		}

		@Test
		public void sumsSingleNumberToItself() {
			assertThat(StringCalculator.add("5"), is(5));
			assertThat(StringCalculator.add("42"), is(42));
		}

		@Test
		public void sumsTwoNumbersSeperatedByComma() {
			assertThat(StringCalculator.add("1,2"), is(3));
			assertThat(StringCalculator.add("1,3"), is(4));
		}

		
		@Test
		public void sumsThreeNumbersSeperatedByComma() {
			assertThat(StringCalculator.add("1,2,3"), is(6));
		}
}