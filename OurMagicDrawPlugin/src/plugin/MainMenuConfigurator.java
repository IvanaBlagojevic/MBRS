package plugin;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;
//klasa koja se odnosi na pojavljivanje code generatora u menibaru (inicijalizuje se u OurPlugin klasi), opisuje akcije koje podrzava
//nasa za sada ima samo generate, nzm da li je jos nesto potrebno
public class MainMenuConfigurator implements AMConfigurator
{
	
	
	/**
	 * Actions that will be added to manager.
	 */
	private NMAction[] actions;

	/**
	 * Creates configurator.
	 * @param actions actions to be added to main menu.
	 */
	public MainMenuConfigurator(NMAction[] actions)
	{
		this.actions = actions;
	}

	/**
	 * @see com.nomagic.actions.AMConfigurator#configure(ActionsManager)
	 *  Methods adds action to given manager XCoder category.
	 */
	public void configure(ActionsManager mngr)
	{
		ActionsCategory category = (ActionsCategory) mngr.getActionFor("Code Generation DNI");
		
		if( category == null )
		{
			category = new MDActionsCategory("Code Generation DNI", "Code Generation DNI");
			category.setNested(true);
			mngr.addCategory(category);
		}
		for(int i=0;i<actions.length;i++) {
		   category.addAction(actions[i]);
		}
	}
	
	public int getPriority()
	{
		return AMConfigurator.MEDIUM_PRIORITY;
	}

}