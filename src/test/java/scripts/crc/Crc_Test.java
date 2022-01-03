package scripts.crc;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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
//	@Test(dataProvider="logindataset",priority = 0)
//	public void CRC(String data) throws InterruptedException
//	{
//		login login=new login (driver);
//		login.loginScript(data);
//		
//		Addnewclient Addclient=new Addnewclient (driver);
//		Addclient.Addclient(data);
//		
//		ImportCreditreport_Samplereport importSamplereport=new ImportCreditreport_Samplereport (driver);
//		importSamplereport.importSamplereport(data);
//	}
	
	@Test(dataProvider="logindataset",priority = 1)
	public void CRCSamplereport(String data1) throws InterruptedException
	{
		logger = extent.startTest("CRCSamplereport");
		login login=new login (driver);
		login.loginScript(data1);
		
		Addnewclient Addclient=new Addnewclient (driver);
		Addclient.Addclient(data1);
	
	ImportCreditreport_Samplereport importSamplereport=new ImportCreditreport_Samplereport (driver);
	importSamplereport.importSamplereport(data1);
	
	}

//		@Test(dataProvider="logindataset",priority = 2)
//		public void CRCIq(String data1) throws InterruptedException
//		{
//			logger = extent.startTest("CRCIq");
//			login login=new login (driver);
//			login.loginScript(data1);
//			
//			Addnewclient Addclient=new Addnewclient (driver);
//			Addclient.Addclient(data1);
//		
//		ImportCreditreport_Identityiq importidentityiq=new ImportCreditreport_Identityiq (driver);
//		importidentityiq.importidentityiq(data1);
//			
//		}

//		@Test(dataProvider="logindataset",priority = 5)
//		public void CRCPrgud(String data2) throws InterruptedException
//		{
//			logger = extent.startTest("CRCPrgud");
//			login login=new login (driver);
//			login.loginScript(data2);
//			
//			Addnewclient Addclient=new Addnewclient (driver);
//			Addclient.Addclient(data2);
//		
//		ImportCreditreport_PrivacyGuard importPrivacyguard=new ImportCreditreport_PrivacyGuard (driver);
//		importPrivacyguard.importPrivacyGuard(data2);
//		}
	
//		@Test(dataProvider="logindataset",priority = 3)
//		public void CRCMysciq(String data3) throws InterruptedException
//		{
//			logger = extent.startTest("CRCMysciq");
//			login login=new login (driver);
//			login.loginScript(data3);
//			
//			Addnewclient Addclient=new Addnewclient (driver);
//			Addclient.Addclient(data3);
//		
//		ImportCreditreport_MyScoreIQ importMyscoreiq=new ImportCreditreport_MyScoreIQ (driver);
//		importMyscoreiq.importMyScoreIQ(data3);
//		
//		}
		@Test(dataProvider="logindataset",priority = 4)
		public void CRCMyfrescnow(String data4) throws InterruptedException
		{
			logger = extent.startTest("CRCMyfrescnow");
			login login=new login (driver);
			login.loginScript(data4);
			
			Addnewclient Addclient=new Addnewclient (driver);
			Addclient.Addclient(data4);
			
		ImportCreditreport_MyfreeScorenow importMyfreescorenow=new ImportCreditreport_MyfreeScorenow (driver);
		importMyfreescorenow.importMyfreescorenow(data4);
		
		}
		
		@Test(dataProvider="logindataset",priority = 5)
		public void CRCsmartcredit(String data5) throws InterruptedException
		{
			logger = extent.startTest("CRCsmartcredit");
			login login=new login (driver);
			login.loginScript(data5);
			
			Addnewclient Addclient=new Addnewclient (driver);
			Addclient.Addclient(data5);
			
		ImportCreditreport_SmartCredit importSmartcredit=new ImportCreditreport_SmartCredit (driver);
		importSmartcredit.importSmartCredit(data5);
		}
//		ImportCreditreport_Creditheroscore importCreditheroscore=new ImportCreditreport_Creditheroscore (driver);
//		importCreditheroscore.importChs(data);

//	@AfterMethod
//	@Parameters("email")
//	public void clientdelet(String data) throws InterruptedException 
//	{
//		ClientDeletion  clientdelete=new ClientDeletion (driver);
//		clientdelete.clientdelete(data);
//	}
	
}

