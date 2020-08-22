package plugin.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMOperation extends FMElement{
	
	private String visibility;
	private FMType type;
	private List<FMParameter> parametersIn = new ArrayList<FMParameter>();
	private FMParameter parameterOut;
	
	public FMOperation(String name,String vis, FMType t, FMParameter out, List<FMParameter> in) {
		super(name);
		// TODO Auto-generated constructor stub
		visibility=vis;
		type=t;
		parameterOut=out;
		parametersIn = in;
	}
	
	public void addParametarIn(FMParameter parametar){
		parametersIn.add(parametar);		
	}
	
	public List<FMParameter> getParametersIn() {
		return parametersIn;
	}

	public void setParametersIn(List<FMParameter> parametersIn) {
		this.parametersIn = parametersIn;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public FMType getType() {
		return type;
	}

	public void setType(FMType type) {
		this.type = type;
	}

	public FMParameter getParameterOut() {
		return parameterOut;
	}

	public void setParameterOut(FMParameter parameterOut) {
		this.parameterOut = parameterOut;
	}

	

}
