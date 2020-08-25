package plugin.generator.fmmodel;

public class FMLinkedCharacteristics  {
	
	

	private CascadeType cascade;
	
	private FetchType fetch;
	
	private String mappedBy;
	
	private Boolean orphanRemoval;
	
	private Boolean optional;

	
	private Integer oppositeUpper;
	
	public FMLinkedCharacteristics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FMLinkedCharacteristics(CascadeType cascade, FetchType fetch, String mappedBy, Boolean orphanRemoval,
			Boolean optional) {
		super();
		this.cascade = cascade;
		this.fetch = fetch;
		this.mappedBy = mappedBy;
		this.orphanRemoval = orphanRemoval;
		this.optional = optional;
	}

	public CascadeType getCascade() {
		return cascade;
	}

	public void setCascade(CascadeType cascade) {
		this.cascade = cascade;
	}

	public FetchType getFetch() {
		return fetch;
	}

	public void setFetch(FetchType fetch) {
		this.fetch = fetch;
	}

	public String getMappedBy() {
		return mappedBy;
	}

	public void setMappedBy(String mappedBy) {
		this.mappedBy = mappedBy;
	}

	public Boolean getOrphanRemoval() {
		return orphanRemoval;
	}

	public void setOrphanRemoval(Boolean orphanRemoval) {
		this.orphanRemoval = orphanRemoval;
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public Integer getOppositeUpper() {
		return oppositeUpper;
	}

	public void setOppositeUpper(Integer oppositeUpper) {
		this.oppositeUpper = oppositeUpper;
	}

	
	

}
