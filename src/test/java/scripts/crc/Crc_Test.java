package scripts.crc;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTestCrc;
import pom.Addnewclient;
import pom.ClientDeletion;
import pom.ImportCreditreport_Identityiq;
import pom.ImportCreditreport_Samplereport;
import pom.login;

public class Crc_Test extends BaseTestCrc
{
	@Test(dataProvider="logindataset")
	public void CRC(String data) throws InterruptedException
	{
		login login=new login (driver);
		login.loginScript(data);
		
		Addnewclient Addclient=new Addnewclient (driver);
		Addclient.Addclient(data);
		
//		ImportCreditreport_Identityiq importidentityiq=new ImportCreditreport_Identityiq (driver);
//		importidentityiq.importidentityiq(data);
		
		ImportCreditreport_Samplereport importSamplereport=new ImportCreditreport_Samplereport (driver);
		importSamplereport.importSamplereport(data);
		
		ClientDeletion  clientdelete=new ClientDeletion (driver);
		clientdelete.clientdelete(data);
	}
}

