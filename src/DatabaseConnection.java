//package src;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
    //private Connection connection;
    private final static String DATABASE_URL = "jdbc:mysql://localhost/gefaegnis";
    private Dao<Personal, Integer> Personaldao;
    private Dao<Insassen,Integer> Insassendao;
    //private Dao<Artikel,Integer> Artikeldao;
    public DatabaseConnection(String user, String password) throws Exception {
        ConnectionSource connectionSource=null;
        try
        {


            connectionSource = new JdbcConnectionSource(DATABASE_URL,user,password);
            setupDatabase(connectionSource);

            // read and write some data
            //readWriteData();
            // do a bunch of bulk operations
            //readWriteBunch();
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new SQLException("Database driver not found");
        }
        if (connectionSource != null) {
            connectionSource.close();
        }

    }
    private void setupDatabase(ConnectionSource connectionSource) throws Exception {
        // if you need to create the table
        Personaldao = DaoManager.createDao(connectionSource, Personal.class);
        //Artikeldao =DaoManager.createDao(connectionSource,Artikel.class);
        TableUtils.createTableIfNotExists(connectionSource, Personal.class);
        //TableUtils.createTableIfNotExists(connectionSource, Artikel.class);

    }
    public void createPersonal(String vname,String nname,int alter,String sicherheit) throws SQLException {
        Personal personal=new Personal(vname,nname,alter,sicherheit);
        Personaldao.createIfNotExists(personal);
    }
    public void createInsassen(String vname,String nname,int alter,int verbrechenslevel,String verbrechen,int verurteilteJahre ) throws SQLException {
        Insassen insassen=new Insassen(vname,nname,alter,verbrechenslevel,verbrechen,verurteilteJahre);
        Insassendao.createIfNotExists(insassen);
    }



    public  void updateKunde(int kid, String vname, String nname) throws SQLException {
        //Kunden kunden=new Kunden(vname,nname);
        //Kundenado.updateId(kunden,kid);

    }




}