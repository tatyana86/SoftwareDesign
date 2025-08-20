import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStorage implements Storage {

    private final Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
        initTable();
    }

    @Override
    public void save(String data) {
        String insertScript = "INSERT INTO storage (data) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertScript)) {
            stmt.setString(1, data);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String retrieve(int id) {
        String selectScript = "SELECT data FROM storage WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(selectScript)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initTable() {
        String createTableScript = "CREATE TABLE IF NOT EXISTS storage (id INT PRIMARY KEY AUTO_INCREMENT, data VARCHAR(255))";
        try (PreparedStatement stmt = connection.prepareStatement(createTableScript)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create storage table", e);
        }
    }

}
