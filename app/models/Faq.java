package models;

import java.util.List;
import org.bson.types.ObjectId;
import play.data.validation.Constraints.Required;
import com.google.code.morphia.annotations.Entity;
import java.util.ArrayList;
import static models.BaseModel.ds;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity(noClassnameStored=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Faq extends BaseModel {

    @Required
    public String question;
    @Required
    public String answer;
    public int ordinal;
    @Required
    public List<String> categories = new ArrayList<String>();
    
    public static Faq find(String id) {
        return ds.find(Faq.class).field("_id").equal(new ObjectId(id)).get();
    }

    public static List<Faq> all() {
        return allItems(Faq.class);
    }

    public static void save(Faq item) {
        saveItem(item);
    }

    public static void delete(String idToDelete) {
        deleteItem(Faq.class, find(idToDelete));
    }

    @Override
    public String toString() {
        return super.toString()
                + ","
                + question
                + ","
                + answer;
    }
}