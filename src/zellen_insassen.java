import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "zellen_insassen")
public class zellen_insassen {

    @DatabaseField(generatedId = true)
    private int idzi;

    @DatabaseField(foreign = true, columnName = "zellen_id")
    private Zelle zelle;

    @DatabaseField(foreign = true, columnName = "insassen_id")
    private Insassen insassen;

    public zellen_insassen() {
        // ORMLite needs a no-arg constructor
    }

    public zellen_insassen(Zelle zelle, Insassen insassen) {
        this.zelle = zelle;
        this.insassen = insassen;
    }

    public int getIdzi() {
        return idzi;
    }

    public void setIdzi(int idzi) {
        this.idzi = idzi;
    }

    public Zelle getZelle() {
        return zelle;
    }

    public void setZelle(Zelle zelle) {
        this.zelle = zelle;
    }

    public Insassen getInsassen() {
        return insassen;
    }

    public void setInsassen(Insassen insassen) {
        this.insassen = insassen;
    }

    // getters and setters...
}