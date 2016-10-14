import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;

/**
 * Created by awi40 on 14/10/2016.
 */
public class collectionsMetadataRetriever {

    @Step("The number of documents within the <collection> collection within the <db> db is <expectedNoDocs>.")
    public void checkNumberDocumentsInCollection(String collection, String db, int expectedNoDocs) {

    }

    @Step("Each collection within <db> will have a specified number of documents. <table>")
    public void checkNumberDocumentsInCollections(String db, Table table) {

    }

    @Step("The <collection> collection within the <db> db will have the following attributes. <table>")
    public void getCollectionMetadata(String collection, String db, Table table) {

    }
}
