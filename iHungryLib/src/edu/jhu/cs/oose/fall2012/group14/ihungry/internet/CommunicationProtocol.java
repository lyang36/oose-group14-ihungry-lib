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
	public static String SERVER_IP_ADDRESS = "10.164.206.34";//"mantiqueira.sdss.pha.jhu.edu";
	public static int SERVER_PORT = 12014;
	
	/**
	 * server command strings
	 */
	/**
	 * The length of ObjectId length
	 */
	public static final int OBJECT_ID_LENGTH = 24;
	
	public static final int PASSWD_MD5_LENGTH = 32;
	public static final int COMMAND_MD5_LENGTH = 32;

	
	
	
	public static final String STRING_STARTER = "&{";
	public static final String STRING_ENDER = "}&";
	public static final String COMMAND_STARTER = "[";
	public static final String COMMAND_ENDER = "]";
	public static final String SUPINFO_STARTER = "<";
	public static final String SUPINFO_ENDER = ">";
	
	
	public static final String ENDLN = "\n";
	
	/**
	 * server commands for costumer
	 */
	public static final String LOGOUT = 					"6b4ea69e17243db95f7b46c384d40370";
	public static final String LOGIN = 						"4976d7ca80f2cb54c1c7d5c87fb0c7ef";
	public static final String CUS_GET_REALNAME = 			"6b2b26dca120b5cf60141616fc1cbbdc";
	public static final String CUS_GET_EMAIL = 				"802acd3a5c293d972012b1c661016361";
	public static final String CUS_GET_PHONE = 				"50ac95b5fa5a0b706e7f17f2ee2d445d";
	public static final String CUS_GET_DOCUMENT = 			"6168ef79939d6726b7c6fdcfa31a6eb9";
	public static final String CUS_SIGN_UP = 				"c5b5ff973838ac99e7c742e4dd7a5cbd";
	public static final String CUS_CHECK_UNAME_EXISTED = 	"84f9e49f3d924ff032c5ef394aa08bdf";
	
	/**
	 * Use a md5 of facebook to login
	 * Return back the md5 of username and password
	 * If there is a ID return processNotSuccessful
	 */
	public static final String SIGN_IN_WITH_FACEBOOK = 		"aac875e2a872ef1f5be8b3a5d38926c5";
	/**
	 * Used for facebook signin default password and uname
	 */
	public static final String FB_SIGN_NAME =				"ddad8792734aebb4cf9a68fd";
	public static final String FB_SIGN_PASSWD = 			"aed78ba066b3d94e190c215ed7834bac";
	
	public static final String CUS_SET_REALNAME = 			"18798ace2c8cbe9825f21d5f0468eac1";
	public static final String CUS_SET_EMAIL = 				"8ef30075f2a0b09a50bad7049db8b0cc";
	public static final String CUS_SET_PHONE = 				"1dba9d26a4cd11aa4d319c109ec8d396";
	public static final String CUS_SET_BIRTH = 				"aa260f4591199dde2715f2f7516a42af";
	public static final String CUS_UPDATE_DOC = 			"d4cc61b5adfda1a4d189abad44b0f9ed";
	
	public static final String CUS_FIND_RESTAURANT = 		"20b56c0a6dac7f00edef0fc8180657e3";
	public static final String CUS_GET_MENU		  =			"79907ca0920678ded973e1c7c3fde9d1";
	public static final String CUS_SUBMIT_ORDER 	  =		"18fc1c45a61ac49fd563875a69fc7fed";
	public static final String CUS_UPDATE_ORDER 	  =		"13ac2330ef57b95dc1bfe48f45f054c5";
	public static final String CUS_RETRIVE_ORDER  =			"428966c09b471f152472f221d30476c6";
	public static final String CUS_RETRIVE_CHANGED_ORDER = 	"bd472871498f04ffee93a6c6c3980b0e";
	
	/**
	 * server return back commands
	 */
	public static final String LOGIN_ERROR = 				"30633a672f73c73aba3d0ad89007f6df";
	public static final String LOGIN_SUCCESS = 				"c9310bb27bac687cd17693283716a406";
	public static final String PROCESS_SUCCEEDED = 			"6444872fd02348b2766aa7c05f2bb07c";
	public static final String PROCESS_FAILED = 			"0961ae56b3fea125e9ec673eee808f9e";
	public static final String UNAME_EXISTED = 				"8423fbd05632a96738012f4637020060";
	public static final String FALSE	=					"c844b4fc273be9b843233e8a905fa229";
	public static final String NO_SUCH_COMMAND = 			"4025c58f2cc591296e06d40deb42a369";
	public static final String TRUE =						"6c65b271834a16ffaeedc48ab385f675";
		
	
	/**
	 * Business util
	 */
	public static final String BUSI_LOGIN = 				"f4cb213d54f9344dbf4aa77a2deb1b6f";
	public static final String BUSI_SIGNUP = 				"b5faedba1c8eb07ef588b500f6d68f9d";
	public static final String BUSI_CHECK_UNAME_EXISTED = 	"aa1c7d9580569252f3ab9d886049e934";
	
	/**
	 * for orders 
	 */
	public static final String BUSI_RETRIVE_ORDERS = 		"ad467bd4668f00f1ec3ce32df7c2ebfa";
	public static final String BUSI_RETRIVE_CHANGED_ORDERS ="536dbc9b3cd19e1485b3fd0926e26b44";
	public static final String BUSI_PROCESS_ORDER = 		"8ef14e8985c487bb0025e9c4a6ae8d0a";
	public static final String BUSI_UPLOAD_MENU	=			"ede53d1160437918f486bad4a7625f68";
	public static final String BUSI_UPDATE_MENU	=			"19a3a67078a026f331d721ed28c98101";
	
	
	
	
	
	/**
	 * pack the uname, passwd, command, supInfo to a string that 
	 * could be used in InternetUtil.sendAndGet()
	 * @param md5uname
	 * @param md5pass
	 * @param md5Command
	 * @param supInfo
	 * @return
	 */
	public static final String construcSendingStr(String md5uname, String md5pass, 
			String md5Command, String supInfo){
		return encrypt(packMsg(packStr(md5uname + md5pass + md5Command, supInfo)));
	}
	
	
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
		return CommunicationProtocol.COMMAND_STARTER +	//[
    			commandString +
    			CommunicationProtocol.COMMAND_ENDER +	//]
    			CommunicationProtocol.SUPINFO_STARTER+	//<
    			suppliInfo+
    			CommunicationProtocol.SUPINFO_ENDER;		//>
	}
	
	/**
	 * pack the message from a packed string (e.g. [Command]<<>SupInfo>) 
	 * @param msg
	 * @return
	 */
	public static final String packMsg(String msg){
		return CommunicationProtocol.STRING_STARTER + msg+
				CommunicationProtocol.STRING_ENDER;
	}
	
	/**
	 * unpack the message from the packed message (eg.. &{[Command]<<>SupInfo>}&)
	 * @param msg
	 * @return
	 */
	public static final String unPackMsg(String msg){
		if(msg.indexOf(STRING_STARTER) > -1){
			if(msg.indexOf(STRING_ENDER) > -1){
				return msg.substring(msg.indexOf(STRING_STARTER)+STRING_STARTER.length(),
						msg.indexOf(STRING_ENDER));
			}
		}
		return "";
	}
	
	
	
	/**
	 * get the command from the unpacked message (from unpackMsg(msg))
	 * @param str
	 * @return
	 */
	public static final String getCommandStr(String str){
		int startin = str.indexOf(COMMAND_STARTER);
		int endin = str.indexOf(COMMAND_ENDER);
		if( startin == -1 || endin == -1){
			return null;
		}

		String command = str.substring(startin+COMMAND_STARTER.length(), endin);
		command = command.trim();
		return command;
	}
	
	
	/**
	 * get the supInfo directly from the received string by InternetClient.sendAndGet
	 * This str is actually a encrypted one.
	 * This method will decrypt, unpack and get the string automatically
	 * @param str
	 * @return
	 */
	public static final String getSupinfoFromReceivedStr(String str){
		return getSupinfo(unPackMsg(decrypt(str)));
	}
	
	
	/**
	 * get the suppliInfo from the unpacked message (from unpackMsg(msg))
	 * @param str
	 * @return
	 */
	public static final String getSupinfo(String str){
		int startin = str.indexOf(SUPINFO_STARTER);
		int endin = str.indexOf(SUPINFO_ENDER);
		if( startin == -1 || endin == -1){
			return "";
		}
		//System.out.println("supString: " + str.substring(startin + SUPINFO_STARTER.length(), endin));
		return str.substring(startin + SUPINFO_STARTER.length(), endin);
	}
	
	/**
	 * get the username directly from the received string by InternetClient.sendAndGet
	 * This str is actually a encrypted one.
	 * This method will decrypt, unpack and get the string automatically
	 * @param str
	 * @return
	 */
	public static final String getUnameFromReceivedStr(String str){
		return getUname(getCommandStr(unPackMsg(decrypt(str))));
	}
	

	
	/**
	 * get the username from the command string
	 * @param command
	 * @return
	 */
    public static String getUname(String command){
    	return command.substring(0, OBJECT_ID_LENGTH);
    }
    
    
	/**
	 * get the passwd directly from the received string by InternetClient.sendAndGet
	 * This str is actually a encrypted one.
	 * This method will decrypt, unpack and get the string automatically
	 * @param str
	 * @return
	 */
	public static final String getPasswdFromReceivedStr(String str){
		return getPasswd(getCommandStr(unPackMsg(decrypt(str))));
	}
	
    
    
    /**
     * get the password from the command string
     * @param command
     * @return
     */
    public static String getPasswd(String command){
    	return command.substring(OBJECT_ID_LENGTH, OBJECT_ID_LENGTH+PASSWD_MD5_LENGTH);
    }
    
    
	/**
	 * get the ReqestCode directly from the received string by InternetClient.sendAndGet
	 * This str is actually a encrypted one.
	 * This method will decrypt, unpack and get the string automatically
	 * @param str
	 * @return
	 */
	public static final String getRequestFromReceivedStr(String str){
		return getRequest(getCommandStr(unPackMsg(decrypt(str))));
	}
	
	
    /**
     * get the reuqest command from the command string
     * @param command
     * @return
     */
    public static String getRequest(String command){
    	return command.substring(OBJECT_ID_LENGTH+PASSWD_MD5_LENGTH, OBJECT_ID_LENGTH 
    			+ PASSWD_MD5_LENGTH + COMMAND_MD5_LENGTH);
    }
    
	
}
