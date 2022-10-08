package com.example.meditationwsproject.data.local_storage

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.meditationwsproject.domain.model.User

class SharedPreferencesStorage(context: Context) : UserDataStorage {
    companion object {
        const val SHARED_PREFERENCES_NAME = "encryptedSharedPreferences"
    }

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val sharedPreferences = EncryptedSharedPreferences.create(
        SHARED_PREFERENCES_NAME,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun getData(): User {
        return User(
            sharedPreferences.getString(UserDataStorage.EMAIL_KEY, UserDataStorage.EMPTINESS_CASE)!!,
            sharedPreferences.getString(UserDataStorage.PASSWORD_KEY, UserDataStorage.EMPTINESS_CASE)!!
        )
    }

    override fun saveData(user: User) {
        sharedPreferences.edit()
            .putString(UserDataStorage.EMAIL_KEY, user.email)
            .putString(UserDataStorage.PASSWORD_KEY, user.password)
            .apply()
    }

}