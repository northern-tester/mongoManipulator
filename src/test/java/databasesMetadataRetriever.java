import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * Created by awi40 on 18/10/2016.
 */
public class databasesMetadataRetriever {

    private String hostName;
    private int portNumber;

    @Step("The number of dbs within <server> is <expectedNumberOfDBs>.")
    public void countDBs(String server, int expectedNumberOfDBs) throws UnknownHostException {
        mongo = new MongoClient(new ServerAddress(hostName, portNumber));
        List<String> dbs = mongo.getDatabaseNames();
        Assert.assertEquals("Number of DBs on " + server, expectedNumberOfDBs, dbs.size());
    }


    @Step("Each db will have a specified number of collections. <collectionsByDBTable>")
    public void iterateThroughDBsCountCollections(Table table) throws UnknownHostException {
        mongo = new MongoClient(new ServerAddress(hostName, portNumber));
        for (TableRow row : table.getTableRows()) {
            String nextDB = row.getCell("DB");
            int noCollections = parseInt(row.getCell("Collections"));
            DB dbMongo = mongo.getDB(nextDB);
            Set<String> collectionNames = dbMongo.getCollectionNames();
            Assert.assertEquals(nextDB + " has the expected number of collections", noCollections, collectionNames.size());
        }
    }

    private MongoClient mongo;

}
