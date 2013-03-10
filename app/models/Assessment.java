package models;

import java.util.List;
import org.bson.types.ObjectId;
import play.data.validation.Constraints.Required;
import com.google.code.morphia.annotations.Entity;
import static models.BaseModel.ds;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assessment extends BaseModel {

    @Required
    public Response[] responses;
    @Required
    public Score score;

    public static Assessment find(String id) {
        return ds.find(Assessment.class).field("_id").equal(new ObjectId(id)).get();
    }

    public static List<Assessment> all() {
        return allItems(Assessment.class);
    }

    public static void save(Assessment item) {
        saveItem(item);
    }

    public static void delete(String idToDelete) {
        deleteItem(Assessment.class, find(idToDelete));
    }
}