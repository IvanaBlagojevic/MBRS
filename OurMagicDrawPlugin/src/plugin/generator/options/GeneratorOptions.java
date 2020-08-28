package plugin.generator.options;

/** GeneratorOptions: options used for code generation. Every generator (ejb generator, forms generator etc) should
 * have one instance of this class */
//inicijalizovali smo u klasi OurPlugin GeneratorOptions("c:/temp", "ejbclass", "templates", "{0}.java", true, "ejb");
public class GeneratorOptions  {
	private String outputPath; //1
	private String templateName;
	private String templateDir;
	private String outputFileName;//3
	private Boolean overwrite;
	private String filePackage;//2
	//C:\temp\mbrs\src\main\java \com\example\mbrs\repository
	//c:/temp/mbrs/src/main/javacom.example.mbrs.repository
	public GeneratorOptions(String outputPath, String templateName,
			String templateDir, String outputFileName, Boolean overwrite,
			String filePackage) {
		super();
		this.outputPath = outputPath;
		this.templateName = templateName;
		this.templateDir = templateDir;
		this.outputFileName = outputFileName;
		this.overwrite = overwrite;
		this.filePackage = filePackage;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public Boolean getOverwrite() {
		return overwrite;
	}

	public void setOverwrite(Boolean overwrite) {
		this.overwrite = overwrite;
	}

	public String getFilePackage() {
		return filePackage;
	}

	public void setFilePackage(String filePackage) {
		this.filePackage = filePackage;
	}
	
	
}
