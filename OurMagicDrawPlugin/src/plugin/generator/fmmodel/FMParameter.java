package plugin.generator.fmmodel;


public class FMParameter extends FMElement{

	private FMType type;
	//private boolean isOut;
	//private boolean isIn;
	
	public FMParameter(String name, FMType t) {
		super(name);
		// TODO Auto-generated constructor stub
		type = t;
	}

	public FMType getType() {
		return type;
	}

	public void setType(FMType type) {
		this.type = type;
	}

}