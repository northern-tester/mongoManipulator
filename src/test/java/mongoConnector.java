import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * Created by awi40 on 12/10/2016.
 */
public class mongoConnector {
    private String hostName;
    private int portNumber;

    @Step("To connect to <server> I need a host of <hostName> and a port of <portNumber>.")
    public void mongoConnector(String server, String hostName, int portNumber) throws UnknownHostException {
        this.hostName = hostName;
        this.portNumber = portNumber;
        mongo = new MongoClient(hostName, portNumber);
    }

    @Step("The number of dbs within <server> is <expectedNumberOfDBs>.")
    public void countDBs(String server, int expectedNumberOfDBs) throws UnknownHostException {
        mongo = new MongoClient(hostName, portNumber);
        List<String> dbs = mongo.getDatabaseNames();
        Assert.assertEquals("Number of DBs on "+server, expectedNumberOfDBs, dbs.size());
    }


    @Step("Each db will have a specified number of collections. <collectionsByDBTable>")
    public void iterateThroughDBsCountCollections(Table table) throws UnknownHostException {
        mongo = new MongoClient(hostName, portNumber);
        for(TableRow row : table.getTableRows()){
            String nextDB = row.getCell("DB");
            int noCollections = parseInt(row.getCell("Collections"));
            DB dbMongo = mongo.getDB(nextDB);
            Set<String> collectionNames = dbMongo.getCollectionNames();
            Assert.assertEquals(nextDB+" has the expected number of collections", noCollections, collectionNames.size());
        }
    }

    private MongoClient mongo;

}
