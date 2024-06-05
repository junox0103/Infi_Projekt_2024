//package src;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DatabaseConnection {
    //private Connection connection;
    private final static String DATABASE_URL = "jdbc:mysql://localhost/gefaegnis";
    private Dao<Personal, Integer> Personaldao;
    private Dao<Insassen,Integer> Insassendao;
    private Dao<zellen_insassen,Integer> zellen_insassenDao;
    private Dao<personal_insassen,Integer> personal_insassendao;
    private Dao<Zelle,Integer> Zelledao;
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
        Zelledao= DaoManager.createDao(connectionSource, Zelle.class);
        zellen_insassenDao= DaoManager.createDao(connectionSource, zellen_insassen.class);

        TableUtils.createTableIfNotExists(connectionSource, Zelle.class);
        TableUtils.createTableIfNotExists(connectionSource, Personal.class);
        TableUtils.createTableIfNotExists(connectionSource, Insassen.class);
        TableUtils.createTableIfNotExists(connectionSource, personal_insassen.class);
        TableUtils.createTableIfNotExists(connectionSource, zellen_insassen.class);
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

    public void createInsassen(String vname, String nname, int alter, int verbrechenslevel, String verbrechen, int verurteilteJahre) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Insassen insassen = new Insassen(vname, nname, alter, verbrechenslevel, verbrechen, verurteilteJahre);
        Insassendao.createIfNotExists(insassen);
        System.out.println("Wollen sie dem Insassen einer Zelle zuweisen? (Ja/Nein)");
        String antwort = scanner.next();
        if (antwort.equals("Ja")) {
            // Find the cell with the fewest inmates
            List<Zelle> cells = Zelledao.queryBuilder().orderBy("zug_insassen", true).query();  // Assuming 'zug_insassen' is a field that counts the inmates
            if (cells.size() > 0) {
                Zelle selectedCell = cells.get(0);  // Get the cell with the fewest inmates
                System.out.println("Der Insasse wird der Zelle ID " + selectedCell.getIdz() + " zugewiesen.");
                zellen_insassen zellen_insassen = new zellen_insassen(selectedCell, insassen);
                zellen_insassenDao.create(zellen_insassen);
                selectedCell.setZug_insassen(selectedCell.getZug_insassen() + 1);
                Zelledao.update(selectedCell);
                // Update the inmate assignment here, for example by incrementing the count or adding a new inmate relation
            } else {
                System.out.println("Keine Zellen verfügbar.");
            }
        }
    }

    public void createZelle(int zellengroesse) throws SQLException {
        Zelle zelle = new Zelle(zellengroesse);
        Zelledao.createIfNotExists(zelle);
    }
    public void createZelleinsasse() throws SQLException {

        int iid;
        Scanner scanner = new Scanner(System.in);
        System.out.println("All Insassen id :");
        for (Insassen insassen : Insassendao.queryForAll()) {
            boolean haftfrai=true;
            for (zellen_insassen zellen_insassen : zellen_insassenDao.queryForAll()) {
                if (zellen_insassen.getInsassen().getIDI() == insassen.getIDI()) {
                    haftfrai = false;
                }
            }
            if (haftfrai) {
                System.out.print(insassen.getIDI());
                System.out.println(" " + insassen.getVname());
            }

        }
        System.out.println("Personal ID: ");
        iid = scanner.nextInt();
        Insassen insassen = Insassendao.queryForId(iid);
        List<Zelle> cells = Zelledao.queryBuilder().orderBy("zug_insassen", true).query();  // Assuming 'zug_insassen' is a field that counts the inmates
        if (cells.size() > 0) {
            Zelle selectedCell = cells.get(0);  // Get the cell with the fewest inmates
            System.out.println("Der Insasse wird der Zelle ID " + selectedCell.getIdz() + " zugewiesen.");
            zellen_insassen zellen_insassen = new zellen_insassen(selectedCell, insassen);
            zellen_insassenDao.create(zellen_insassen);
            selectedCell.setZug_insassen(selectedCell.getZug_insassen() + 1);
            Zelledao.update(selectedCell);    // Update the inmate assignment here, for example by incrementing the count or adding a new inmate relation
        } else {
            System.out.println("Keine Zellen verfügbar.");
        }

    }






}