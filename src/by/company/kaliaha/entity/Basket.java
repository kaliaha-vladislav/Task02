package by.company.kaliaha.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import by.company.kaliaha.component.Color;

@SuppressWarnings("serial")
public class Basket implements Serializable, Iterable <Ball> {
	private ArrayList<Ball> content;
	private double volume;
	
	private Basket() {
		content = new ArrayList<Ball>();
	}
	
	public Basket(double volume) {
		this();
		if(volume <= 0) {
			this.volume = 0;
		} else {
			this.volume = volume;
		}
	}
	
	public boolean setVolume(double volume) {
		boolean isSet = false;
		if(volume > 0) {
			clearContent();
			this.volume = volume;
			isSet = true;
		}
		return isSet;
	}
	
	public void clearContent() {
		content.clear();
	}
	
	public boolean put(Ball ball) {
		boolean isPut = false;	
		if(checkBall(ball) && volume - filledVolume() >= ball.getVolume()) {		
			isPut = content.add(ball);
		}
		return isPut;
	}
	
	private boolean checkBall(Ball ball) {
		boolean isCheckedBall = false;
		if(ball != null && !ball.getMaterial().equals("") && ball.getColor() != Color.Transparent && ball.getHeight() != 0){									
			isCheckedBall = true;
		}
		return isCheckedBall;
	}
	
	public double filledVolume() {
		double totalVolume = 0;
		for (Ball currentBall : content) {
			totalVolume += currentBall.getVolume();
		}
		return totalVolume;
	}
	
	public boolean remove(Ball ball) {
		return content.remove(ball);
	}
	
	public double getVolume() {
		return volume;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + content.hashCode();
		result = prime * result + Double.valueOf(volume).hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;			
		Basket other = (Basket) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (volume != other.volume)	return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName())
			   .append(" [free volume: " + (volume - filledVolume()) + "]")
			   .append(" contains the following items:\n");
		for(Ball ball : content) {
			builder.append("  "+ ball.toString() + "\n");
		}
		return builder.toString();
	}

	@Override
	public Iterator<Ball> iterator() {
		Iterator<Ball> iterator = new Iterator<Ball>() {
			private Iterator<Ball> currentIterator = content.iterator();
			private Ball currentBall;
			
			@Override
			public boolean hasNext() {
				return currentIterator.hasNext();
			}

			@Override
			public Ball next() {
				currentBall = currentIterator.next();
				return currentBall;
			}
			public void remove() {
				currentIterator.remove();
			}
		};
		return iterator;
	}
}