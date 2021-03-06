package server.game.players.packets;

import server.Connection;
import server.game.players.Client;
import server.game.players.PacketType;
import server.game.players.ReportHandler;

/**
 * Chat
 **/
public class Chat implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.setChatTextEffects(c.getInStream().readUnsignedByteS());
		c.setChatTextColor(c.getInStream().readUnsignedByteS());
		c.setChatTextSize((byte)(c.packetSize - 2));
		c.inStream.readBytes_reverseA(c.getChatText(), c.getChatTextSize(), 0);
		ReportHandler.addText(c.playerName, c.getChatText(), packetSize - 2);
		if (!Connection.isMuted(c))
			c.setChatTextUpdateRequired(true);
	}
}
