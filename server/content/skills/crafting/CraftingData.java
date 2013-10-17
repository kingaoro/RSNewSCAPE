package server.content.skills.crafting;

import server.content.skills.misc.SkillHandler;

public class CraftingData extends SkillHandler {
	
	public static enum tanningData {
		
		SOFT_LEATHER(new int[][] {{57225, 1}, {57217, 5}, {57201, 28}}, 1739, 1741, 1, new int[] {14777, 14785, 14769}, "Soft leather"),
		HARD_LEATHER(new int[][] {{57226, 1}, {57218, 5}, {57202, 28}}, 1739, 1743, 3, new int[] {14778, 14786, 14770}, "Hard leather"),
		SNAKESKIN(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 6287, 6289, 15, new int[] {14779, 14787, 14771}, "Snakeskin"),
		SNAKESKIN2(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 6287, 6289, 20, new int[] {14780, 14788, 14772}, "Snakeskin"),
		GREEN_DRAGON_LEATHER(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 1753, 1745, 20, new int[] {14781, 14789, 14773}, "Green d'hide"),
		BLUE_DRAGON_LEATHER(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 1751, 2505, 20, new int[] {14782, 14790, 14774}, "Blue d'hide"),
		RED_DRAGON_LEATHER(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 1749, 2507, 20, new int[] {14783, 14791, 14775}, "Red d'hide"),
		BLACK_DRAGON_LEATHER(new int[][] {{-1, 1}, {-1, 5}, {-1, 28}}, 1747, 2509, 20, new int[] {14784, 14792, 14776}, "Black d'hide");		
		
		private int[][] buttonId;
		private int hideId, leatherId, price;
		private int[] frameId;
		private String name;
		
		private tanningData(final int[][] buttonId, final int hideId, final int leatherId, final int price, final int[] frameId, final String name) {
			this.buttonId = buttonId;
			this.hideId = hideId;
			this.leatherId = leatherId;
			this.price = price;
			this.frameId = frameId;
			this.name = name;
		}
		public int getButtonId(final int button) {
			for (int i = 0; i < buttonId.length; i++) {
				if (button == buttonId[i][0]) {
					return buttonId[i][0];
				}
			}
			return -1;
		}
		
		public int getAmount(final int button) {
			for (int i = 0; i < buttonId.length; i++) {
				if (button == buttonId[i][0]) {
					return buttonId[i][1];
				}
			}
			return -1;
		}
		
		public int getHideId() {
			return hideId;
		}
		
		public int getLeatherId() {
			return leatherId;
		}
		
		public int getPrice() {
			return price;
		}
		
		public int getNameFrame() {
			return frameId[0];
		}
		
		public int getCostFrame() {
			return frameId[1];
		}
		
		public int getItemFrame() {
			return frameId[2];
		}
		
		public String getName() {
			return name;
		}
	}
	
	public static enum leatherDialogueData {
		
		GREEN_LEATHER(1745, 1065, 1099, 1135),
		BLUE_LEATHER(2505, 2487, 2493, 2499),
		RED_LEATHER(2507, 2489, 2495, 2501),
		BLACK_LEATHER(2509, 2491, 2497, 2503);
		
		private int leather, vambraces, chaps, body;
		
		private leatherDialogueData(final int leather, final int vambraces, final int chaps, final int body) {
			this.leather = leather;
			this.vambraces = vambraces;
			this.chaps = chaps;
			this.body = body;
		}
		
		public int getLeather() {
			return leather;
		}
		
		public int getVamb() {
			return vambraces;
		}
		
		public int getChaps() {
			return chaps;
		}
		
		public int getBody() {
			return body;
		}
	}
	
	public static enum leatherData {
		
		LEATHER_BODY(new int[][] {{33187, 1}, {33186, 5}, {33185, 10}}, 1741, 1129, 14, 125, 1),
		LEATHER_GLOVES(new int[][] {{33190, 1}, {33189, 5}, {33188, 10}}, 1741, 1059, 1, 69, 1),
		LEATHER_BOOTS(new int[][] {{33193, 1}, {33192, 5}, {33191, 10}}, 1741, 1061, 7, 81.25, 1),
		LEATHER_VAMBRACES(new int[][] {{33196, 1}, {33195, 5}, {33194, 10}}, 1741, 1063, 11, 110, 1),
		LEATHER_CHAPS(new int[][] {{33199, 1}, {33198, 5}, {33197, 10}}, 1741, 1095, 18, 135, 1),
		LEATHER_COIF(new int[][] {{33202, 1}, {33201, 5}, {33200, 10}}, 1741, 1169, 38, 185, 1),
		LEATHER_COWL(new int[][] {{33205, 1}, {33204, 5}, {33203, 10}}, 1741, 1167, 9, 92.5, 1),
		HARD_LEATHER_BODY(new int[][] {{10239, 1}, {10238, 5}, {6212, 28}, {6211, 28}}, 1743, 1131, 28, 175, 1),
		SNAKESKIN_BODY(new int[][] {{34245, 1}, {34244, 5}, {34243, 10}, {34242, 28}}, 6289, 6322, 53, 275, 15),
		SNAKESKIN_CHAPS(new int[][] {{34249, 1}, {34248, 5}, {34247, 10}, {34246, 28}}, 6289, 6324, 51, 250, 12),
		SNAKESKIN_BANDANA(new int[][] {{34253, 1}, {34252, 5}, {34251, 10}, {34250, 28}}, 6289, 6326, 48, 225, 5),
		SNAKESKIN_BOOTS(new int[][] {{35001, 1}, {35000, 5}, {34255, 10}, {34254, 28}}, 6289, 6328, 45, 150, 6),
		SNAKESKIN_VAMBRACES(new int[][] {{35005, 1}, {35004, 5}, {35003, 10}, {35002, 28}}, 6289, 6330, 47, 175, 8),
		GREEN_DHIDE_VAMBRACES(new int[][] {{34185, 1}, {34184, 5}, {34183, 10}, {34182, 28}}, 1745, 1065, 57, 310, 1),
		GREEN_DHIDE_BODY(new int[][] {{34189, 1}, {34188, 5}, {34187, 10}, {34186, 28}}, 1745, 1135, 63, 930, 3),
		GREEN_DHIDE_CHAPS(new int[][] {{34193, 1}, {34192, 5}, {34191, 10}, {34190, 28}}, 1745, 1099, 60, 620, 2),
		BLUE_DHIDE_VAMBRACES(new int[][] {{34185, 1}, {34184, 5}, {34183, 10}, {34182, 28}}, 2505, 2487, 66, 350, 1),
		BLUE_DHIDE_BODY(new int[][] {{34189, 1}, {34188, 5}, {34187, 10}, {34186, 28}}, 2505, 2499, 71, 1050, 3),
		BLUE_DHIDE_CHAPS(new int[][] {{34193, 1}, {34192, 5}, {34191, 10}, {34190, 28}}, 2505, 2493, 68, 700, 2),
		RED_DHIDE_VAMBRACES(new int[][] {{34185, 1}, {34184, 5}, {34183, 10}, {34182, 28}}, 2507, 2489, 73, 390, 1),
		RED_DHIDE_BODY(new int[][] {{34189, 1}, {34188, 5}, {34187, 10}, {34186, 28}}, 2507, 2501, 77, 1170, 3),
		RED_DHIDE_CHAPS(new int[][] {{34193, 1}, {34192, 5}, {34191, 10}, {34190, 28}}, 2507, 2495, 75, 780, 2),
		BLACK_DHIDE_VAMBRACES(new int[][] {{34185, 1}, {34184, 5}, {34183, 10}, {34182, 28}}, 2509, 2491, 79, 430, 1),
		BLACK_DHIDE_BODY(new int[][] {{34189, 1}, {34188, 5}, {34187, 10}, {34186, 28}}, 2509, 2503, 84, 1290, 3),
		BLACK_DHIDE_CHAPS(new int[][] {{34193, 1}, {34192, 5}, {34191, 10}, {34190, 28}}, 2509, 2497, 82, 860, 2);
		
		private int[][] buttonId;
		private int leather, product, level, amount;
		private double xp;
		
		private leatherData(final int[][] buttonId, final int leather, final int product, final int level, final double xp, final int amount) {
			this.buttonId = buttonId;
			this.leather = leather;
			this.product = product;
			this.level = level;
			this.xp = xp;
			this.amount = amount;
		}	
		
		public int getButtonId(final int button) {
			for (int i = 0; i < buttonId.length; i++) {
				if (button == buttonId[i][0]) {
					return buttonId[i][0];
				}
			}
			return -1;
		}
		
		public int getAmount(final int button) {
			for (int i = 0; i < buttonId.length; i++) {
				if (button == buttonId[i][0]) {
					return buttonId[i][1];
				}
			}
			return -1;
		}
		
		public int getLeather() {
			return leather;
		}
		
		public int getProduct() {
			return product;
		}
		
		public int getLevel() {
			return level;
		}
		
		public double getXP() {
			return xp;
		}
		
		public int getHideAmount() {
			return amount;
		}
	}

	public static enum cutGemData {
		
		SAPPHIRE(1623, 1607, 20, 250, 888),
		EMERALD(1621, 1605, 27, 335, 889),
		RUBY(1619, 1603, 34, 425, 887),
		DIAMOND(1617, 1601, 43, 537.5, 886),
		DRAGONSTONE(1631, 1615, 55, 687.5, 885),
		ONYX(6571, 6573, 67, 840, 885), /** Need correct animation ID **/
		OPAL(1625, 1609, 1, 60, 890),
		JADE(1627, 1611, 13, 100, 891),
		RED_TOPAZ(1629, 1613, 16, 125, 892);
		
		private int uncut, cut, level, animation;
		private double xp;
		
		private cutGemData(final int uncut, final int cut, final int level, final double xp, final int animation) {
			this.uncut = uncut;
			this.cut = cut;
			this.level = level;
			this.xp = xp;
			this.animation = animation;
		}
		
		public int getUncut() {
			return uncut;
		}
		
		public int getCut() {
			return cut;
		}
		
		public int getLevel() {
			return level;
		}
		
		public double getXP() {
			return xp;
		}
		
		public int getAnimation() {
			return animation;
		}
	}
	
	public static enum jewelryData {
		
		RINGS(new int[][] {{2357, 1635, 5, 75}, {1607, 1637, 20, 200}, {1605, 1639, 27, 275}, {1603, 1641, 34, 350}, {1601, 1643, 43, 425}, {1615, 1645, 55, 500}, {6573, 6575, 67, 575}}),
		NECKLACE(new int[][] {{2357, 1654, 6, 100}, {1607, 1656, 22, 275}, {1605, 1658, 29, 300}, {1603, 1660, 40, 375}, {1601, 1662, 56, 450}, {1615, 1664, 72, 525}, {6573, 6577, 82, 600}}),
		AMULETS(new int[][] {{2357, 1673, 8, 150}, {1607, 1675, 24, 325}, {1605, 1677, 31, 350}, {1603, 1679, 50, 425}, {1601, 1681, 70, 500}, {1615, 1683, 80, 750}, {6573, 6579, 90, 825}});
		
		public int[][] item;
		
		private jewelryData(final int[][] item) {
			this.item = item;
		}	
	}
	
	public static enum amuletData {
		GOLD(1673, 1692),
		SAPPHIRE(1675, 1694),
		EMERALD(1677, 1696),
		RUBY(1679, 1698),
		DIAMOND(1681, 1700),
		DRAGONSTONE(1683, 1702),
		ONYX(6579, 6851);
		
		private int amuletId, product;
		
		private amuletData(final int amuletId, final int product) {
			this.amuletId = amuletId;
			this.product = product;
		}
		
		public int getAmuletId() {
			return amuletId;
		}
		
		public int getProduct() {
			return product;
		}
	}
}