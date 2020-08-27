package plugin;

import java.io.File;

import javax.swing.JOptionPane;

import plugin.generator.fmmodel.FMModel;
import plugin.generator.options.GeneratorOptions;
import plugin.generator.options.ProjectOptions;


import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;

/** MagicDraw plugin that performes code generation */
//inicijalizacija plugina
public class OurPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	String pluginDir = null; 
	
	public void init() {
		//JOptionPane.showMessageDialog( null, "Our Plugin DIN init");
		
		pluginDir = getDescriptor().getPluginDirectory().getPath();//C:\Program Files\MagicDraw UML\plugins\pluginDNI
		
		// Creating submenu in the MagicDraw main menu 	
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();		
		manager.addMainMenuConfigurator(new MainMenuConfigurator(getSubmenuActions()));
		
		/** @Todo: load project options (@see myplugin.generator.options.ProjectOptions) from 
		 * ProjectOptions.xml and take ejb generator options */
		
		//ovo treba izmeniti?
		//for test purpose only:
		//GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "ejbclass", "templates", "{0}.java", true, "ejb"); 
		//GeneratorOptions(String outputPath, String templateName,String templateDir, String outputFileName, Boolean overwrite,
		//String filePackage)
		//ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator", ejbOptions);
				
		//ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); //apsolutna putanja
		mainGeneratorOptions();
		modelGeneratorOptions();
		repositoryGeneratorOptions();
		serviceGeneratorOptions();
		serviceImplGeneratorOptions();
		controllerGeneratorOptions();
		dtoGeneratorOptions();
		pomXmlGeneratorOptions();
		applicationYmlGeneratorOptions();
		enumerationGeneratorOptions();
	}

	public void mainGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "mainclass", "templates", "MainApplication.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId());
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("MainGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void modelGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "modelclass", "templates", "{0}.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".model");
		//prouciti da li overwrite ima veze sa
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ModelGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void repositoryGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "repositoryclass", "templates", "{0}Repository.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "repository");
		//prouciti da li overwrite ima veze sa
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepositoryGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
		
	public void serviceGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "serviceclass", "templates", "{0}.java", true, "uns.ftn.mbrs.services"); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void serviceImplGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "serviceimplclass", "templates", "{0}.java", true, "uns.ftn.mbrs.servicesImpl"); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceImplGenerator", generatorOptions);

		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void controllerGeneratorOptions() {																									
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "controllerclass", "templates", "{0}Controller.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "controller"); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ControllerGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
		

	}
	
	public void dtoGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "dtoclass", "templates", "{0}DTO.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "dto"); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("DtoGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
		
	}
	
	public void pomXmlGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs", "pomxml", "templates", "pom.xml", true, ""); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("PomXmlGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void applicationYmlGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/resources", "applicationYml", "templates", "application.yml", true, ""); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ApplicationYmlGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void enumerationGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "enumerationclass", "templates", "{0}.java", true, "application.model");
		//prouciti da li overwrite ima veze sa
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EnumerationGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	

	
	private NMAction[] getSubmenuActions()
	{
	   return new NMAction[]{
			new GenerateAction("Generate"),
	   };
	}
	
	public boolean close() {
		return true;
	}
	
	public boolean isSupported() {				
		return true;
	}
}


