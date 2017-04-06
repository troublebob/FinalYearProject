package settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import settings.CodeFolioSettings;

public class CodefolioDataSource {
	private static CodefolioDataSource source;
	
	public static CodefolioDataSource getInstance() {
		if (source == null) {
			source = new CodefolioDataSource();
		}
		return source;
	}

	private Connection connection;
	
	private CodefolioDataSource() {
		connection = null;

		try {

			String home = System.getProperty("user.home");
			String path = home +  System.getProperty("file.separator") + ".codefolio" + 
					System.getProperty("file.separator") + CodeFolioSettings.database;

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + path);

		} catch ( Exception e ) {

			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public Connection connection() {
		return connection;
	}
	
	public Statement createStatement() throws SQLException {
		return connection.createStatement();
	}
}
