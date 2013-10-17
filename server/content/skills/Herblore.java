package server.content.skills;

import server.game.players.Client;

public class Herblore {
                
        public enum Herbs {
                Guam(199,249,1,3),
                Marrentill(201,251,5,4),
                Tarromin(203,253,11,5),
                Harralander(205,255,20,6),
                Ranarr(207,257,25,8),
                Toadflax(3049,2998,30,8),
                Irit(209,259,40,9),
                Avantoe(211,261,48,10),
                Kwuarm(213,263,54,11),
                Snapdragon(3051,3000,59,12),
                Cadantine(215,265,65,13),
                Lantadyme(2485,2481,67,13),
                DwarfWeed(217,267,70,14),
                Torstol(219,269,75,15);
                
                private int grimy,clean,cleanReq,cleanXP;
                
                private Herbs(int herb,int herb1,int req,int exp){
                        this.grimy = herb;
                        this.clean = herb1;
                        this.cleanReq = req;
                        this.cleanXP = exp;
                }
                public int grimy(){
                        return grimy;
                }
                public int clean(){
                        return clean;
                }
                public int req(){
                        return cleanReq;
                }
                public int exp(){
                        return cleanXP;
                }
                public static Herbs forId(int herbID,String type){
                        for(Herbs herb : Herbs.values()){
                                if(type.equalsIgnoreCase("grimy")){
                                        if(herb.grimy() == herbID)
                                                return herb;
                                } else if(type.equalsIgnoreCase("clean")) {
                                        if(herb.clean() == herbID)
                                                return herb;
                                }
                        }
                        return null;
                }
                
        }
        
        public static void cleanHerb(Client c,int herbID){
                Herbs herb = Herbs.forId(herbID, "grimy");
                if(c.getItems().playerHasItem(herb.grimy())){
                        if(c.getLevelForXP(c.playerXP[c.playerHerblore]) >= herb.req()){
                                c.getItems().deleteItem(herb.grimy(), 1);
                                c.getItems().addItem(herb.clean(), 1);
                                c.getPA().addSkillXP(herb.exp(), c.playerHerblore);
                                c.sendMessage("You clean the dirt off the leaf.");
                        } else {
                                c.sendMessage("You need a Herblore level of "+herb.req()+" to clean this leaf.");
                                return;
                        }
                }
        }
              
        public enum Grind{
        	UnicornHorn(233, 237, 235),
        	ChocolateBar(233, 1973, 1975),
        	DragonScale(233, 243, 241);
        	
        	private int grinderID, firstID, secondID;
        	
        	private Grind(int gID, int fID, int sID){
        		this.grinderID = gID;
        		this.firstID = fID;
        		this.secondID = sID;
        	}
        	public int grinder(){
        		return grinderID;
        	}
        	public int grinding(){
        		return firstID;
        	}
        	public int outcome(){
        		return secondID;
        	}
        				public static Grind forId(int firstID){
                        for(Grind grind : Grind.values()){
                                if(grind.grinding() == firstID)
                                        return grind;
                        }
                        return null;
                }
	}
        
        public enum UPotions{
        		Unfinished(91, 249),  //Guam
			Unfinished1(93, 251),  //Marrentill
			Unfinished2(95, 253), //Tarromin
			Unfinished3(97, 255), //Harralander
			Unfinished4(99, 257), //Ranarr
			Unfinished5(3002, 2998), //Toadflax - Not working
			Unfinished6(101, 259), //Irit
			Unfinished7(103, 261), //Avantoe - Not working
			Unfinished8(105, 263), //Kwuarm
			Unfinished9(3004, 3000), //Snapdragon - Not working
			Unfinished10(107, 265), //Cadantine
			Unfinished11(2483, 2481), //Lantadyme - Not working
			Unfinished12(109, 267), //Dwarf Weed
			Unfinished13(111, 269); //Torstol
			
			private int unfID, herbID;
			
			private UPotions(int id, int id1){
				this.unfID = id;
				this.herbID = id1;
			}
			public int herb(){
			return herbID;
			}
			public int unfp(){
				return unfID;
			}
			public static UPotions forId(int herbID){
                        for(UPotions unfp : UPotions.values()){
                                if(unfp.herb() == herbID)
                                        return unfp;
                        }
                        return null;
                }
	}
        
        public enum Potions {
                Attack(221, 91, 121, 3, 125),
                Antipoison(235, 93, 175, 5, 190),
                Strength(225, 95, 115, 12, 250),
                Restore(223, 97, 127, 22, 315),
                Energy(1975, 97, 3010, 26, 340),
                Defence(239, 99, 133, 30, 375),
                Prayer(231, 99, 139, 38, 440),
                Agility(2152, 3002, 3034, 34, 400),
                SAttack(221, 101, 145, 45, 500), //not working
                SAntipoison(235, 101, 181, 48, 530), //not working
                Fishing(231, 103, 151, 50, 565), //not working
                SEnergy(2970, 103, 3018, 52, 590),
                SStrength(223, 105, 157, 55, 625), //not working
                WeaponP(241, 105, 187, 60, 690),
                SRestore(223, 3004, 3026, 63, 715), //not working
                SDefence(239, 107, 163, 66, 750), //not working
                ADFire(241, 2483, 2454, 69, 790), //not working
                Magic(3138, 2483, 3042, 76, 865), //not working
                Range(245, 109, 169, 72, 825),
                ZBrew(247, 111, 189, 78, 875),
                SBrew(6693, 101, 6687, 81, 900);
                
                private int secID,unfID,potID,reqLvl,amtExp;
                
                private Potions(int id,int id1,int id2,int req,int xp){
                        this.secID = id;
                        this.unfID = id1;
                        this.potID = id2;
                        this.reqLvl = req;
                        this.amtExp = xp;
                }
                
                public int sec(){
                        return secID;
                }
                public int unf(){
                        return unfID;
                }
                public int pot(){
                	return potID;
                }
                public int req(){
                        return reqLvl;
                }
                public int xp(){
                        return amtExp;
                }
                
                public static Potions forId(int potID){
                        for(Potions pot : Potions.values()){
                                if(pot.sec() == potID)
                                        return pot;
                        }
                        return null;
                }
        }
        
        public static int vial = 227;
        public static int pNm = 233;
        
        public static void makeUnfPotion(Client c,int herbID){
        	UPotions unf = UPotions.forId(herbID);
        	if(c.getItems().playerHasItem(vial, 1)){
        		if(c.getItems().playerHasItem(unf.herb(), 1)){
        			c.getItems().deleteItem(vial, 1);
        			c.getItems().deleteItem(unf.herb(), 1);
        			c.getItems().addItem(unf.unfp(), 1);
        			c.startAnimation(363);
        			c.sendMessage("You create a "+c.getItems().getItemName(unf.unfp()));
        		}
        	}
        }
        
        public static void grindIngredient(Client c,int firstID){
        	Grind grind = Grind.forId(firstID);
        	if(c.getItems().playerHasItem(pNm, 1)){
        		if(c.getItems().playerHasItem(grind.grinding(), 1)){
        			c.sendMessage("You grind the " + c.getItems().getItemName(grind.grinding()) + " into " + c.getItems().getItemName(grind.outcome()));
        			c.getItems().deleteItem(grind.grinding(), 1);
        			c.startAnimation(364);
        			c.getItems().addItem(grind.outcome(), 1);
        		}
        	}
        }        
         
        public static void makePotion(Client c,int unfID ){
                Potions pot = Potions.forId(unfID);
                if(c.getLevelForXP(c.playerXP[c.playerHerblore]) >= pot.req()){
                        if(c.getItems().playerHasItem(unfID,1)){
                                if(c.getItems().playerHasItem(pot.sec(), 1)){
                                        c.getItems().deleteItem(pot.unfID, 1);
                                        c.getItems().deleteItem(pot.sec(), 1);
                                        c.getItems().addItem(pot.pot(),1);
                                        c.getPA().addSkillXP(pot.xp(), c.playerHerblore);
                                        c.startAnimation(363);
                                        c.sendMessage("You create a "+c.getItems().getItemName(pot.pot()));
                                }
                        }
                } else {
                        c.sendMessage("You need a Herblore level of "+pot.req()+" to make this potion.");
                }
        }
}
