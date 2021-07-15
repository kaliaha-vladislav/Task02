package by.company.kaliaha.service;

import by.company.kaliaha.component.Color;
import by.company.kaliaha.component.material.Material;
import by.company.kaliaha.entity.Ball;
import by.company.kaliaha.entity.Basket;
import by.company.kaliaha.util.IncorrectBallDataException;
import by.company.kaliaha.util.IncorrectObjectArgumentException;
import by.company.kaliaha.util.NullBallInBasketException;
import by.company.kaliaha.util.NullBasketException;

public class Service {
	public Service() {}
		
	public int countInBasketCertainColorBalls(Basket basket, Color color) 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {
		checkBasket(basket);
		checkObject(color, "Color cannot be null");
		
		int countColorBalls = 0;		
		for(Ball currentBall : basket) {
			if (currentBall.getColor().equals(color)) {
				++countColorBalls;
			}
		}
		return countColorBalls;
	}
	
	private void checkBasket(Basket basket) throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		if(basket == null) {
			throw new NullBasketException("Basket cannot be null");
		}
		for(Ball ball : basket) {
			checkBall(ball);
		}
	}
	
	private void checkBall(Ball ball) throws NullBallInBasketException, IncorrectBallDataException {
		if(ball == null) {
			throw new NullBallInBasketException("Ball int baset cannot be null");
		}
		if(ball.getMaterial() == "" || ball.getColor() == Color.Transparent || ball.getHeight() == 0) {
			throw new IncorrectBallDataException("Ball data in basket is incorrect");
		}
	}
	
	private void checkObject(Object object, String message) throws IncorrectObjectArgumentException {
		if(object == null) {
			throw new IncorrectObjectArgumentException(message);
		}
	}
	
	public int countInBasketCertainMaterialBalls(Basket basket, Material material)
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException, IncorrectObjectArgumentException {		
		checkBasket(basket);
		checkObject(material, "Material cannot be null");
		
		int countCertainMaterial = 0;
		for(Ball currentBall : basket) {		
			if (currentBall.getMaterial().equals(material.getMaterialName())) {
				++countCertainMaterial;
			}
		}
		return countCertainMaterial;
	}
	
	public double calculateBasketWeight(Basket basket) 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {	
		checkBasket(basket);
		
		double totalWeight = 0;		
		for(Ball currentBall : basket) {		
			totalWeight += currentBall.getWeigth();
		}
		return totalWeight;
	}
	
	public Ball findInBasketTheHeaviestBall(Basket basket) 
			throws NullBasketException, NullBallInBasketException, IncorrectBallDataException {
		checkBasket(basket);
		
		double bigWeight = Double.MIN_VALUE;
		Ball theHeaviestBall = null;	
		for (Ball currentBall : basket) {
			if (currentBall.getWeigth() > bigWeight) {
				bigWeight = currentBall.getWeigth();
				theHeaviestBall = currentBall;
			}
		}		
		return theHeaviestBall;	
	}
}