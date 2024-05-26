package TodoList.Util;

import TodoList.util.DatabaseUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseUtil {
    @Test
    void DatabaseConnectionTest() throws SQLException {
        Connection connection = DatabaseUtil.getDataSource().getConnection();

        connection.close();
    }
}
