package by.company.kaliaha.entity;

import java.io.Serializable;

import by.company.kaliaha.component.Color;
import by.company.kaliaha.component.material.Material;
import by.company.kaliaha.component.material.NullMaterial;

@SuppressWarnings("serial")
public class Ball implements Serializable {
	private static int instanceId = 0;
	
	private int id;
	private Material material;
	private Color color;
	private double height;
	
	@SuppressWarnings("unused")
	private Ball() {}
	
	public Ball(Material material, Color color,  double height) {
		id = ++instanceId;
		if(material == null || color == null || height <= 0) {
			mistakeBall();
		} else {
			this.material = material;
			this.height = height;
			this.color = color;
		}	
	}
	
	private void mistakeBall() {
		this.material = new NullMaterial();
		this.color = Color.Transparent;
		height = 0;
	}
	
	public boolean setMaterial(Material material) {
		boolean isSet = false;
		if(material != null && !(material instanceof NullMaterial)) {
			this.material = material;
			isSet = true;
		}
		return isSet;
	}
	
	public boolean setColor(Color color) {
		boolean isSet = false;
		if(color != null && color != Color.Transparent) {
			this.color = color;
			isSet = true;
		}
		return isSet;
	}
	
	public boolean setHeight(double height) {
		boolean isSet = false;
		if(height > 0) {
			this.height = height;
			isSet = true;
		}
		return isSet;
	}
	
	public int getId() {
		return id;
	}
	
	public String getMaterial() {
		return material.getMaterialName();
	}
	
	public Color getColor() {
		return color;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeigth() {
		return (height > 0 && !(material instanceof NullMaterial) && color != Color.Transparent) ? calculateWeight() : 0;
	}
	
	private double calculateWeight() {
		double ballSuraface = calculateBallSurface();
		double weight = ballSuraface * material.getCoefficient();
		return (double)Math.round(weight * 1000) / 1000;
	}
	
	private double calculateBallSurface() {
		double ballSurface = 4 * Math.PI * Math.pow(height / 2, 2);
		return (double)Math.round(ballSurface * 1000) / 1000;
	}
	
	public double getVolume() {
		return (height > 0 && !(material instanceof NullMaterial) && color != Color.Transparent) ? calculateVolume() : 0;
	}
	
	private double calculateVolume() {
		double ballVolume = 4/3 * Math.PI * Math.pow(height / 2, 3);
		return (double)Math.round(ballVolume * 1000) / 1000;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color.hashCode();
		result = prime * result + Double.valueOf(height).hashCode();
		result = prime * result + material.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Ball other = (Ball) obj;
		if (color != other.color) return false;
		if (height != other.height)	return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(getClass().getSimpleName())
			   .append("[id: " + getId() + ",")
			   .append(" material: " + getMaterial() + ",")
			   .append(" color: " + color + ",")
			   .append(" weighs: " + getWeigth() + ",")
			   .append(" height: " + height + ",")
			   .append(" volume: " + getVolume()+ "]");
		return builder.toString();
	}
}