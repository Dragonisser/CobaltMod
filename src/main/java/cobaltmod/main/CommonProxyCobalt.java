package cobaltmod.main;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;


public class CommonProxyCobalt
{
    public int addArmor(String string)
    {
    	 return 0;
	}
    public void registerClientStuff()
	{
	}
    
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
}