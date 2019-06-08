package com.kotlin.ui.keyStore.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.CertificateException;

import static android.os.Build.VERSION_CODES.M;

@TargetApi(M)
public class KeyStoreM {

    private static final String ENCRYPTION_ALGORITHM = KeyProperties.KEY_ALGORITHM_AES;
    private static final String ENCRYPTION_BLOCK_MODE = KeyProperties.BLOCK_MODE_CBC;
    private static final String ENCRYPTION_PADDING = KeyProperties.ENCRYPTION_PADDING_PKCS7;
    private static final String ENCRYPTION_TRANSFORMATION = ENCRYPTION_ALGORITHM + "/" +
            ENCRYPTION_BLOCK_MODE + "/" + ENCRYPTION_PADDING;

    private static final int ENCRYPTION_KEY_SIZE = 256;
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static final String AndroidKeyStore = "AndroidKeyStore";
    private static final String KEY_ALIAS = "hoho";

    private KeyStore keyStore;

    public KeyStoreM() {
        try {
            keyStore = KeyStore.getInstance(AndroidKeyStore);
            keyStore.load(null);

            generateKey();

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateKey() {

        try {
            if (!keyStore.containsAlias(KEY_ALIAS)) {
                KeyGenerator keyGenerator = KeyGenerator.
                        getInstance(KeyProperties.KEY_ALGORITHM_AES, AndroidKeyStore);

                keyGenerator.init(
                        new KeyGenParameterSpec.Builder(KEY_ALIAS,
                                KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                                .setBlockModes(ENCRYPTION_BLOCK_MODE)
                                .setEncryptionPaddings(ENCRYPTION_PADDING)
                                .setRandomizedEncryptionRequired(true)
                                .setKeySize(ENCRYPTION_KEY_SIZE)
                                .build());

                keyGenerator.generateKey();
            }
        }
        catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    private Key getSecretKey(Context context) throws Exception {
        return keyStore.getKey(KEY_ALIAS, null);
    }

    public String encrypt(Context context, String raw) {
        try {
            Key key = getSecretKey(context);
            Cipher c = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
            c.init(Cipher.ENCRYPT_MODE, key);


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // write initialization vector to the beginning of the stream
            byte[] iv = c.getIV();
            outputStream.write(iv, 0, iv.length);
            // encrypt the value using a CipherOutputStream
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, c);
            cipherOutputStream.write(raw.getBytes(DEFAULT_CHARSET));
            cipherOutputStream.close();
            byte[] encryptedVal = outputStream.toByteArray();

            return Base64.encode(encryptedVal);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public String decrypt(Context context, String encrypted) throws Exception {
        byte[] decodedValue = Base64.decode(getBytes(encrypted));
        Cipher c = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);


        ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedValue);
        // read the initialization vector from the beginning of the stream
        IvParameterSpec ivParams = readIvFromStream(inputStream);
        c.init(Cipher.DECRYPT_MODE, getSecretKey(context), ivParams);
        // decrypt the bytes using a CipherInputStream
        CipherInputStream cipherInputStream = new CipherInputStream(
                inputStream, c);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int n = cipherInputStream.read(buffer, 0, buffer.length);
            if (n <= 0) {
                break;
            }
            output.write(buffer, 0, n);
        }


        return new String(output.toByteArray(), DEFAULT_CHARSET);
    }

    private byte[] getBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    private IvParameterSpec readIvFromStream(ByteArrayInputStream inputStream) {
        byte[] iv = new byte[16];
        inputStream.read(iv, 0, iv.length);
        return new IvParameterSpec(iv);
    }

}
