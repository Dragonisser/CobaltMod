package cobaltmod.network.packet.client;

import cobaltmod.network.packet.CobaltAbstractMessageHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * 
 * Handler for messages sent to the CLIENT
 * Only allows implementation of {@link AbstractMessageHandler#handleClientMessage handleClientMessage}
 * 
 */
public abstract class CobaltAbstractClientMessageHandler<T extends IMessage> extends CobaltAbstractMessageHandler<T> {
	// implementing a final version of the server message handler both prevents it from
	// appearing automatically and prevents us from ever accidentally overriding it
	public final IMessage handleServerMessage(EntityPlayer player, T message, MessageContext ctx) {
		return null;
	}
}
