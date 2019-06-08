package com.kotlin.ui.keyStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.kotlin.ui.R;
import com.kotlin.ui.keyStore.util.AppKeyStore;
import com.kotlin.ui.keyStore.util.KeyStoreM;
import com.kotlin.ui.keyStore.util.KeyStorePreferences;

import java.util.Random;

public class KeyStoreActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_store);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            keyStoreM();
        } else {
            appKeyStore();
        }
    }

    private void keyStoreM() {
        KeyStoreM keyStoreM = new KeyStoreM();

        String password = randomString(10);

        try {
            String encrypt = keyStoreM.encrypt(this, password);
            textView1.setText(encrypt);

            KeyStorePreferences.getInstance(this).putString(KeyStorePreferences.DB_PASSWORD, encrypt);

            String encryptPassword = KeyStorePreferences.getInstance(this).getString(KeyStorePreferences.DB_PASSWORD);
            String decrypt = keyStoreM.decrypt(this, encryptPassword);
            textView2.setText(decrypt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void appKeyStore() {
        AppKeyStore appKeyStore = new AppKeyStore(this);

        String dbPassword = KeyStorePreferences.getInstance(this).getString(KeyStorePreferences.DB_PASSWORD);

        if (dbPassword == null) {
            String password = randomString(10);
            String encrypt = appKeyStore.encrypt(this, password);
            textView3.setText(encrypt);

            KeyStorePreferences.getInstance(this).putString(KeyStorePreferences.DB_PASSWORD, encrypt);
        }
        else {
            try {
                String encryptPassword = KeyStorePreferences.getInstance(this).getString(KeyStorePreferences.DB_PASSWORD);
                String decrypt = appKeyStore.decrypt(this, encryptPassword);
                textView4.setText(decrypt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String randomString(int len) {
        final String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%&*()^";
        Random RANDOM = new Random();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
        }

        return sb.toString();
    }
}
