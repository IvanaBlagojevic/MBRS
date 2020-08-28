package plugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import plugin.generator.fmmodel.FMClass;
import plugin.generator.fmmodel.FMModel;
import plugin.generator.fmmodel.FMProperty;
import plugin.generator.options.GeneratorOptions;

public class DtoImplGenerator extends BasicGenerator {

	public DtoImplGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}
	
	public void generate() {
		
		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		List<FMClass> classes = FMModel.getInstance().getClasses();
		for(FMClass cl : classes)
		{
			Writer out;
			Map<String, Object> context = new HashMap<String, Object>();
			try {
				out = getWriter(cl.getName(), cl.getTypePackage());
				if(out != null)
				{
					context.clear();
					context.put("class", cl);
					context.put("imports", cl.getImportedPackages());
					context.put("properties", cl.getProperties());
					getTemplate().process(context, out);
					out.flush();
				}
			} catch (TemplateException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
	
	

}
