package org.jbros.webro.util;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sha256Util {
   private static Logger logger = LoggerFactory.getLogger(Sha256Util.class);
   private static String AES_KEY = "d1e98b636b5c837334380083d12fd242";
   
   /**
    * AESEncrypt
    * @param plainText
    * @return
    * @throws UnsupportedEncodingException 
    * @throws BadPaddingException 
    * @throws IllegalBlockSizeException 
    * @throws NoSuchPaddingException 
    * @throws NoSuchAlgorithmException 
    * @throws InvalidKeyException 
    * @throws Exception
    */
   public static String AESEncrypt(String plainText) 
         throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, 
         IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
      AESCipher crypt = AESCipher.getInstance();
      crypt.setSecretKey(AES_KEY);
      String encryptedText = crypt.AESEncrypt(plainText);
      
      logger.debug("plainText: {}, encryptedText: {}", plainText, encryptedText);
      return encryptedText;
   }

   /**
    * ASEDecrypt
    * @param encryptedText
    * @return
    * @throws DecoderException 
    * @throws UnsupportedEncodingException 
    * @throws BadPaddingException 
    * @throws IllegalBlockSizeException 
    * @throws NoSuchPaddingException 
    * @throws NoSuchAlgorithmException 
    * @throws InvalidKeyException 
    * @throws Exception
    */
   public static String AESDecrypt(String encryptedText) 
         throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, 
         IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, 
         DecoderException {
      AESCipher crypt = AESCipher.getInstance();
      crypt.setSecretKey(AES_KEY);
      String plainText = crypt.AESDecrypt(encryptedText);
      
      logger.debug("encryptedText: {}, plainText: {}", encryptedText, plainText);
      return plainText;
   }
   
   /**
    * AES-256 Encryption
    * @param plainText 평문
    * @return
    * @throws UnsupportedEncodingException 
    * @throws BadPaddingException 
    * @throws IllegalBlockSizeException 
    * @throws InvalidAlgorithmParameterException 
    * @throws NoSuchPaddingException 
    * @throws NoSuchAlgorithmException 
    * @throws InvalidKeyException 
    * @throws Exception
    */
   public static String AES256Encode(String plainText) 
         throws InvalidKeyException, NoSuchAlgorithmException, 
         NoSuchPaddingException, InvalidAlgorithmParameterException, 
         IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
      logger.debug("plain text: {}", plainText);
      
      AES256Cipher aes256 = AES256Cipher.getInstance();
      aes256.setSecretKey(AES_KEY);
      String encryptedStr = aes256.AES256Encode(plainText);
      
      logger.debug("encryption text: {}", encryptedStr);
      return encryptedStr;
   }
   
   public static String AES256Decode(String encryptedStr) throws Exception {
      logger.debug("encryptio text: {}", encryptedStr);
      
      AES256Cipher aes256 = AES256Cipher.getInstance();
      aes256.setSecretKey(AES_KEY);
      String plainText = aes256.AES256Decode(encryptedStr);
      
      logger.debug("plain text: {}", plainText);
      return plainText;
   }

   /**
    * MD5
    * @param plainText
    * @return
    * @throws Exception
    */
   public static String MD5(String plainText) throws Exception {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes());
      byte[] md5 = md.digest();
      
      String md5HashedText = Hex.encodeHexString(md5); 
      logger.debug("plainText: {}, MD5: {}", plainText, md5HashedText);
      
      return md5HashedText;
   }
   
   
   /**
    * SHA1
    * @param plainText
    * @return
    * @throws Exception
    */
   public String SHA1(String plainText) throws Exception {
      MessageDigest md = MessageDigest.getInstance("SHA1");
      md.update(plainText.getBytes());
      byte[] sha1 = md.digest();

      String sha1Text = Hex.encodeHexString(sha1);
      logger.debug("plainText: {}, SHA1: {}", plainText, sha1Text);
      
      return sha1Text;
   }
   
   /**
    * SHA-256
    * @param plainText         암호화를 할 평문
    * @return            암호화된 결과
    * @throws Exception
    */
   public static String SHA256(String plainText) throws SecurityException {
      String SHA = ""; 
      
      try{
         MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
         sh.update(plainText.getBytes()); 
         
         byte byteData[] = sh.digest();
         StringBuffer sb = new StringBuffer();
         
         for(int i = 0 ; i < byteData.length ; i++){
            sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
         }
         
         SHA = sb.toString();
         
      } catch(NoSuchAlgorithmException e){
         logger.error("SHA-256 Exception", e);
         throw new SecurityException("SHA-256 Exception", e);
//         SHA = null; 
      }
      
      logger.debug("plainText: {}, SHA256: {}", plainText, SHA);
      return SHA;
   }
   
   public static long CRC32(String plainText) {
      Checksum crc = new CRC32();
      crc.update(plainText.getBytes(), 0, plainText.getBytes().length);
      
      long crc32 = crc.getValue(); 
      logger.debug("plainText: {}, CRC32: {}", plainText, crc32);
      
      return crc32;
   }
   
   /**
    * 지정된 범위 안의 랜덤 정수를 생성한다.
    * @param start      시작번호
    * @param end      종료번호
    * @return
    */
   public static int getRandomNum(int start, int end) {
      int code = start + (int)(Math.random() * (end - start + 1)) + start;
      return code;
   }
   
   /**
    * 영문 소문자, 영문 대문자, 숫자로 이루어진 문자열을 생성한다.
    * @param length 생성하고자 하는 문자 길이
    * @return 무작위로 만들어진 문자열
    */
   public static String getRandomString(int length) {
      String[] saChar = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9".split(",");
      StringBuffer sb = new StringBuffer();
      for(int i = 0 ; i < length ; i++) {
         sb.append(saChar[(int)(Math.random() * saChar.length - 1)]);
      }
      
      logger.debug("random string. length:{}, string: {}", length, sb.toString());
      return sb.toString();
   }
   
   public static void setAesKey(String aesKey) {
      AES_KEY = aesKey;
   }
   
   public static String getAesKey() {
      return AES_KEY;
   }
   
}

class AESCipher {
   private String secretKey = "";   // 16bit
   
   
   private static class CryptographySingleton {
      private static final AESCipher instance = new AESCipher();
   }
   
   
   public static AESCipher getInstance() {
      return CryptographySingleton.instance;
   }
   
   private AESCipher() {
   }
   
   private Key AESKeyGenerator(String algorithm, byte[] keyData) throws NoSuchAlgorithmException {
      SecretKey key = null;
      
      if (keyData == null || (keyData != null && keyData.length < 0)) {
         KeyGenerator generator = KeyGenerator.getInstance(algorithm);
         SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
         generator.init(128, random);
         
         key = generator.generateKey();
      } else {
         key = new SecretKeySpec(keyData, "AES"); 
      }
      
      return key;
   }
   
   public Key getKey() throws NoSuchAlgorithmException {
      byte[] keyData = secretKey.getBytes();
      return AESKeyGenerator("AES", keyData);
   }

   /**
    * AESEncrypt
    * @param plainText
    * @return
    * @throws NoSuchPaddingException 
    * @throws NoSuchAlgorithmException 
    * @throws InvalidKeyException 
    * @throws UnsupportedEncodingException 
    * @throws BadPaddingException 
    * @throws IllegalBlockSizeException 
    * @throws Exception
    */
   public String AESEncrypt(String plainText) 
         throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
         IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, getKey());
      byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));

      return Hex.encodeHexString(encrypted);
   }

   /**
    * ASEDecrypt
    * @param encryptedText
    * @return
    * @throws NoSuchPaddingException 
    * @throws NoSuchAlgorithmException 
    * @throws InvalidKeyException 
    * @throws DecoderException 
    * @throws BadPaddingException 
    * @throws IllegalBlockSizeException 
    * @throws UnsupportedEncodingException 
    * @throws Exception
    */
   public String AESDecrypt(String encryptedText) 
         throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
         IllegalBlockSizeException, BadPaddingException, DecoderException, 
         UnsupportedEncodingException {
      Cipher cipher = Cipher.getInstance("AES");
      
      cipher.init(Cipher.DECRYPT_MODE, getKey());
      byte[] decrypted = cipher.doFinal(Hex.decodeHex(encryptedText.toCharArray()));

      return new String(decrypted, "UTF-8");
   }

   public String getSecretKey() {
      return secretKey;
   }

   public void setSecretKey(String secretKey) {
      this.secretKey = secretKey.substring(0, 16);
   }
}

class AES256Cipher {
   private String secretKey = "12345678901234567890123456789012";   // 32 bit
   private String IV = "";   // 16 bit
   
   private static class AES256CipherSingleton {
      private static final AES256Cipher instance = new AES256Cipher();
   }
   
   public static AES256Cipher getInstance() {
      return AES256CipherSingleton.instance;
   }
   
   private AES256Cipher() {
      
   }
   
   private void setIV(String secretKey) {
      if (secretKey == null) {
         secretKey = this.secretKey;
      }
      
      IV = secretKey.substring(0, 16);
   }
   
   public String AES256Encode(String plainText) 
         throws NoSuchAlgorithmException, NoSuchPaddingException, 
         InvalidKeyException, InvalidAlgorithmParameterException, 
         IllegalBlockSizeException, BadPaddingException, 
         UnsupportedEncodingException {
      Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
      
      byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
      String encryptedStr = new String(Base64.encodeBase64(encrypted));
      
      return encryptedStr;
   }
   
   public String AES256Decode(String encryptedStr) 
         throws NoSuchAlgorithmException, NoSuchPaddingException, 
         InvalidKeyException, InvalidAlgorithmParameterException, 
         UnsupportedEncodingException, IllegalBlockSizeException, 
         BadPaddingException {
      Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
      
      byte[] encryptedBytes = Base64.decodeBase64(encryptedStr.getBytes());
      return new String(cipher.doFinal(encryptedBytes), "UTF-8");
   }
   
   private Cipher getCipher(int mode) 
         throws NoSuchAlgorithmException, NoSuchPaddingException, 
         InvalidKeyException, InvalidAlgorithmParameterException {
      byte[] keyData = secretKey.getBytes();
      
      SecretKey secureKey = new SecretKeySpec(keyData, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(mode, secureKey, new IvParameterSpec(IV.getBytes()));
      
      return cipher;
   }
   
   public void setSecretKey(String secretKey) {
      setIV(secretKey);
   }
}