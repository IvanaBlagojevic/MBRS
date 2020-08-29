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
		
		mainGeneratorOptions();
		modelGeneratorOptions();
		modelImplGeneratorOptions();
		repositoryGeneratorImplOptions();
		serviceGeneratorOptions();
		serviceImplGeneratorOptions();
		repositoryGeneratorOptions();
		controllerGeneratorImplOptions();
		controllerGeneratorOptions();
		dtoGeneratorOptions();
		dtoImplGeneratorOptions();
		pomXmlGeneratorOptions();
		applicationYmlGeneratorOptions();
		enumerationGeneratorOptions();
		jQueryMinfileGeneratorOptions();
		jQueryVersionFileGeneratorOptions();
		htmlIndexGeneratorOptions();
		HomePageJsGeneratorOptions();
		htmlItemsOverviewOptions();
		htmlFormGeneratorOptions();
		jsFormGeneratorOptions();

	}

	public void mainGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "mainclass", "templates", "MainApplication.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId());
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("MainGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void modelGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "modelclass", "templates", "{0}.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ModelGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void modelImplGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "modelImplclass", "templates", "{0}Impl.java", false, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".modelImpl");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ModelImplGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void repositoryGeneratorImplOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "repositoryImplclass", "templates", "{0}ImplRepository.java", false, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "repositoryImpl");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepositoryImplGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
		
	public void serviceGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "serviceclass", "templates", "{0}Service.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "services"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void serviceImplGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "serviceimplclass", "templates", "{0}ServiceImpl.java", false, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "serviceImpl"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceImplGenerator", generatorOptions);

		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void repositoryGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "repositoryclass", "templates", "{0}Repository.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "repository");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepositoryGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void controllerGeneratorImplOptions() {																									
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "controllerImplclass", "templates", "{0}ImplController.java", false, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "controllerImpl"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ControllerImplGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void controllerGeneratorOptions() {																									
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "controllerclass", "templates", "{0}Controller.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "controller"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ControllerGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void dtoGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "dtoclass", "templates", "{0}DTO.java", true, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "dto"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("DtoGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());	
	}
	
	public void dtoImplGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "dtoImplclass", "templates", "{0}ImplDTO.java", false, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ "dtoImpl"); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("DtoImplGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
		
	}
	
	public void pomXmlGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs", "pomxml", "templates", "pom.xml", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("PomXmlGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void applicationYmlGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/resources", "applicationYml", "templates", "application.yml", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ApplicationYmlGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	

	public void enumerationGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "enumerationclass", "templates", "{0}.java", true, FMModel.getInstance().getArtifactId()+ "model");
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EnumerationGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void jQueryMinfileGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent", "jQueryMinJs", "templates", "jquery.min.js", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("JQueryMinFileGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void jQueryVersionFileGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent", "jqueryVersion", "templates", "jquery-3.3.1.min.js", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("JQueryVersionFileGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void htmlIndexGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent", "html_index", "templates", "index.html", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("HtmlIndexGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void HomePageJsGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent/js", "indexJs", "templates", "index.js", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("HomePageJsGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void htmlItemsOverviewOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent", "html_items_overview", "templates",   "{0}.html", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("HtmlItemsOverviewGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void htmlFormGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent", "html_form", "templates",   "{0}Form.html", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("HtmlFormGenerator", generatorOptions);
		generatorOptions.setTemplateDir(pluginDir + File.separator + generatorOptions.getTemplateDir());
	}
	
	public void jsFormGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/FrontContent/js", "formJs", "templates",   "{0}Form.js", true, ""); 	
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("JsFormGenerator", generatorOptions);
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
	
private static String firstCharToLowerCase(String str) {
        
        if(str == null || str.length() == 0)
            return "";
        
        if(str.length() == 1)
            return str.toLowerCase();
        
        char[] chArr = str.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);
        
        JOptionPane.showMessageDialog(null, "Nakon smanjivanja: " + new String(chArr));
        return new String(chArr); 
    }
}


