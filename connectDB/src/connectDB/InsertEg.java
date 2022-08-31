package connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

// Insert data into database
public class InsertEg {

	public static void main(String[] args) {

		try {
			Connection con = Eg1Connect.initializeDatabase();
			String sql = "insert into customer(customer_name,town,grade) values(?,?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
		
			stmt.setString(1, "TunTun");
			stmt.setString(2, "Pathein");
			stmt.setInt(3, 45);
			stmt.executeUpdate();
			System.out.println("successfully update");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
