package plugin.generator.fmmodel;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FMClass extends FMType {	
	
	private String visibility;
	
	private Boolean create;
	private Boolean update;
	private Boolean delete;

	//Class properties
	private List<FMProperty> FMProperties = new ArrayList<FMProperty>();
	private List<FMOperation> operations = new ArrayList<FMOperation>();
	
	//list of packages (for import declarations) 
	private List<String> importedPackages = new ArrayList<String>();
	
	/** @ToDo: add list of methods */
	
	
	public FMClass(String name, String classPackage, String visibility) {
		super(name, classPackage);		
		this.visibility = visibility;
	}	
	
	public List<FMProperty> getProperties(){
		return FMProperties;
	}
	
	public Iterator<FMProperty> getPropertyIterator(){
		return FMProperties.iterator();
	}
	
	public void addProperty(FMProperty property){
		FMProperties.add(property);		
	}
	
	public int getPropertyCount(){
		return FMProperties.size();
	}
	
	public List<String> getImportedPackages(){
		return importedPackages;
	}

	public Iterator<String> getImportedIterator(){
		return importedPackages.iterator();
	}
	
	public void addImportedPackage(String importedPackage){
		importedPackages.add(importedPackage);		
	}
	
	public int getImportedCount(){
		return FMProperties.size();
	}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public List<FMProperty> getFMProperties() {
		return FMProperties;
	}

	public void setFMProperties(List<FMProperty> fMProperties) {
		FMProperties = fMProperties;
	}

	public List<FMOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<FMOperation> operations) {
		this.operations = operations;
	}

	public void setImportedPackages(List<String> importedPackages) {
		this.importedPackages = importedPackages;
	}

	public Boolean getCreate() {
		return create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "FMClass [visibility=" + visibility + ", create=" + create + ", update=" + update + ", delete=" + delete
				+ ", FMProperties=" + FMProperties + ", operations=" + operations + ", importedPackages="
				+ importedPackages + "]";
	}	

	
	
}
