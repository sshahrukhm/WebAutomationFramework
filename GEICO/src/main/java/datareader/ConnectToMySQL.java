package datareader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToMySQL {

    public static Connection connect = null;
    public static Statement statemeent = null;
    public static PreparedStatement preStatemeent = null;
    public static ResultSet rs = null;

    public static Properties LoadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }
    public static Connection connectToMySQL() throws Exception{
        Properties prop = LoadProperties();
        String url = prop.getProperty("MYSQLJDBC.url");
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String username = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,username,password);
        System.out.println("Database is connected");
        return connect;
    }
    public List<String> readData(String tableName, String columnName) {
        List<String> warning = new ArrayList<>();
        try{
            Connection con = connectToMySQL();
            Statement st = con.createStatement();
            String query = "select * from " + tableName;
            //st.executeUpdate("insert into pnt(stdId,stName) values(8,'bah')");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                //System.out.println("Data"+rs.getString("stdId")+" "+rs.getString("stName"));
                warning.add(rs.getString(columnName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return warning;
    }
}

