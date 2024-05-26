package TodoList.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource dataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/TodoList");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("rizky09");

        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60_000);
        hikariConfig.setMaxLifetime(10 * 60_000);

        dataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}

