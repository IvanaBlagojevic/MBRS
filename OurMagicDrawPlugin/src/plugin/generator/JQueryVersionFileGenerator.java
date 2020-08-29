package plugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import plugin.generator.options.GeneratorOptions;

public class JQueryVersionFileGenerator extends BasicGenerator {

	public JQueryVersionFileGenerator(GeneratorOptions generatorOptions) {
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
		
		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			out = getWriter("", "");
			if(out != null)
			{
				context.clear();
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
