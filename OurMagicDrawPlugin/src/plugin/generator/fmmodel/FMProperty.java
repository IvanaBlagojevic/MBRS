package plugin.generator.fmmodel;


import plugin.generator.fmmodel.FMElement;

public class FMProperty extends FMElement  {
	//Property type
	private FMType type;
	// Property visibility (public, private, protected, package)
	private String visibility;
	//Multiplicity (lower value)
	private Integer lower;
	//Multiplicity (upper value) 
	//konvencija: -1 znači *
	private Integer upper;
	
	private Boolean getter;
	
	private Boolean setter;
	
	private FMPersistentCharacteristics persistentCharacteristics = new FMPersistentCharacteristics();
	
	private FMLinkedCharacteristics linkedCharacteristics = new FMLinkedCharacteristics();
	
	
	/** @ToDo: Add length, precision, unique... whatever is needed for ejb class generation
	 * Also, provide these meta-attributes or tags in the modeling languange metaclass or 
	 * stereotype */

	
	public FMProperty(String name, FMType type, String visibility, int lower, int upper) {
		super(name);
		this.type = type;
		this.visibility = visibility;
		
		this.lower = lower;
		this.upper = upper;		
	}
	
	public FMType getType() {
		return type;
	}
	public void setType(FMType type) {
		this.type = type;
	}
	
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	public Boolean getGetter() {
		return getter;
	}

	public void setGetter(Boolean getter) {
		this.getter = getter;
	}

	

	public Boolean getSetter() {
		return setter;
	}

	public void setSetter(Boolean setter) {
		this.setter = setter;
	}

	public FMPersistentCharacteristics getPersistentCharacteristics() {
		return persistentCharacteristics;
	}

	public void setPersistentCharacteristics(FMPersistentCharacteristics persistentCharacteristics) {
		this.persistentCharacteristics = persistentCharacteristics;
	}

	public FMLinkedCharacteristics getLinkedCharacteristics() {
		return linkedCharacteristics;
	}

	public void setLinkedCharacteristics(FMLinkedCharacteristics linkedCharacteristics) {
		this.linkedCharacteristics = linkedCharacteristics;
	}

	@Override
	public String toString() {
		return "FMProperty [type=" + type + ", visibility=" + visibility + ", lower=" + lower + ", upper=" + upper
				+ ", getter=" + getter + ", Setter=" + setter + ", persistentCharacteristics="
				+ persistentCharacteristics + ", linkedCharacteristics=" + linkedCharacteristics + "]";
	}

	
	
	
}
