package cobaltmod.handler.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import cobaltmod.network.CobaltPacketDispatcher;
import cobaltmod.network.packet.server.CobaltOpenGuiMessage;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class CobaltKeyHandler {
	/**
	 * Storing an instance of Minecraft in a local variable saves having to get
	 * it every time
	 * 
	 */

	private final Minecraft mc;

	/** Key index for easy handling */
	public static final int CUSTOM_INV = 0;

	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = { "key.backpack.desc" };

	/** Default key values */
	private static final int[] keyValues = { Keyboard.KEY_F };

	/**
	 * Make this public or provide a getter if you'll need access to the key
	 * bindings from elsewhere
	 */
	public static final KeyBinding[] keys = new KeyBinding[desc.length];

	public CobaltKeyHandler() {
		mc = Minecraft.getMinecraft();
		for (int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding(desc[i], keyValues[i], StatCollector.translateToLocal("key.cobaltmod.label"));
			ClientRegistry.registerKeyBinding(keys[i]);

		}
	}

	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event
	 * bus
	 */
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		// checking inGameHasFocus prevents your keys from firing when the
		// player is typing a chat message
		// NOTE that the KeyInputEvent will NOT be posted when a gui screen such
		// as the inventory is open
		// so we cannot close an inventory screen from here; that should be done
		// in the GUI itself
		if (mc.inGameHasFocus) {
			if (keys[CUSTOM_INV].getIsKeyPressed()) {
				CobaltPacketDispatcher.sendToServer(new CobaltOpenGuiMessage(5));
			}
		}
	}
}