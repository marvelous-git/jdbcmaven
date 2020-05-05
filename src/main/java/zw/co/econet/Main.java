package zw.co.econet;

import java.sql.*;

public class Main {

    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";   //""com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        PreparedStatement ps = null;


       try {
           //register the driver
           Class.forName(JDBC_DRIVER);

           //open connection
           conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);


           //create Statement
           st = conn.createStatement();
           ps = conn.prepareStatement("INSERT INTO `studentdb`.`student` (`id`, `name`, `tech`) VALUES (?, ?, ?)");
           ps.setInt(1, 5);
           ps.setString(2, "Senzeni");
           ps.setString(3, "Mashamba");
           ps.execute();

           //execute statement
           ResultSet rs = st.executeQuery("SELECT * FROM studentdb.student");

           //extract data fro the result set
           if (rs != null) {
               while (rs.next()) {
                   System.out.println(rs.getInt("id") + " ," + rs.getString("name") + " ," + rs.getString("tech"));
               }
           }
           rs.close();
           st.close();
           conn.close();
       }catch (Exception e){
           System.out.println("Error has been occurred!!!");
       }
    }
}
