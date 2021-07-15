package by.company.kaliaha.component.material;

public abstract class Material {
	private String material;
	private double coefficient;
	
	public Material(String material, double coefficient) {
		if(material == null || coefficient <= 0) {
			this.material = "";
			this.coefficient = 0;
		} else {
			this.material = material;
			this.coefficient = coefficient;
		}
	}
	
	public String getMaterialName() {
		return material;
	}
	
	public double getCoefficient() {
		return coefficient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Double.valueOf(coefficient).hashCode();
		result = prime * result + material.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Material other = (Material) object;
		if (coefficient != other.coefficient) return false;
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
			   .append("[" + material)
			   .append(": coefficient = " + coefficient + "]");
		return builder.toString();
	}
}