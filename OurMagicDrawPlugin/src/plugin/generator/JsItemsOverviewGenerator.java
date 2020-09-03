package plugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import plugin.generator.fmmodel.FMClass;
import plugin.generator.fmmodel.FMModel;
import plugin.generator.options.GeneratorOptions;

public class JsItemsOverviewGenerator extends BasicGenerator {

	public JsItemsOverviewGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}
	
	public void generate() {
		try {
			super.generate();
		}catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		for(FMClass cl : FMModel.getInstance().getClasses())
		{
			Writer out;
			Map<String, Object> context = new HashMap<String, Object>();
			
			try {
				out = getWriter(cl.getName(),cl.getTypePackage());
				if(out != null)
				{
					context.clear();
					context.put("classes", FMModel.getInstance().getClasses());
					context.put("class", cl);
					context.put("port", FMModel.getInstance().getPort());
					getTemplate().process(context, out);
					out.flush();
				}
			}catch (IOException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e.getMessage());
			}catch (TemplateException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}
