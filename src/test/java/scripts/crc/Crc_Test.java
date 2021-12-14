package scripts.crc;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTestCrc;
import pom.Addnewclient;
import pom.ClientDeletion;
import pom.ImportCreditreport_Creditheroscore;
import pom.ImportCreditreport_Identityiq;
import pom.ImportCreditreport_MyScoreIQ;
import pom.ImportCreditreport_MyfreeScorenow;
import pom.ImportCreditreport_PrivacyGuard;
import pom.ImportCreditreport_Samplereport;
import pom.ImportCreditreport_SmartCredit;
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
		
//		ImportCreditreport_Samplereport importSamplereport=new ImportCreditreport_Samplereport (driver);
//		importSamplereport.importSamplereport(data);
		
//		ImportCreditreport_Identityiq importidentityiq=new ImportCreditreport_Identityiq (driver);
//		importidentityiq.importidentityiq(data);

//		ImportCreditreport_PrivacyGuard importPrivacyguard=new ImportCreditreport_PrivacyGuard (driver);
//		importPrivacyguard.importPrivacyGuard(data);
	
//		ImportCreditreport_MyScoreIQ importMyscoreiq=new ImportCreditreport_MyScoreIQ (driver);
//		importMyscoreiq.importMyScoreIQ(data);
		
//		ImportCreditreport_MyfreeScorenow importMyfreescorenow=new ImportCreditreport_MyfreeScorenow (driver);
//		importMyfreescorenow.importMyfreescorenow(data);

		ImportCreditreport_SmartCredit importSmartcredit=new ImportCreditreport_SmartCredit (driver);
		importSmartcredit.importSmartCredit(data);

//		ImportCreditreport_Creditheroscore importCreditheroscore=new ImportCreditreport_Creditheroscore (driver);
//		importCreditheroscore.importChs(data);
		
//		ClientDeletion  clientdelete=new ClientDeletion (driver);
//		clientdelete.clientdelete(data);
	}
}

