package com.thedung.mvvmstructure.application

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.thedung.mvvmstructure.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppConfig @Inject constructor(context: Context) {
    companion object {
        //Share preference
        private const val SP_PREFIX = BuildConfig.APPLICATION_ID
        private const val APP_FIRST_RUN = "${SP_PREFIX}_FIRST_RUN"
    }

    private var masterKey: MasterKey
    private var sharedPreferences: SharedPreferences

    init {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                MasterKey.DEFAULT_MASTER_KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
                .build()

            masterKey = MasterKey.Builder(context)
                .setKeyGenParameterSpec(keyGenParameterSpec)
                .build()
        } else {
            masterKey = MasterKey.Builder(context).build()
        }

        sharedPreferences = EncryptedSharedPreferences.create(
            context,
            BuildConfig.APPLICATION_ID,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var isFirstRun: Boolean
        get() = sharedPreferences.getBoolean(APP_FIRST_RUN, true)
        set(value) = sharedPreferences.edit { putBoolean(APP_FIRST_RUN, value) }
}