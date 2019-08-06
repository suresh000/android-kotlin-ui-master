package com.kotlin.ui.biometricauth

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.biometric.BiometricCallback
import com.kotlin.biometric.BiometricManager
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityBiometricAuthBinding
import com.kotlin.ui.utils.AppUtil

class BiometricAuthActivity : AppCompatActivity(), BiometricCallback {

    private lateinit var mBiometricManager: BiometricManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBiometricAuthBinding>(this, R.layout.activity_biometric_auth)

        binding.login.setOnClickListener {
            mBiometricManager = BiometricManager.BiometricBuilder(this@BiometricAuthActivity)
                    .setTitle(resources.getString(R.string.biometric_title))
                    .setSubtitle(resources.getString(R.string.biometric_subtitle))
                    .setDescription(resources.getString(R.string.biometric_description))
                    .setNegativeButtonText(resources.getString(R.string.biometric_negative_button_text))
                    .build()

            //start authentication
            mBiometricManager.authenticate(this@BiometricAuthActivity)
        }
    }

    override fun onSdkVersionNotSupported() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_error_sdk_not_supported),
                true)
    }

    override fun onBiometricAuthenticationNotSupported() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_error_hardware_not_supported),
                true)
    }

    override fun onBiometricAuthenticationNotAvailable() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_error_fingerprint_not_available),
                true)
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_error_permission_not_granted),
                true)
    }

    override fun onBiometricAuthenticationInternalError(error: String?) {
        AppUtil.showToast(this, error!!, true)
    }

    override fun onAuthenticationFailed() {
        //        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_cancelled),
                true)
        mBiometricManager.cancelAuthentication()
    }

    override fun onAuthenticationSuccessful() {
        AppUtil.showToast(this, resources.getString(R.string.biometric_success),
                true)
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        //        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        //        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}
