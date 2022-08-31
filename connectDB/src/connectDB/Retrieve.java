package connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Retrieve from test database
public class Retrieve {

	public static void main(String[] args) {
	
		try {
			
			Connection con = Eg1Connect.initializeDatabase(); // Connection
			String sql = "select * from customer";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("customer_name");
				String town = rs.getString("town");
				int id = rs.getInt("customer_id");
				System.out.println(id + ". " +name + " lives in " +town+".");
			}
			
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}//end

}
