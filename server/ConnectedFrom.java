package server;

import server.game.players.Client;

/**
 * @author Division
 * Tracking ip's that logged in on your account.
 */

public class ConnectedFrom {

	public static boolean addConnectedFrom(Client client, String host) {
		if(client != null) {
			if(client.lastConnectedFrom.contains(host)) {
				removeHostFromList(client, host);
				return client.lastConnectedFrom.add(host);
			}
			if(!client.lastConnectedFrom.contains(host)) {
				return client.lastConnectedFrom.add(host);
			}
		}
		return false;
	}

	public static boolean removeHostFromList(Client client, String host) {
		return client != null && client.lastConnectedFrom.remove(host);
	}
}