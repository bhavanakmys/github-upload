import java.sql.*;





import javax.swing.*;
public class Connjava {
Connection con=null;
	public static Connection dbConnector()
	{
		try
		{
		String url="jdbc:mysql://localhost:3306/rto_management";
		String uname="root";
		String pass="kbhavana123@";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,uname,pass);
		//JOptionPane.showMessageDialog(null,"succesful");
		return con;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}
