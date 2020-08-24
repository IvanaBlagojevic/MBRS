package plugin;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import plugin.analyzer.AnalyzeException;
import plugin.analyzer.ModelAnalyzer;
import plugin.generator.ApplicationYmlGenerator;
import plugin.generator.ControllerGenerator;
import plugin.generator.DtoGenerator;
import plugin.generator.EJBGenerator;
import plugin.generator.MainGenerator;
import plugin.generator.ModelGenerator;
import plugin.generator.PomXmlGenerator;
import plugin.generator.RepositoryGenerator;
import plugin.generator.fmmodel.FMModel;
import plugin.generator.options.GeneratorOptions;
import plugin.generator.options.ProjectOptions;

/** Action that activate code generation */
//ova klasa opisuje akciju koja se obavlja nakon klika Generate u menibaru
@SuppressWarnings("serial")
class GenerateAction extends MDAction{
	
	
	public GenerateAction(String name) {			
		super("", name, null, null);		
	}

	public void actionPerformed(ActionEvent evt) {
		
		if (Application.getInstance().getProject() == null) return;
		Package root = Application.getInstance().getProject().getModel();
		
		if (root == null) return;
	
		ModelAnalyzer analyzer = null;	
		GeneratorOptions generatorOptions = null;
		try {
			analyzer = new ModelAnalyzer(root, "");
			analyzer.prepareModel();
			generateMain(analyzer, root, generatorOptions);
			generateModel(analyzer, root, generatorOptions);
			generateRepository(analyzer, root, generatorOptions);
			generateController(analyzer, root, generatorOptions);
			generateDTO(analyzer, root, generatorOptions);
			generatePomXml(analyzer, root, generatorOptions);
			generateApplicationYml(analyzer, root, generatorOptions);
			exportToXml();
		} catch (AnalyzeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 
		/*
		 * ModelAnalyzer analyzer = new ModelAnalyzer(root, "ejb");	
		
		try {
			analyzer.prepareModel();	
			GeneratorOptions go = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EJBGenerator");			
			EJBGenerator generator = new EJBGenerator(go);
			generator.generate();
			
			JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: " + go.getOutputPath() +
					                         ", package: " + go.getFilePackage());
			exportToXml();
		} catch (AnalyzeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} /**  @ToDo: Also call other generators */ 
	}
	
	public void generateMain(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) 
			throws AnalyzeException {
		//"application"
		analyzer = new ModelAnalyzer(root, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId());
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("MainGenerator");
		MainGenerator mainGenerator = new MainGenerator(generatorOptions);
		mainGenerator.generate();
	}
	
	public void generateModel(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".model");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ModelGenerator");
		ModelGenerator modelGenerator = new ModelGenerator(generatorOptions);
		modelGenerator.generate();
	}
	
	public void generateRepository(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions)
			throws AnalyzeException {
		analyzer = new ModelAnalyzer(root, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".repository");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("RepositoryGenerator");
		RepositoryGenerator modelGenerator = new RepositoryGenerator(generatorOptions);
		modelGenerator.generate();
		
	}
	
	public void generateController(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException
	{
		analyzer = new ModelAnalyzer(root, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".controller");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ControllerGenerator");
		ControllerGenerator controllerGenerator = new ControllerGenerator(generatorOptions);
		controllerGenerator.generate();
	}
	
	public void generateDTO(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException
	{
		analyzer = new ModelAnalyzer(root, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId()+ ".dto");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("DtoGenerator");
		DtoGenerator dtoGenerator = new DtoGenerator(generatorOptions);
		dtoGenerator.generate();
	}
	
	public void generatePomXml(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException
	{
		analyzer = new ModelAnalyzer(root, "");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("PomXmlGenerator");
		PomXmlGenerator pomGenerator = new PomXmlGenerator(generatorOptions);
		pomGenerator.generate();
	}
	
	public void generateApplicationYml(ModelAnalyzer analyzer, Package root, GeneratorOptions generatorOptions) throws AnalyzeException
	{
		analyzer = new ModelAnalyzer(root, "");
		analyzer.prepareModel();
		generatorOptions = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ApplicationYmlGenerator");
		ApplicationYmlGenerator appYmlGenerator = new ApplicationYmlGenerator(generatorOptions);
		appYmlGenerator.generate();
	}
	
	private void exportToXml() {
		//JOptionPane.showMessageDialog(null, FMModel.getInstance().getGroupId() + "." + FMModel.getInstance().getArtifactId());
		if (JOptionPane.showConfirmDialog(null, "Do you want to save FM Model?") == 
			JOptionPane.OK_OPTION)
		{	
			JFileChooser jfc = new JFileChooser();
			if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
			
				XStream xstream = new XStream(new DomDriver());
				BufferedWriter out;		
				try {
					out = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(fileName), "UTF8"));					
					xstream.toXML(FMModel.getInstance().getClasses(), out);
					xstream.toXML(FMModel.getInstance().getEnumerations(), out);
					
					
				} catch (UnsupportedEncodingException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				}		             
			}
		}	
	}	  

}