import java.sql.*;

public class testingSQL {
	
	
	public static void main(String[] args)throws SQLException, ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=BudgitClientSystem;integratedSecurity=true";
		Connection conn = DriverManager.getConnection(url);
		
		//INSERT SQL statement
		//String sql = "INSERT INTO budgit_clients(client_username, client_password) VALUES ('JimB', '12345')";
		//Display SQL Statement
		String getClientId = "SELECT client_id from budgit_clients where client_username = 'LeoIbanez'";
		//create the java statement
		Statement st = conn.createStatement();
		
		//Execute the SQL statement in the server
		//st.executeUpdate(sql);
		
		//Execute the query, and get a java result set
		ResultSet rs = st.executeQuery(getClientId);
		int id = 0;
		
		while(rs.next())
		{
			id = rs.getInt("client_id");
			System.out.println(id);
		}

		//Turning table info into object in order to
		//write more SQL queries with the data pulled
		String getUserName = "SELECT client_username from budgit_clients WHERE client_id = '" + id + "'";
		rs = st.executeQuery(getUserName);
		String userName;
		while(rs.next()){
			userName = rs.getString("client_username");
			System.out.println(userName);
		}
	}
}
	