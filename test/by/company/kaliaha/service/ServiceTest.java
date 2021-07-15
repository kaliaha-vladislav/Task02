package by.company.kaliaha.service;

import org.junit.Assert;
import org.junit.Test;

import by.company.kaliaha.component.Color;
import by.company.kaliaha.component.material.ExistingMaterial;
import by.company.kaliaha.entity.Ball;
import by.company.kaliaha.entity.Basket;
import by.company.kaliaha.service.Service;
import by.company.kaliaha.util.IncorrectBallDataException;
import by.company.kaliaha.util.IncorrectObjectArgumentException;
import by.company.kaliaha.util.NullBallInBasketException;
import by.company.kaliaha.util.NullBasketException;

public class ServiceTest {
	private Basket createBasketWithBalls() {
		Ball ball1 = new Ball(ExistingMaterial.Paper.getInstance(), Color.Black, 2.149);
		Ball ball2 = new Ball(ExistingMaterial.Rubber.getInstance(), Color.Red, 7.543);
		Ball ball3 = new Ball(ExistingMaterial.Wood.getInstance(), Color.Red, 2.543);
		Ball ball4 = new Ball(ExistingMaterial.Steel.getInstance(), Color.Blue, 5.827);
		Basket basket = new Basket(1000);
		basket.put(ball1);	
		basket.put(ball2);
		basket.put(ball3);
		basket.put(ball4);
		return basket;
	}
	
	@Test
	public void countInBasketCertainColorBallsTest_Correct_Data() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Basket basket = createBasketWithBalls();
		Service service = new Service();
		int expected = 2;
		int actual = service.countInBasketCertainColorBalls(basket, Color.Red);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = NullBasketException.class)
	public void countInBasketCertainColorBallsTest_Null_Basket() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Service service = new Service();
		int expected = 2;
		int actual = service.countInBasketCertainColorBalls(null, Color.Red);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IncorrectObjectArgumentException.class)
	public void countInBasketCertainColorBallsTest_Null_Color() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Basket basket = createBasketWithBalls();
		Service service = new Service();
		int expected = 2;
		int actual = service.countInBasketCertainColorBalls(basket, null);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void countInBasketCertainMaterialBallsTest_Correct_Arguments() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Basket basket = createBasketWithBalls();
		Service service = new Service();
		int expected = 1;
		int actual = service.countInBasketCertainMaterialBalls(basket, ExistingMaterial.Paper.getInstance());
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = NullBasketException.class)
	public void countInBasketCertainMaterialBallsTest_Null_Basket() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Service service = new Service();
		int expected = 1;
		int actual = service.countInBasketCertainMaterialBalls(null, ExistingMaterial.Paper.getInstance());
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = IncorrectObjectArgumentException.class)
	public void countInBasketCertainMaterialBallsTest_Null_Argument() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Basket basket = createBasketWithBalls();
		Service service = new Service();
		int expected = 1;
		int actual = service.countInBasketCertainMaterialBalls(basket, null);
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void calculateBasketWeightTest_Correct_Argument() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		Basket basket = createBasketWithBalls();
		Service service = new Service();
		double expected = 1374.711;
		double actual = service.calculateBasketWeight(basket);
		Assert.assertEquals(expected, actual, 0.0001);
	}
	
	@Test (expected = NullBasketException.class)
	public void calculateBasketWeightTest_Null_Basket() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		Service service = new Service();
		double expected = 0;
		double actual = service.calculateBasketWeight(null);
		Assert.assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void findInBasketTheHeaviestBallTest_Correct_Argument() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		Basket basket = createBasketWithBalls();
		Ball ball = new Ball(ExistingMaterial.Steel.getInstance(), Color.Blue, 10);
		basket.put(ball);
		Service service = new Service();
		Ball expected = ball;
		Ball actual = service.findInBasketTheHeaviestBall(basket);
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = NullBasketException.class)
	public void findInBasketTheHeaviestBallTest() 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		Service service = new Service();
		int expected = 0;
		Ball actual = service.findInBasketTheHeaviestBall(null);
		Assert.assertEquals(expected, actual);
	}
}