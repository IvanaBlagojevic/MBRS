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

public class JsFormGenerator extends BasicGenerator {

	public JsFormGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}

	public void generate() {
		try {
			super.generate();
		}catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		List<FMClass> classes = FMModel.getInstance().getClasses();
		for(FMClass cl : classes)
		{
			if(cl.getUiAdd())
			{
				List<FMProperty> editProperties = new ArrayList<FMProperty>();
				for(FMProperty p : cl.getProperties())
				{
					if(p.getIsEditable())
					{
						editProperties.add(p);
						
					}
					
				}
				
				Writer out;
				Map<String, Object> context = new HashMap<String, Object>();
				try {
					out = getWriter(cl.getName(), cl.getTypePackage());
					if(out != null)
					{
						context.clear();
						context.put("classes", FMModel.getInstance().getClasses());
						context.put("class", cl);
						context.put("port", FMModel.getInstance().getPort());
						context.put("properties", editProperties);
						getTemplate().process(context, out);
						out.flush();
					}
				}catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		}
	}
}
