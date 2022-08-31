package connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// delete data from table of database
public class DeleteEg {

	public static void main(String[] args) throws SQLException {

		Connection con = Eg1Connect.initializeDatabase();
		String sql = "delete from customer where customer_name=?;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, "MaungMaung");
		stmt.executeUpdate();
		System.out.println("Deleted Successfully!");

	}

}
