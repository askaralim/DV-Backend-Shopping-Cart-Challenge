package com.bcg.dv.shoppingcart.util;

import java.util.UUID;

public class IdGenerator {
	public static String genId(){
		return UUID.randomUUID().toString();
	}
}
