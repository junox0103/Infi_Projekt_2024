
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@DatabaseTable(tableName = "Insassen")
public class Insassen {
    JSONObject jsonObject = new JSONObject();
    JSONArray personal=new JSONArray();
    public static final String IDI_FIELD_NAME = "IDI";
    public static final String VNAME_FIELD_NAME = "Vorname";
    public static final String NNAME_FIELD_NAME = "Nachmane";
    public static final String AGE_FIELD_NAME = "Age";
    public static final String VERBRECHENSLEVEL="Verbrechenslevel";
    public static final String VERBRECHEN="Verbrechen";
    public static final String VERURTEILTE_JAHRE="Verurteilte Jahre";

    @DatabaseField(generatedId = true)
    private int IDI;
    @DatabaseField(columnName = VNAME_FIELD_NAME, canBeNull = true)
    private String vname;
    @DatabaseField(columnName = NNAME_FIELD_NAME, canBeNull = true)
    private String nname;
    @DatabaseField(columnName = AGE_FIELD_NAME, canBeNull = true)
    private int age;
    @DatabaseField(columnName = VERBRECHENSLEVEL, canBeNull = true)
    private int verbrechenslevel;
    @DatabaseField(columnName = VERBRECHEN, canBeNull = true)
    private String verbrechen;
    @DatabaseField(columnName = VERURTEILTE_JAHRE, canBeNull = true)
    private int verurteilteJahre;

    Insassen(){

    }
    public Insassen(String vname,String nname, int Age,int verbrechenslevel,String verbrechen,int verurteilteJahre) {
        this.age=Age;
        this.verbrechenslevel=verbrechenslevel;
        this.verbrechen=verbrechen;
        this.verurteilteJahre=verurteilteJahre;
        this.vname=vname;
        this.nname=nname;
    }

    public int getIDI() {
        return IDI;
    }

    public void setIDI(int IDI) {
        this.IDI = IDI;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVerbrechenslevel() {
        return verbrechenslevel;
    }

    public void setVerbrechenslevel(int verbrechenslevel) {
        this.verbrechenslevel = verbrechenslevel;
    }

    public String getVerbrechen() {
        return verbrechen;
    }

    public void setVerbrechen(String verbrechen) {
        this.verbrechen = verbrechen;
    }

    public int getVerurteilteJahre() {
        return verurteilteJahre;
    }

    public void setVerurteilteJahre(int verurteilteJahre) {
        this.verurteilteJahre = verurteilteJahre;
    }
}