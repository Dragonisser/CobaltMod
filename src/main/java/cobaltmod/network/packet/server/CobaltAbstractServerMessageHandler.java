package cobaltmod.network.packet.server;

import cobaltmod.network.packet.CobaltAbstractMessageHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * 
 * Handler for messages sent to the SERVER
 * Only allows implementation of {@link AbstractMessageHandler#handleServerMessage handleServerMessage}
 * 
 */
public abstract class CobaltAbstractServerMessageHandler<T extends IMessage> extends CobaltAbstractMessageHandler<T> {
	// implementing a final version of the client message handler both prevents it from
	// appearing automatically and prevents us from ever accidentally overriding it
	public final IMessage handleClientMessage(EntityPlayer player, T message, MessageContext ctx) {
		return null;
	}
}