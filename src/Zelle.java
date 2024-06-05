import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Zelle")
public class Zelle {

    @DatabaseField(generatedId = true)
    private int idz;

    @DatabaseField( columnName = "zug_insassen")
    private int zug_insassen;



    public Zelle() {
        // ORMLite needs a no-arg constructor
    }

    public Zelle( int zug_insassen) {
        this.zug_insassen = zug_insassen;
        }

    public int getIdz() {
        return idz;
    }

    public void setIdz(int idz) {
        this.idz = idz;
    }

    public int getZug_insassen() {
        return zug_insassen;
    }

    public void setZug_insassen(int zug_insassen) {
        this.zug_insassen = zug_insassen;
    }


    // getters and setters...
}