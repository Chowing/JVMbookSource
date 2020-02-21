package geym.zbase.ch11.agent;

import geym.zbase.ch11.aop.timestat.Account;

/**
 * -javaagent d:/ja.jar
 * 
 * -javaagent:d:/jat.jar=argument
 * @author Administrator
 *
 */
public class RunAccountMain {
	 public static void main(String[] args) { 
		 Account account = new Account(); 
		 account.operation(); 
	 } 
}
