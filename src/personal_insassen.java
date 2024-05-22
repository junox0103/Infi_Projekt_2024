import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "personal_insassen")
public class personal_insassen {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = "personal_id")
    private Personal personal;

    @DatabaseField(foreign = true, columnName = "insassen_id")
    private Insassen insassen;

    public personal_insassen() {
        // ORMLite needs a no-arg constructor
    }

    public personal_insassen(Personal personal, Insassen insassen) {
        this.personal = personal;
        this.insassen = insassen;
    }

    // getters and setters...
}