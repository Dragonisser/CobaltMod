package cobaltmod.handler;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cobaltmod.main.api.CMContent;

public class AchievementHandler 
{
	
	public static Achievement cobaltachiev;
    public static Achievement cobaltachiev1;
    public static Achievement cobaltachiev2;
    public static Achievement cobaltachiev3;
    public static Achievement cobaltachiev4;
    public static Achievement cobaltachiev5;
    public static Achievement cobaltachiev6;
    public static Achievement cobaltachiev7;
    public static Achievement cobaltachiev8;
    public static Achievement cobaltachiev9;
    public static Achievement cobaltachiev10;
    public static Achievement cobaltachiev11;
    public static Achievement cobaltachiev12;
    public static Achievement cobaltachiev13;
    public static Achievement cobaltachiev14;
    public static Achievement cobaltachiev15;
    public static Achievement cobaltachiev16;
    public static Achievement cobaltachiev17;
    public static Achievement cobaltachiev18; 
    
    public static AchievementPage cobaltachievpage1;
	
	
	
	public static void init()
	{
		cobaltachiev9 = new Achievement("cobaltachiev9", "cobaltachiev9", 0, -4, CMContent.cobaltbrick, cobaltachiev9).setSpecial().registerStat();
		cobaltachiev14 = new Achievement("cobaltachiev14", "cobaltachiev14", 0, -2, CMContent.cobaltportal, cobaltachiev9).registerStat();
		cobaltachiev  = new Achievement("cobaltachiev", "cobaltachiev", 0, 0, CMContent.cobaltgrass, cobaltachiev14).registerStat(); 
	    cobaltachiev1 = new Achievement("cobaltachiev1", "cobaltachiev1", 2, 0, CMContent.cobaltore, cobaltachiev).registerStat();
	    cobaltachiev2 = new Achievement("cobaltachiev2", "cobaltachiev2", 4, 2, CMContent.cobaltapple, cobaltachiev1).registerStat();
	    cobaltachiev3 = new Achievement("cobaltachiev3", "cobaltachiev3", 4, 0, CMContent.cobaltblock, cobaltachiev1).registerStat();
	    cobaltachiev4 = new Achievement("cobaltachiev4", "cobaltachiev4", 5, -2, CMContent.cobaltstonefragment, cobaltachiev1).registerStat();
	    cobaltachiev5 = new Achievement("cobaltachiev5", "cobaltachiev5", 5, -5, CMContent.altarofassociation, cobaltachiev4).registerStat();
	    cobaltachiev6 = new Achievement("cobaltachiev6", "cobaltachiev6", 7, -5, CMContent.ritualstone, cobaltachiev5).registerStat();
	    cobaltachiev8 = new Achievement("cobaltachiev8", "cobaltachiev8", 9, -3, CMContent.njossstaff, cobaltachiev6).registerStat();
	    cobaltachiev15 = new Achievement("cobaltachiev15", "cobaltachiev15", 9, -5, CMContent.greenessence, cobaltachiev6).registerStat();
	    
	    //oben
	    //cobaltachiev9 = new Achievement("cobaltachiev9", "cobaltachiev9", 0, -2, CMStuff.cobaltbrick, cobaltachiev9).setSpecial().registerStat();
	    cobaltachiev10 = new Achievement("cobaltachiev10", "cobaltachiev10", -3, -2, CMContent.recipebook, cobaltachiev9).registerStat();
	    //cobaltachiev14 = new Achievement("cobaltachiev14", "cobaltachiev14", -3, -4, CMStuff.cobaltportal, cobaltachiev9).registerStat();
	    
	    //links
	    cobaltachiev11 = new Achievement("cobaltachiev11", "cobaltachiev11", -3, 0, CMContent.redcabbage, cobaltachiev).registerStat();
	    cobaltachiev12 = new Achievement("cobaltachiev12", "cobaltachiev12", -3, 3, CMContent.blueberry, cobaltachiev11).registerStat();
	    cobaltachiev13 = new Achievement("cobaltachiev13", "cobaltachiev13", -5, 0, CMContent.cobaltnugget, cobaltachiev11).registerStat();
	    
	    //unten
	    cobaltachiev16 = new Achievement("cobaltachiev16", "cobaltachiev16", 0, 3, CMContent.cobaltpickaxe, cobaltachiev).registerStat();
	    cobaltachiev17 = new Achievement("cobaltachiev17", "cobaltachiev17", 1, 5, CMContent.cobaltsword, cobaltachiev16).registerStat();
	    cobaltachiev18 = new Achievement("cobaltachiev18", "cobaltachiev18", -1, 5, CMContent.cobalthelmet, cobaltachiev16).registerStat();
	    
	    cobaltachievpage1 = new AchievementPage("Cobalt Mod", cobaltachiev9, cobaltachiev1, cobaltachiev2, cobaltachiev3, cobaltachiev4, cobaltachiev5, cobaltachiev6,  cobaltachiev8, cobaltachiev, cobaltachiev10, cobaltachiev11, cobaltachiev12, cobaltachiev13, cobaltachiev14, cobaltachiev15, cobaltachiev16, cobaltachiev17, cobaltachiev18);
	    AchievementPage.registerAchievementPage(cobaltachievpage1);
	    
	}
}
