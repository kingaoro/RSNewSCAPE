package server.game.players;

import java.sql.*;

public class Highscores {
	public static Connection con;
	public static Statement stm;
        public static boolean connected;
	
	public static String Host = "jdbc:mysql://162.218.210.99/HS";
	public static String User = "aoro";
	public static String Pass = "windows2008";
	
    public static void process() {
        try
        {
            Class.forName(Driver).newInstance();
	    Connection con = DriverManager.getConnection(Host, User, Pass);
	    stm = con.createStatement();
            connected = true;
        }
        catch(Exception e)
        {
            connected = false;
            e.printStackTrace();
        }
    }

    public static ResultSet query(String s)
        throws SQLException
    {
        if(s.toLowerCase().startsWith("select"))
        {
            ResultSet resultset = stm.executeQuery(s);
            return resultset;
        }
        try
        {
            stm.executeUpdate(s);
            return null;
        }
        catch(Exception e)
        {
            destroy();
        }
        process();
        return null;
    }

    public static void destroy() {
        try
        {
            stm.close();
            con.close();
            connected = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static boolean save(Client c) {
        try
        {
       query("DELETE FROM `hiscores` WHERE playerName = '"+c.playerName+"';");
	query("INSERT INTO `hiscores` VALUES ('"+c.playerName+"',"+(c.getLevelForXP(c.playerXP[0]) + c.getLevelForXP(c.playerXP[1]) + c.getLevelForXP(c.playerXP[2]) + c.getLevelForXP(c.playerXP[3]) + c.getLevelForXP(c.playerXP[4]) + c.getLevelForXP(c.playerXP[5]) + c.getLevelForXP(c.playerXP[6]) + c.getLevelForXP(c.playerXP[7]) + c.getLevelForXP(c.playerXP[8]) + c.getLevelForXP(c.playerXP[9]) + c.getLevelForXP(c.playerXP[10]) + c.getLevelForXP(c.playerXP[11]) + c.getLevelForXP(c.playerXP[12]) + c.getLevelForXP(c.playerXP[13]) + c.getLevelForXP(c.playerXP[14]) + c.getLevelForXP(c.playerXP[15]) + c.getLevelForXP(c.playerXP[16]) + c.getLevelForXP(c.playerXP[17]) + c.getLevelForXP(c.playerXP[18]) + c.getLevelForXP(c.playerXP[19]) + c.getLevelForXP(c.playerXP[20]))+","+((c.playerXP[0]) + (c.playerXP[1]) + (c.playerXP[2]) + (c.playerXP[3]) + (c.playerXP[4]) + (c.playerXP[5]) + (c.playerXP[6]) + (c.playerXP[7]) + (c.playerXP[8]) + (c.playerXP[9]) + (c.playerXP[10]) + (c.playerXP[11]) + (c.playerXP[12]) + (c.playerXP[13]) + (c.playerXP[14]) + (c.playerXP[15]) + (c.playerXP[16]) + (c.playerXP[17]) + (c.playerXP[18]) + (c.playerXP[19]) + (c.playerXP[20]))+","+c.playerXP[0]+","+c.playerXP[1]+","+c.playerXP[2]+","+c.playerXP[3]+","+c.playerXP[4]+","+c.playerXP[5]+","+c.playerXP[6]+","+c.playerXP[7]+","+c.playerXP[8]+","+c.playerXP[9]+","+c.playerXP[10]+","+c.playerXP[11]+","+c.playerXP[12]+","+c.playerXP[13]+","+c.playerXP[14]+","+c.playerXP[15]+","+c.playerXP[16]+","+c.playerXP[17]+","+c.playerXP[18]+","+c.playerXP[19]+","+c.playerXP[20]+");");
	  // 
		}
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	public static String Driver = "com.mysql.jdbc.Driver";
}