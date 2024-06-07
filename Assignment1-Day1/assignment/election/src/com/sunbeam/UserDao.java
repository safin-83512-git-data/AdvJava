package com.sunbeam;
import java.sql.*; 

public class UserDao 
{

   private Connection connection;

    public UserDaoImpl() throws Exception {
        // Initialize the database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/election_db", "root", "password");
    }

    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public User findByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getBoolean("voted"));
        }
        return null;
    }

    public User findById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getBoolean("voted"));
        }
        return null;
    }

    public int save(User user) throws SQLException {
        String query = "INSERT INTO users (email, password, voted) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setBoolean(3, user.isVoted());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public int updateStatus(int userId, boolean voted) throws SQLException {
        String query = "UPDATE users SET voted = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setBoolean(1, voted);
        stmt.setInt(2, userId);
        return stmt.executeUpdate();
    }

    public int updatePassword(int userId, String newPassword) throws SQLException {
        String query = "UPDATE users SET password = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, newPassword);
        stmt.setInt(2, userId);
        return stmt.executeUpdate();
    }

    public int deleteById(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    public int update(User user) throws SQLException {
        String query = "UPDATE users SET email = ?, password = ?, voted = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        stmt.setBoolean(3, user.isVoted());
        stmt.setInt(4, user.getId());
        return stmt.executeUpdate();
    }
}
