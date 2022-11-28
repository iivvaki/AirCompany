package menu.database;

public class Database {
    public static java.sql.Connection connection = null;
    private static final String url = "jdbc:sqlserver://DESKTOP-OEOP4V3\\SQLEXPRESS:57141;database=Airplane;encrypt=true;trustServerCertificate=true;";
    private static final String user = "qqq";
    private static final String password = "#qwerty12";

    public static java.sql.Connection getConnection() {
        if(connection == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection  = java.sql.DriverManager.getConnection(url, user, password);
                System.out.println("Connection successful!");
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error trace in getConnection() : " + e.getMessage());
            }
        }
        return  connection;
    }
}
