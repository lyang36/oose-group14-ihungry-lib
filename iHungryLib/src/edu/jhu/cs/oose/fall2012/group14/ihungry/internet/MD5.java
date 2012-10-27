package edu.jhu.cs.oose.fall2012.group14.ihungry.internet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	/**
	 * get the md5 of all other strings.
	 * if you wanna ge the md5 of the uname, please use the getNameMd5
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String getMd5(String text) throws NoSuchAlgorithmException{
        byte[] bst = text.getBytes();
	 	MessageDigest md = MessageDigest.getInstance("MD5");
	 	md.update(bst);
        byte[] mdbytes = md.digest();
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
	
	/**
	 * get the md5 hush of the uname
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String getNameMd5(String text) throws NoSuchAlgorithmException{
		String fullMd5 = getMd5(text);
		return fullMd5.substring(0,CommunicationProtocol.OBJECT_ID_LENGTH);
	}
}

