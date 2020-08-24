package plugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import plugin.generator.fmmodel.FMClass;
import plugin.generator.fmmodel.FMModel;
import plugin.generator.options.GeneratorOptions;

public class MainGenerator extends BasicGenerator {

	public MainGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}

	public void generate() {
		
		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		FMClass cl = FMModel.getInstance().getClasses().get(0);
		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		String name = "MainApplication";
		
		try {
			out = getWriter(cl.getName(), cl.getTypePackage());
			if(out != null)
			{
				context.clear();
				context.put("package", cl.getTypePackage());
				context.put("name", name);
				getTemplate().process(context, out);
				out.flush();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
