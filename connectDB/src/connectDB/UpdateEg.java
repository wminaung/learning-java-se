package connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEg {

	public static void main(String[] args) throws SQLException {
		
		Connection con = Eg1Connect.initializeDatabase();
		String sql = "update customer set customer_name=?, grade=? where customer_name=?;";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, "MyaMya");
		stmt.setInt(2, 10);
		stmt.setString(3, "MyaMyaOo");
		stmt.executeUpdate();
		System.out.println("Updated succussfully");

	}

}
