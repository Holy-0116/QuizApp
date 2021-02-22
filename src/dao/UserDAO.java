package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.User;

public class UserDAO {
	// データベースへ接続するための情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public  List<User> findAll() {
		List<User> userList = new ArrayList<>();
		// データベースへ接続
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			// SQL文の準備
			String sql = "SELECT * FROM USER;";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			// SQL文を実行し、結果をrsに格納
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String mail = rs.getString("MAIL");
				String pass = rs.getString("PASSWORD");

				User user = new User(id, name, mail, pass);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;

	}

	public User findByLogin(Login login) {
		User user = null;
		// データベースへ接続
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			// SQL文の準備
			String sql = "SELECT * FROM USER WHERE MAIL= ? AND PASSWORD= ?;";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, login.getMail());
			pStmt.setString(2, login.getPass());
			// SQL文を実行し、結果をrsに格納
			ResultSet rs = pStmt.executeQuery();

			// rsからUserを生成
			if(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String mail = rs.getString("MAIL");
				String pass = rs.getString("PASSWORD");
				user = new User(id, name, mail, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	public boolean createUser(User user) {

		// データベースへ接続
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			// SQL文の準備
			String sql = "INSERT INTO USER(NAME, MAIL, PASSWORD) VALUES (?, ?, ?); ";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getMail());
			pStmt.setString(3, user.getPass());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
