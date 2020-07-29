package com.lucius.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * token���ɺ�У��
 * @author ouyangjun
 */
public class TokenTest {

	private static Map<String,String> MAP_TOKENS = new HashMap<String,String>();
	private static final int VALID_TIME = 60*60*2; // token有效期(秒)
	public static final String TOKEN_ERROR = "F"; // 非法
	public static final String TOKEN_OVERDUE = "G"; // 过期
	public static final String TOKEN_FAILURE = "S"; // 失效


	public static String getToken(String str) {
		String token = TokenEncryptUtils.encoded(getCurrentTime()+","+str);
		MAP_TOKENS.put(str, token);
		return token;
	}


	public static String checkToken(String token) {
		if (token == null) {
			return TOKEN_ERROR;
		}
		try{
			String[] tArr = TokenEncryptUtils.decoded(token).split(",");
			if (tArr.length != 2) {
				return TOKEN_ERROR;
			}
			// token����ʱ���
			int tokenTime = Integer.parseInt(tArr[0]);
			// ��ǰʱ���
			int currentTime = getCurrentTime();
			if (currentTime-tokenTime < VALID_TIME) {
				String tokenStr = tArr[1];
				String mToken = MAP_TOKENS.get(tokenStr);
				if (mToken == null) {
					return TOKEN_OVERDUE;
				} else if(!mToken.equals(token)) {
					return TOKEN_FAILURE;
				}
				return tokenStr;
			} else {
				return TOKEN_OVERDUE;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return TOKEN_ERROR;
	}


	public static int getCurrentTime() {
		return (int)(System.currentTimeMillis()/1000);
	}


	public static void removeInvalidToken() {
		int currentTime = getCurrentTime();
		for (Entry<String,String> entry : MAP_TOKENS.entrySet()) {
			String[] tArr = TokenEncryptUtils.decoded(entry.getValue()).split(",");
			int tokenTime = Integer.parseInt(tArr[0]);
			if(currentTime-tokenTime > VALID_TIME){
				MAP_TOKENS.remove(entry.getKey());
			}
		}
	}


//	public static void main(String[] args) {
//		String str = "admin_and_123456";
//
//
//		String token = TokenTest.getToken(str);
//		System.out.println("token Result: " + token);
//
//
//		String checkToken = TokenTest.checkToken(token);
//		System.out.println("checkToken Result: " + checkToken);
//		if(str.equals(checkToken)) {
////		 5b465c5a4a4c5a40555b5f140e1e0c012c1404173a5e41465e4653
//			System.out.println("==>token verification succeeded!");
//		}
//
//	}

}
