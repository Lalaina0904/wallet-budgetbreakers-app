package Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private String url;
    private String username;
    private  String password;
    private Connection connection;
    private static ConnectionDB instance;
    private ConnectionDB(){
        this.url=System.getenv("url");
        this.username=System.getenv("username");
        this.password=System.getenv("password");
        createConnection();
    }
    private Connection createConnection() {
        try {
            this.connection= DriverManager.getConnection(this.url,this.username,this.password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    //singleton connection
    public static ConnectionDB getConnection(){
        if(instance==null)
            instance=new ConnectionDB();
        return instance;
    }
    public Connection getConnectionInstance(){
        return connection;
    }
}

