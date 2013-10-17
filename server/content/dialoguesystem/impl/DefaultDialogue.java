package server.content.dialoguesystem.impl;

import server.content.dialoguesystem.DialogueSystem;
import server.game.players.Client;

/**
 * @author somedude Default dialogue for every npc
 * 
 */
public class DefaultDialogue extends DialogueSystem {

	public static void handle(Client c, int dialogueId) {
		switch (dialogueId) {
		case 1:
			sendNpcChat1(c, "Hello there!",  DEFAULT);
			setNextDialogue(c, 2);
			break;
		case 2:
			sendNpcChat1(c, "Welcome to NewScape 2006!", LAUGHING);
			setNextDialogue(c, 3);
			break;
		case 3:
			sendNpcChat1(c, "I hope you are enjoying yourself!", EVIL);
			setNextDialogue(c, 4);
			break;
		case 4:
			sendNpcChat2(c, "Make sure you register at", "www.newscape-2006.com", MOURNING);
			setNextDialogue(c, 5);
			break;
		case 5:
			sendPlayerChat2(c, "Thank you!", "I'll be sure to register!",
					SLEEPY);
			setNextDialogue(c, 6);
			break;
		case 6:
			sendOption2(c, "I'll see you later!", "Have a nice day!");
			setDialogueAction(c, 1);
			break;
		case 7:
			sendPlayerChat1(c, "Have a nice day!", LAUGHING);	
			setNextDialogue(c, 8);
			break;
		case 8: // options2 = 1
			sendNpcChat1(c, "You too!!", DISINTERESTED);
			setNextDialogue(c, 9);
			break;
		case 10: // options2 = 2
			sendNpcChat1(c, "Bye!", LAUGH2);
			setNextDialogue(c, 9);
			break;
		case 9:
			resetChatDialogue(c);
			break;	
		}
	}
}
