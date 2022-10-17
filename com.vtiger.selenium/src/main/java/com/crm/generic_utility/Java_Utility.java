package com.crm.generic_utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to avoi duplicate
	 * @return
	 * @author Santhosh
	 */

   public int getRandomNum() {
	   Random ran=new Random();
	   int ranNum = ran.nextInt(1000);
	   return ranNum;
   }
}
