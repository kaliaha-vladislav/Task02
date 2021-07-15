package by.company.kaliaha.component.material;

public enum ExistingMaterial {
	Steel(new Steel()),
	Rubber(new Rubber()),
	Paper(new Paper()),
	Wood(new Wood());

	private Material material;
	
	ExistingMaterial(Material material) {
		this.material = material;
	}
	
	public Material getInstance() {
		return material;
	}
}