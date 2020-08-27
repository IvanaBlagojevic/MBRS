package plugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.commons.collections.map.HashedMap;

import freemarker.template.TemplateException;
import plugin.generator.fmmodel.FMModel;
import plugin.generator.options.GeneratorOptions;

public class PomXmlGenerator extends BasicGenerator{

	public PomXmlGenerator(GeneratorOptions generatorOptions) {
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
				context.put("groupId", FMModel.getInstance().getGroupId());
				context.put("artifactId", FMModel.getInstance().getArtifactId());
				context.put("version", FMModel.getInstance().getVersion());
				context.put("javaVersion", FMModel.getInstance().getJavaVersion());
				getTemplate().process(context, out);
				out.flush();
			}
		}catch(TemplateException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
