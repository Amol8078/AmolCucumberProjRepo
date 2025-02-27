package com.titan.managers.dbmanager;



import java.sql.*;

public class DBManager {

    //for testing only Should be removed
    public static void main(String[] args) throws SQLException {
        String q = "Select * from Products";
        String [][] result  = FetchDataFromDB(q);

        System.out.print(result);
    }

    public static String[][] FetchDataFromDB(String query) throws SQLException {

        String url = "jdbc:mysql://db4free.net:3306/db_autofrat?user=akashdktyagi&password=akashdktyagi";
        DBConnectionManager DBInstance = DBConnectionManager.getInstance(url);
        Connection conn = DBInstance.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);

        //To get total number of Column returned
        int clmCount = rs.getMetaData().getColumnCount();

        //To get total number of rows returned
        rs.last();// this will move the rs to last row
        int rowcount = rs.getRow(); // this will give the index of last row
        rs.beforeFirst(); // this will bring it back to first record

        //Create a Object
        String[][] result = new String[rowcount][clmCount];
        int i=0;
        while(rs.next()) {

            for(int j=0;j<clmCount;j++) {
                result[i][j]=rs.getString(j+1);
            }
            i=i+1;
        }

        return result;
    }

public static void ReadDB(String input) throws SQLException {

      Connection c =null;
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         c = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/db_autofrat?user=akashdktyagi&password=akashdktyagi");

     }catch (Exception e){
         e.printStackTrace();
         System.err.println(e.getClass().getName() +": " +e.getMessage());
         System.exit(0);
     }
      System.out.println("Opened database successfully");
     Statement stmt =null;
    stmt =c.createStatement();
      ResultSet rs   =stmt.executeQuery("select * FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
    System.out.println("rs "+rs);
    try {
        stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
    }catch (SQLException e){

    }
//    ResultSet rs1   =stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
//    System.out.println("rs1 "+rs1);

    rs.close();
    stmt.close();
    c.close();

    }


    public static void InsertIntoDB(String input) throws SQLException {

        Connection c =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/db_autofrat?user=akashdktyagi&password=akashdktyagi");

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() +": " +e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        Statement stmt =null;
        stmt =c.createStatement();
        ResultSet rs   =stmt.executeQuery("select * FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
        System.out.println("rs "+rs);
        try {
            stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
        }catch (SQLException e){

        }
//    ResultSet rs1   =stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
//    System.out.println("rs1 "+rs1);

        rs.close();
        stmt.close();
        c.close();

    }


    public static void deleteRecordFromDB(String input) throws SQLException {

        Connection c =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/db_autofrat?user=akashdktyagi&password=akashdktyagi");

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() +": " +e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        Statement stmt =null;
        stmt =c.createStatement();
        ResultSet rs   =stmt.executeQuery("select * FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
        System.out.println("rs "+rs);
        try {
            stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
        }catch (SQLException e){

        }
//    ResultSet rs1   =stmt.executeQuery("DELETE FROM phase4dev.master_amc WHERE amc_name like " + "'%" + input + "%'");
//    System.out.println("rs1 "+rs1);

        rs.close();
        stmt.close();
        c.close();

    }


}
