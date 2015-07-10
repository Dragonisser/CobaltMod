package cobaltmod.network.packet.bidirectional;

import cobaltmod.network.packet.CobaltAbstractMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;

/**
 * For messages which require different handling on each Side;
 * if the message is handled identically regardless of Side,
 * it is better to implement {@link IMessageHandler} directly
 * and register using {@link PacketDispatcher#registerBiMessage}
 */
public abstract class CobaltAbstractBiMessageHandler<T extends IMessage> extends CobaltAbstractMessageHandler<T> {

}
