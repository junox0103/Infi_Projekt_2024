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
    private Dao<personal_insassen,Integer> personal_insassendao;
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
        Insassendao = DaoManager.createDao(connectionSource, Insassen.class);
        personal_insassendao = DaoManager.createDao(connectionSource, personal_insassen.class);

        TableUtils.createTableIfNotExists(connectionSource, Personal.class);
        TableUtils.createTableIfNotExists(connectionSource, Insassen.class);
        TableUtils.createTableIfNotExists(connectionSource, personal_insassen.class);

    }
    public void createPersonal(String vname,String nname,int alter,String sicherheit) throws SQLException {
        Scanner scanner= new Scanner(System.in);
        Personal personal=new Personal(vname,nname,alter,sicherheit);
        Personaldao.createIfNotExists(personal);
        System.out.println("Wollen sie dem Personal einen Insassen zuweisen? (Ja/Nein)");
        String antwort = scanner.next();
        if (antwort.equals("Ja")){
            System.out.println("welcher Insasse soll zugewiesen werden? (ID)");
            int existingInsassenId = scanner.nextInt(); // replace with the actual ID
            Insassen existingInsassen = Insassendao.queryForId(existingInsassenId);
            if (existingInsassen != null) {
                personal_insassen newPersonalInsassen = new personal_insassen(personal, existingInsassen);
                personal_insassendao.create(newPersonalInsassen);
            } else {
                System.out.println("No Insassen found with ID " + existingInsassenId);
            }
        }
    }


    public void createperosnal_insassenrel() throws SQLException {
        int pid;
        int iid;
        Scanner scanner= new Scanner(System.in);
        System.out.println("All personal id :");
        for (Personal personal:Personaldao.queryForAll()){
            System.out.print(personal.getIDP());
            System.out.println(" "+personal.getVname());
        }
        System.out.println("All Insassen id :");
        for (Insassen insassen:Insassendao.queryForAll()){
            System.out.print(insassen.getIDI());
            System.out.println(" "+insassen.getVname());
        }
        System.out.println("Personal ID: ");
        pid=scanner.nextInt();
        System.out.println("Insassen ID: ");
        iid=scanner.nextInt();
        Personal personal=Personaldao.queryForId(pid);
        Insassen insassen=Insassendao.queryForId(iid);
        personal_insassen personal_insassen=new personal_insassen(personal,insassen);
        personal_insassendao.createIfNotExists(personal_insassen);
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