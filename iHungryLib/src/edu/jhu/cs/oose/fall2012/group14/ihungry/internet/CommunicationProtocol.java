package edu.jhu.cs.oose.fall2012.group14.ihungry.internet;


/**
 * The connection protocol of all the 3 parts of the program.
 * 
 * @author lyang
 *
 */
public class CommunicationProtocol {
	/**
	 * basic connection parameters
	 */
	public static String serverIpAddress = "mantiqueira.sdss.pha.jhu.edu";
	public static int serverPort = 12014;
	
	/**
	 * server command strings
	 */
	/**
	 * The length of ObjectId length
	 */
	private static final int objectIdLength = 24;
	
	private static final int passWDMD5Length = 32;
	private static final int commandMD5Length = 32;
	
	
	/**
	 * Encrypt the message
	 * @param str
	 * @return
	 */
	public static final String encrypt(String str){
		return str;
	}
	
	/**
	 * Decrypte the message
	 * @param str
	 * @return
	 */
	public static final String decrypt(String str){
		return str;
	}
	
	/**
	 * pack the commandString and suppliInfo to be a packed string
	 * @param returnString
	 * @param returnSupString
	 * @return
	 */
	public static final String packStr(String commandString, String suppliInfo){
		return CommunicationProtocol.commandStarter +	//[
    			commandString +
    			CommunicationProtocol.commandEnder +	//]
    			CommunicationProtocol.supInfoStarter+	//<
    			suppliInfo+
    			CommunicationProtocol.supInfoEnder;		//>
	}
	
	/**
	 * pack the message from a packed string
	 * @param msg
	 * @return
	 */
	public static final String packMsg(String msg){
		return CommunicationProtocol.stringStarter + msg+
				CommunicationProtocol.stringEnder;
	}
	
	/**
	 * unpack the message from the packed message
	 * @param msg
	 * @return
	 */
	public static final String unPackMsg(String msg){
		if(msg.indexOf(stringStarter) > -1){
			if(msg.indexOf(stringEnder) > -1){
				return msg.substring(msg.indexOf(stringStarter)+stringStarter.length(),
						msg.indexOf(stringEnder));
			}
		}
		return "";
	}
	
	/**
	 * get the command from the unpacked message
	 * @param str
	 * @return
	 */
	public static final String getCommandStr(String str){
		int startin = str.indexOf(commandStarter);
		int endin = str.indexOf(commandEnder);
		if( startin == -1 || endin == -1){
			return null;
		}

		String command = str.substring(startin+commandStarter.length(), endin);
		command = command.trim();
		return command;
	}
	
	/**
	 * get the suppliInfo from the unpacked message
	 * @param str
	 * @return
	 */
	public static final String getSupinfo(String str){
		int startin = str.indexOf(supInfoStarter);
		int endin = str.indexOf(supInfoEnder);
		if( startin == -1 || endin == -1){
			return "";
		}
		System.out.println("supString: " + str.substring(startin + supInfoStarter.length(), endin));
		return str.substring(startin + supInfoStarter.length(), endin);
	}
	
	
	
	public static final String stringStarter = "&{";
	public static final String stringEnder = "}&";
	public static final String commandStarter = "[";
	public static final String commandEnder = "]";
	public static final String supInfoStarter = "<";
	public static final String supInfoEnder = ">";
	
	
	public static final String endln = "\n";
	
	/**
	 * server commands for costumer
	 */
	public static final String logOut = 			"6b4ea69e17243db95f7b46c384d40370";
	public static final String logIn = 				"4976d7ca80f2cb54c1c7d5c87fb0c7ef";
	public static final String cusGetRealName = 	"6b2b26dca120b5cf60141616fc1cbbdc";
	public static final String cusGetUserEmail = 		"802acd3a5c293d972012b1c661016361";
	public static final String cusGetUserPhone = 		"50ac95b5fa5a0b706e7f17f2ee2d445d";
	public static final String cusGetUserGender = 		"921f72d31895beef8805fdec1f6b0ff7";
	public static final String cusGetUserBirth = 		"b6676a93784cf7d45953c809a235f2e3";
	public static final String cusGetUserDoc = 		"6168ef79939d6726b7c6fdcfa31a6eb9";
	public static final String cusSignIn = 			"c5b5ff973838ac99e7c742e4dd7a5cbd";
	public static final String cusCheckUnameExist = 	"84f9e49f3d924ff032c5ef394aa08bdf";
	
	/**
	 * Use a md5 of facebook to login
	 * Return back the md5 of username and password
	 * If there is a ID return processNotSuccessful
	 */
	public static final String signInWithFaceBook = "aac875e2a872ef1f5be8b3a5d38926c5";
	/**
	 * Used for facebook signin default password and uname
	 */
	public static final String fbSignUname =		"ddad8792734aebb4cf9a68fd";
	public static final String fbSignPasswd = 		"aed78ba066b3d94e190c215ed7834bac";
	
	public static final String cusSetRealName = 	"18798ace2c8cbe9825f21d5f0468eac1";
	public static final String cusSetEmail = 		"8ef30075f2a0b09a50bad7049db8b0cc";
	public static final String cusSetPhone = 		"1dba9d26a4cd11aa4d319c109ec8d396";
	public static final String cusSetBirth = 		"aa260f4591199dde2715f2f7516a42af";
	public static final String cusUpdateDoc = 		"d4cc61b5adfda1a4d189abad44b0f9ed";
	
	public static final String cusFindRestaurant = 	"";
	public static final String cusGetMenu		  =		"";
	public static final String cusSubmitOrder 	  =		"";
	public static final String cusUpdateOrder 	  =		"";
	public static final String cusRetriveOrders  =		"";
	public static final String cusRetriveChangedOrders = "";
	
	/**
	 * server return back commands
	 */
	public static final String errorLogin = 		"30633a672f73c73aba3d0ad89007f6df";
	public static final String successLogin = 		"c9310bb27bac687cd17693283716a406";
	public static final String successProcessed = 	"6444872fd02348b2766aa7c05f2bb07c";
	public static final String processNotSuccessful = 	"0961ae56b3fea125e9ec673eee808f9e";
	public static final String usenameExisted = 	"8423fbd05632a96738012f4637020060";
	public static final String iHungryFalse	=		"c844b4fc273be9b843233e8a905fa229";
	public static final String noSuchCommand = 		"4025c58f2cc591296e06d40deb42a369";
	public static final String iHungryTrue =		"6c65b271834a16ffaeedc48ab385f675";
		
	
	/**
	 * Business util
	 */
	public static final String busiLogin = 			"f4cb213d54f9344dbf4aa77a2deb1b6f";
	public static final String busiSignup = 		"b5faedba1c8eb07ef588b500f6d68f9d";
	public static final String busiCheckUnameExist = "";
	
	/**
	 * for orders 
	 */
	public static final String busiRetriveOrders = 			"";
	public static final String busiRetriveChangedOrders =   "";
	public static final String busiProcessOrder = 			"";
	public static final String busiUpLoadMenu	=			"";
	public static final String busiUpdateMenu	=			"";
	
	
	
	
    public static String getUname(String command){
    	return command.substring(0, objectIdLength);
    }
    
    public static String getPasswd(String command){
    	return command.substring(objectIdLength, objectIdLength+passWDMD5Length);
    }
    
    public static String getRequest(String command){
    	return command.substring(objectIdLength+passWDMD5Length, objectIdLength+passWDMD5Length+commandMD5Length);
    }
    
	
}
