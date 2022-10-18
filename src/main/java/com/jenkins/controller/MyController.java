package com.jenkins.controller;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/api/{name}")
	public String gethii(@PathVariable("name") String name) {
		
		return "Hello" + name + "!";
	}
	
	@GetMapping("/api2/{name}")
	public String getName(@PathVariable("name") String name) {
		return "Hello" + name + "!";
	}
	
	
	
	public static void main5(String[] args) {
		
//		System.err.println(new SimpleDateFormat("HH:mm:ss").format(new Date())); 
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.putOpt("key", "010272E80");
		String str=XML.toString(jsonObject);
		System.err.println(str);
		System.err.println(XML.toJSONObject(str,true));
	}
	
	public static void main2(String[] args) {
		
		String obj="";
		try {
			
//			String str="{\\\"eReq\\\":\\\"ZjoUARJjcVqoVSrKJbppUNIT2xKR7du6fX6AoQwuZaNSruU99eiQToG/SudWvS9m3jbMV+2FUQUzDMb+8bbke4eaT3Oz5oen4HLvU90+wqNaRvRcwmg3UjqiYJ3XJ0pXknYFw1sHWsrij8tjE2g7GGrdc6RpIX5ma+aKwJKGHQwSTlgcDBRI4IJLgze0O9Zhz5vJhAs/e4dTswxHRlcSMPf6BK0Lgsqk4ZmkTGqWHd8M16tr0lxHs1SiLBTgdmxvImF1lsTgAbyuDVCCAjSVkafPjGZbmN8/nchq6qEJvqvI3i2p2SUnYP44JX3I+chXOIK4+p86weHLffZCday7gp25f25zD2XXu8Y7KQ9IVwvpifwrevlgCIFqTl7KkKiYznetyTKqMLvNFcfD82bgVxW9zcH/3qzIWg1QKO2e5VpZ7zOzFTycAsM7mwNWbX06VjCHjVM92CMu5Wt6qWjaAuLFM99AV/+rXuE0/DQgtEP7eXseBOT3od3/hlYJ/v/7IyDzg3JC53MsmumltvzWcMk9H9xSaK7s3bVnjfJ+yKb6c4jEDE2G6K8LDgVWRWahaBRVybwwon/NU6nM5+DSBuk99drVsQF4aHHQ3Mm/vp3FXMD92zzOW0xRehPRhGhyXNEPmvuVV7Un5ldO0ehUrPVBRyJSwZhpHlUT9Hg+6WAbGAZxAcVSCizg+AmL6cdD7/ZIFAhZGokuGL6hYOUvA7I0+Zja7TNhm6JAizocCPsep1cbU1BFE0v0CuX3rPGUMO7faWP/tF6Xr4HhNBH4JVigr4Za8Fa2mHdCESLSqC4277iTGtcFg1kDITPK2myDzUCPP/ndqSCoOGYpJtA7AOesKbGpn116JK1CXj8E1ruQ9s4H1EtT+ShCCF+W+WqRCc/5++W4JYszz/M+gRSZ6Hh94MIeKtrA+6E3DxWWqQ28S5KLtYuG33gAmSValutksnMDK0bsq08e/oPoaNvVxZR/7VtUh+yFw3PmS1PxCkk=\\\"}";
//			JSONObject jsonObject = new JSONObject(str);
			obj = generateAESDecryption("53fbc6b9ab19d7572485926ac0aa7acc","ZjoUARJjcVqoVSrKJbppUNIT2xKR7du6fX6AoQwuZaNSruU99eiQToG/SudWvS9m3jbMV+2FUQUzDMb+8bbke4eaT3Oz5oen4HLvU90+wqNaRvRcwmg3UjqiYJ3XJ0pXknYFw1sHWsrij8tjE2g7GGrdc6RpIX5ma+aKwJKGHQwSTlgcDBRI4IJLgze0O9Zhz5vJhAs/e4dTswxHRlcSMPf6BK0Lgsqk4ZmkTGqWHd8M16tr0lxHs1SiLBTgdmxvImF1lsTgAbyuDVCCAjSVkafPjGZbmN8/nchq6qEJvqvI3i2p2SUnYP44JX3I+chXOIK4+p86weHLffZCday7gp25f25zD2XXu8Y7KQ9IVwvpifwrevlgCIFqTl7KkKiYznetyTKqMLvNFcfD82bgVxW9zcH/3qzIWg1QKO2e5VpZ7zOzFTycAsM7mwNWbX06VjCHjVM92CMu5Wt6qWjaAuLFM99AV/+rXuE0/DQgtEP7eXseBOT3od3/hlYJ/v/7IyDzg3JC53MsmumltvzWcMk9H9xSaK7s3bVnjfJ+yKb6c4jEDE2G6K8LDgVWRWahaBRVybwwon/NU6nM5+DSBuk99drVsQF4aHHQ3Mm/vp3FXMD92zzOW0xRehPRhGhyXNEPmvuVV7Un5ldO0ehUrPVBRyJSwZhpHlUT9Hg+6WAbGAZxAcVSCizg+AmL6cdD7/ZIFAhZGokuGL6hYOUvA7I0+Zja7TNhm6JAizocCPsep1cbU1BFE0v0CuX3rPGUMO7faWP/tF6Xr4HhNBH4JVigr4Za8Fa2mHdCESLSqC4277iTGtcFg1kDITPK2myDzUCPP/ndqSCoOGYpJtA7AOesKbGpn116JK1CXj8E1ruQ9s4H1EtT+ShCCF+W+WqRCc/5++W4JYszz/M+gRSZ6Hh94MIeKtrA+6E3DxWWqQ28S5KLtYuG33gAmSValutksnMDK0bsq08e/oPoaNvVxZR/7VtUh+yFw3PmS1PxCkk="); 
//			obj = generateAESDecryption("53fbc6b9ab19d7572485926ac0aa7acc", "SmhMS1JsGoFvhOHzg/YQdFW86Nb5T1wCSq2+7qXMBARJGsajmsRGe+nO76W56f4uNiD+Y0VuJUFBTtOZSbG9PA==");
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(obj);
		
	}
	
	public static String generateAESDecryption(String sercretKey, String message)
            throws IllegalBlockSizeException, BadPaddingException {
        String base64EncryptedString = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digestOfPassword = md.digest(sercretKey.getBytes(StandardCharsets.UTF_8));
            //System.out.println(" Message Digest Byte[] String : " + digestOfPassword);
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            byte[] iv = Arrays.copyOf(digestOfPassword, 16);
            //System.out.println(" keyBytes Byte[] String : " + digestOfPassword);
            //System.out.println(" iv Byte[] String : " + digestOfPassword);
            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
                try {
                    cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                    e.printStackTrace();
                }
                return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return base64EncryptedString;
    }
	
	
	
	
	
	
}
