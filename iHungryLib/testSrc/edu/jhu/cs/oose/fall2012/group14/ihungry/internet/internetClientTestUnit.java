package edu.jhu.cs.oose.fall2012.group14.ihungry.internet;

import static org.junit.Assert.*;
import org.junit.Test;


public class internetClientTestUnit {

	@Test
	public void test() {
		String a = CommunicationProtocol.construcSendingStr(
				CommunicationProtocol.FB_SIGN_NAME, CommunicationProtocol.FB_SIGN_PASSWD, 
				CommunicationProtocol.BUSI_LOGIN, "{\"name\": \"try\"}");
		System.out.println(a);
		System.out.println(CommunicationProtocol.getUnameFromReceivedStr(a));
		System.out.println(CommunicationProtocol.getPasswdFromReceivedStr(a));
		System.out.println(CommunicationProtocol.getRequestFromReceivedStr(a));
		System.out.println(CommunicationProtocol.getSupinfoFromReceivedStr(a));
		
		InternetClient client = new InternetClient();
		try {
			System.out.println(CommunicationProtocol.getRequestFromReceivedStr(client.sendAndGet(a, 30000)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
	}

}
