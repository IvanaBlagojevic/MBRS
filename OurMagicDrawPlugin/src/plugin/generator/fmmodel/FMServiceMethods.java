package plugin.generator.fmmodel;

public class FMServiceMethods extends FMElement{
	
	private Boolean value;
	/*private Boolean update;
	private Boolean delete;
	//private Boolean read;*/

	public FMServiceMethods(String name, Boolean value) {
		super(name);
		// TODO Auto-generated constructor stub
		/*this.create = create;
		this.update = update;
		this.delete = delete;*/
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	

}
