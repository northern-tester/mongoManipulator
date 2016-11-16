import com.mongodb.*;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;

import java.net.UnknownHostException;

import static java.lang.Integer.parseInt;

/**
 * Created by awi40 on 12/10/2016.
 */
public class mongoConnector {
    private String hostName;
    private int portNumber;

    @Step("Connect to <server> I need a host of <hostname> and a port of <portNumber>.")
    public void mongoConnector(String server, String hostName, int portNumber) throws UnknownHostException {
        this.portNumber = portNumber;
        this.hostName = hostName;
        mongo = new MongoClient(new ServerAddress(hostName, portNumber));
    }

    @Step("The mongo instance <server> cluster status is <clusterStatus>.")
    public void clusterIsTrueOrFalse(String server, Boolean clusterStatus) throws UnknownHostException {
        Boolean expectedClusterStatus = clusterStatus;
        Boolean isSlave = mongo.getReadPreference().isSlaveOk();
        Assert.assertTrue(expectedClusterStatus == isSlave);
    }


    @Step("The mongo instance <workstation> is set as <Primary>.")
    public void primaryIsTrueOrFalse(String server, String readPref) {

    }

    private MongoClient mongo;
}
