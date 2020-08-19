package plugin;

import java.io.File;

import javax.swing.JOptionPane;

import plugin.generator.options.GeneratorOptions;
import plugin.generator.options.ProjectOptions;


import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;

/** MagicDraw plugin that performes code generation */
//inicijalizacija plugina
public class OurPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	String pluginDir = null; 
	
	public void init() {
		JOptionPane.showMessageDialog( null, "Our Plugin DIN init");
		
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
		modelGeneratorOptions();
	}

	public void modelGeneratorOptions() {
		GeneratorOptions generatorOptions = new GeneratorOptions("c:/temp/mbrs/src/main/java", "modelclass", "templates", "{0}.java", true, "uns.ftn.mbrs.model"); 	
		//true se odnosi na "overwrite", njega treba staviti na false jer zelimo da se promene sacuvaju
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ModelGenerator", generatorOptions);
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


