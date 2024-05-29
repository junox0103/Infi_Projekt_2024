
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


@DatabaseTable(tableName = "Personal")
public class Personal {
    //JSONObject jsonObject = new JSONObject();
    //JSONArray personal=new JSONArray();
    public static final String IDP_FIELD_NAME = "IDP";
    public static final String VNAME_FIELD_NAME = "Vorname";
    public static final String NNAME_FIELD_NAME = "Nachmane";
    public static final String AGE_FIELD_NAME = "Age";
    public static final String SAFTYLEVEL_FIELD_NAME = "SaftyLevel";

    @DatabaseField(generatedId = true)
    private int IDP;
    @DatabaseField(columnName = VNAME_FIELD_NAME, canBeNull = true)
    private String vname;
    @DatabaseField(columnName = NNAME_FIELD_NAME, canBeNull = true)
    private String nname;
    @DatabaseField(columnName = AGE_FIELD_NAME, canBeNull = true)
    private int age;
    @DatabaseField(columnName = SAFTYLEVEL_FIELD_NAME, canBeNull = true)
    private String saftylevel;

    Personal(){

    }
    public Personal(String vname,String nname, int Age,String saftylevel) {
        this.age=Age;
        this.saftylevel=saftylevel;
        this.vname=vname;
        this.nname=nname;
    }

    public int getIDP() {
        return IDP;
    }

    public void setIDP(int IDP) {
        this.IDP = IDP;
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

    public String getSaftylevel() {
        return saftylevel;
    }

    public void setSaftylevel(String saftylevel) {
        this.saftylevel = saftylevel;
    }
}