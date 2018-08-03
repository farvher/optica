package com.optica.util

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

import org.apache.tomcat.util.codec.binary.Base64
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
object Encryptor {

    private val logger = LoggerFactory.getLogger(Encryptor::class.java!!)

    private val key = "Bar12345Bar12345"

    private val initVector = "RandomInitVector"


    fun encrypt(value: String): String? {
        try {
            val iv = IvParameterSpec(initVector.toByteArray(charset("UTF-8")))
            val skeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")

            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)

            val encrypted = cipher.doFinal(value.toByteArray())
            logger.info("encrypted string: " + Base64.encodeBase64String(encrypted))

            return Base64.encodeBase64String(encrypted)
        } catch (ex: Exception) {
            logger.error("Error encryting", ex)
        }

        return null
    }

    fun decrypt(encrypted: String): String? {
        try {
            val iv = IvParameterSpec(initVector.toByteArray(charset("UTF-8")))
            val skeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")

            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)

            val original = cipher.doFinal(Base64.decodeBase64(encrypted))

            return String(original)
        } catch (ex: Exception) {
            logger.error("Error decryting", ex)
        }

        return null
    }

    //	public static void main(String[] args) {
    //		String key = "Bar12345Bar12345"; // 128 bit key
    //		String initVector = "RandomInitVector"; // 16 bytes IV
    //
    //		System.out.println(decrypt(key, initVector, encrypt(key, initVector, "Hello World")));
    //	}
}