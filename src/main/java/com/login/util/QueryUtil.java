package com.login.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.login.model.User;

public class QueryUtil {

	public static final Logger log = Logger.getLogger(QueryUtil.class.getName());
	private static boolean result = false;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static int Admin = 0;

	public QueryUtil() {
		// TODO Auto-generated constructor stub
	}

	public static boolean validate(String email, String password) {

		try {

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select * from user where Email ='" + email + "' and Password = '" + password + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;

	}

	public static List<User> getUser(String email, String password) {
		ArrayList<User> user = new ArrayList<>();

		try {

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select * from user where Email ='" + email + "' and Password = '" + password + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String Email = rs.getString(3);
				String NIC = rs.getString(4);
				String pass = rs.getString(5);
				String telephone = rs.getString(6);
				boolean admin = rs.getBoolean(7);

				User u = new User(id, name, Email, NIC, pass, telephone, admin);
				user.add(u);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return user;
	}

	public static List<User> getUser(String UID) {
		ArrayList<User> user = new ArrayList<>();

		try {
			int ID = Integer.parseInt(UID);

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select * from user where UID ='" + ID + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String Email = rs.getString(3);
				String NIC = rs.getString(4);
				String pass = rs.getString(5);
				String telephone = rs.getString(6);
				boolean admin = rs.getBoolean(7);

				User u = new User(id, name, Email, NIC, pass, telephone,admin);
				user.add(u);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return user;
	}

	public static boolean insertUser(String name, String email, String NIC, String password, String telephone) {
		try {
			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "insert into user values(0,'" + name + "', '" + email + "', '" + NIC + "', '" + password
					+ "', '" + telephone + "', '"+ Admin +"' )";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;
	}

	public static boolean CheckUser(String email) {

		try {

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select * from user where Email ='" + email + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;

	}

	public static boolean updateUser(String UID, String name, String email, String NIC, String password,
			String telephone) {
		try {

			int ID = Integer.parseInt(UID);

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "update user set Name =  '" + name + "', Email = '" + email + "', NIC = '" + NIC
					+ "', Password = '" + password + "', Telephone = '" + telephone + "' where UID = '" + ID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;
	}

	public static boolean deleteUser(String UID) {

		try {
			int ID = Integer.parseInt(UID);

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "delete from user where UID = '" + ID + "' ";
			
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return result;
	}
	
	public static boolean CheckAdmin(String email) {

		try {

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select Admin from user where Email ='" + email + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = rs.getBoolean(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;

	}
	
	public static List<User> getAllUsers() {
		ArrayList<User> user = new ArrayList<>();

		try {

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "select * from user";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String Email = rs.getString(3);
				String NIC = rs.getString(4);
				String pass = rs.getString(5);
				String telephone = rs.getString(6);
				boolean admin = rs.getBoolean(7);

				User u = new User(id, name, Email, NIC, pass, telephone, admin);
				user.add(u);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return user;
	}
	
	public static boolean updateAdmin(String UID, int Admin) {
		try {

			int ID = Integer.parseInt(UID);

			stmt = DBConnectionUtil.getDBConnection().createStatement();

			String sql = "update user set Admin =  '" + Admin + "' where UID = '" + ID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				DBConnectionUtil.getDBConnection().close();
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return result;
	}

}
