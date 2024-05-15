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
    private final static String DATABASE_URL = "jdbc:mysql://localhost/Gfaegnis";
    //private Dao<Kunden, Integer> Kundenado;
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
        //Kundenado = DaoManager.createDao(connectionSource, Kunden.class);
        //Artikeldao =DaoManager.createDao(connectionSource,Artikel.class);
        //TableUtils.createTableIfNotExists(connectionSource, Kunden.class);
        //TableUtils.createTableIfNotExists(connectionSource, Artikel.class);

    }
    public void createKunde(String vname,String nname) throws SQLException {
        //Kunden kunden=new Kunden(vname,nname);
        //Kundenado.create(kunden);
    }
    public void createArtikel(String bezeichnung,Double preis) throws SQLException {
        //Artikel artikel=new Artikel(bezeichnung,preis);
        //Artikeldao.create(artikel);
    }



    public  void updateKunde(int kid, String vname, String nname) throws SQLException {
        //Kunden kunden=new Kunden(vname,nname);
        //Kundenado.updateId(kunden,kid);

    }




}