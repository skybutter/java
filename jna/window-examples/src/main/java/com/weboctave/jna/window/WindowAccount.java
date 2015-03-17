package com.weboctave.jna.window;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Advapi32Util.Account;

/**
 * This sample code show how to get Window username and domain name using Window API.
 * @author skybutter
 *
 */
public class WindowAccount {

	public static void main(String[] args) {
		String username = getUserName();
		String domain = getDomainName();
		System.out.println("Your username:" + username);
		System.out.println("Your domain:" + domain);
	}

    public static synchronized String getUserName() {
        try {
            return Advapi32Util.getUserName();
        } catch (java.lang.UnsatisfiedLinkError e) {
        	e.printStackTrace();
        } catch (Error e) {
        	e.printStackTrace();
        }
        return null;
    }
    public static synchronized String getDomainName() {
        try {
            String userName = getUserName();
            Account accountByName = Advapi32Util.getAccountByName(userName);
            return accountByName.domain;                        
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }


}
