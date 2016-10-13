import com.mongodb.MongoClient;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by awi40 on 12/10/2016.
 */
public class mongoConnector {
    private String hostName;
    private int portNumber;

    @Step("To connect to <server> I need a host of <hostName> and a port of <portNumber>.")
    public void mongoConnector(String server, String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        try {
            mongo = new MongoClient(hostName, portNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("The number of dbs within <server> is <expectedNumberOfDBs>.")
    public void countDBs(String server, int expectedNumberOfDBs) throws UnknownHostException {
        mongo = new MongoClient(hostName, portNumber);
        List<String> dbs = mongo.getDatabaseNames();
//        for(String db : dbs) {
//            dbCounter++;
//        }
        int dbCounter = dbs.size();
        Assert.assertEquals("Number of DBs on "+server, expectedNumberOfDBs, dbCounter);
    }


    @Step("Each db will have a specified number of collections. <table>")
    public void implementation3(Object arg0) {

    }

    private MongoClient mongo;

}
