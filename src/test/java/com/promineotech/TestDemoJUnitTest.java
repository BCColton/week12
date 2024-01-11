package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	public static Stream<Arguments> argumentsForAddPositive() {
		
		List<Arguments> args = new ArrayList<>();
		
		args.add(Arguments.arguments(1,2,3,false));
		args.add(Arguments.arguments(1,0,1,true));
		args.add(Arguments.arguments(0,1,1,true));
		args.add(Arguments.arguments(-1,12,11,true));
		args.add(Arguments.arguments(12,-1,11,true));
		
		return args.stream();
	}
	
	@Test
	protected void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(33, 66)).isEqualTo(99);
	}
	
	//Test for all 4 general test cases for the method isBedTime.
	@Test
	protected void assertThatItIsBedTime() {
		assertThat(testDemo.isBedTime(21, true)).isTrue();
		assertThat(testDemo.isBedTime(23, false)).isTrue();
		assertThat(testDemo.isBedTime(0, false)).isFalse();
		assertThat(testDemo.isBedTime(0, true)).isFalse();
	}
	
	@Test
	protected void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = Mockito.spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}

}
