import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Zelle")
public class Zelle {

    @DatabaseField(id = true, columnName = "IDZ")
    private String idz;

    @DatabaseField( columnName = "Platz")
    private int platz;



    public Zelle() {
        // ORMLite needs a no-arg constructor
    }

    public Zelle(String idz, int platz) {
        this.idz = idz;
        this.platz = platz;
        }

    // getters and setters...
}