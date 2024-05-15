package src;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@DatabaseTable(tableName = "Kunden")
public class Personal {
    JSONObject jsonObject = new JSONObject();
    JSONArray personal=new JSONArray();
    public static final String IDP_FIELD_NAME = "IDP";
    public static final String VNAME_FIELD_NAME = "Vorname";
    public static final String NNAME_FIELD_NAME = "Nachmane";
    public static final String AGE_FIELD_NAME = "Age";

    @DatabaseField(generatedId = true)
    private int IDP;
    @DatabaseField(columnName = VNAME_FIELD_NAME, canBeNull = true)
    private String vname;
    @DatabaseField(columnName = NNAME_FIELD_NAME, canBeNull = true)
    private String nname;

    Personal(){

    }
    public Personal(String vname,String nname) {
        this.vname=vname;
        this.nname=nname;
    }


    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
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
}