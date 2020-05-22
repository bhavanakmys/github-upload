import java.sql.*;
public class Demojjava {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/rto_management";
		String uname="root";
		String pass="kbhavana123@";
		String query="select * from llr_app";
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection(url,uname,pass);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
rs.next();
String name=rs.getString(1) + " : " +rs.getString(2);
System.out.println(name);
st.close();
con.close();
	}

}
