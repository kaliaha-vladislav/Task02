package by.company.kaliaha.runner;

import by.company.kaliaha.component.Color;
import by.company.kaliaha.component.material.ExistingMaterial;
import by.company.kaliaha.component.material.Paper;
import by.company.kaliaha.entity.Ball;
import by.company.kaliaha.entity.Basket;
import by.company.kaliaha.service.Service;
import by.company.kaliaha.util.IncorrectBallDataException;
import by.company.kaliaha.util.IncorrectObjectArgumentException;
import by.company.kaliaha.util.NullBallInBasketException;
import by.company.kaliaha.util.NullBasketException;

public class Runner {

	public static void main(String[] args) 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		Ball ball1 = new Ball(ExistingMaterial.Paper.getInstance(), Color.Black, 2.149);
		Ball ball2 = new Ball(ExistingMaterial.Rubber.getInstance(), Color.Red, 7.543);
		Ball ball3 = new Ball(ExistingMaterial.Wood.getInstance(), Color.Red, 2.543);
		Ball ball4 = new Ball(ExistingMaterial.Steel.getInstance(), Color.Blue, 5.827);
		Ball ball5 = new Ball(ExistingMaterial.Steel.getInstance(), Color.Blue, 10);
		Basket basket = new Basket(1000);
		
		basket.put(ball1);	
		basket.put(ball2);
		basket.put(ball3);
		basket.put(ball4);
		basket.put(ball5);
		System.out.println(basket.toString());

		Service service = new Service();

		System.out.println("Basket weight: " + service.calculateBasketWeight(basket));
		System.out.println("Certain color ball: " + service.countInBasketCertainColorBalls(basket, Color.Red));
		System.out.println("Certain material ball: " + service.countInBasketCertainMaterialBalls(basket, new Paper()));
		System.out.println(service.findInBasketTheHeaviestBall(basket).toString());

	}
}