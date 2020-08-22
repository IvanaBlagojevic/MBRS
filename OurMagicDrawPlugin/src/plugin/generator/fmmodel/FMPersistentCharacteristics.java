package plugin.generator.fmmodel;

public class FMPersistentCharacteristics{
	
	
	private Boolean key;
	private Boolean unique;
	private Integer length;
	private Integer precision;
	private GenerationStrategy generatedValue;
	
	
	


	public FMPersistentCharacteristics(Boolean key, Boolean unique, Integer length, Integer precision,
			GenerationStrategy generatedValue) {
		super();
		this.key = key;
		this.unique = unique;
		this.length = length;
		this.precision = precision;
		this.generatedValue = generatedValue;
	}


	public FMPersistentCharacteristics() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Boolean getKey() {
		return key;
	}


	public void setKey(Boolean key) {
		this.key = key;
	}


	public Boolean getUnique() {
		return unique;
	}


	public void setUnique(Boolean unique) {
		this.unique = unique;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
	}


	public Integer getPrecision() {
		return precision;
	}


	public void setPrecision(Integer precision) {
		this.precision = precision;
	}


	public GenerationStrategy getGeneratedValue() {
		return generatedValue;
	}


	public void setGeneratedValue(GenerationStrategy generatedValue) {
		this.generatedValue = generatedValue;
	}
	
	
	

}
