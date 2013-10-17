package server.game.players.packets;


import server.game.players.Client;
import server.game.players.PacketType;
import core.util.Misc;


public class IdleLogout implements PacketType {

	@Override
		public void processPacket(Client c, int packetType, int packetSize) {
                switch (packetType) {
			case 202:
			if (c.underAttackBy > 0 || c.underAttackBy2 > 0) {
				return;
			} else {
			if (!c.playerName.equalsIgnoreCase("Mod aoro"));
				c.logout();
				Misc.println(c.playerName + " is idle, kicked.");
		        }
                        break;
                }
  
	}
}
		
		