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
	
	private String columnname;
	
	private FMPersistentCharacteristics persistentCharacteristics;
	
	private FMLinkedCharacteristics linkedCharacteristics;
	
	private Boolean isEditable;
	
	private Boolean isReadOnly;
	
	private String label;
	
	private ComponentType component;
	
	
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
	
	
	public String getColumnname() {
		return columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
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
	
	

	public Boolean getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

	public Boolean getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(Boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public ComponentType getComponent() {
		return component;
	}

	public void setComponent(ComponentType component) {
		this.component = component;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
