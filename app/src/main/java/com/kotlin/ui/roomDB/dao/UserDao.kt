package com.kotlin.ui.roomDB.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.kotlin.ui.roomDB.entity.User

@Dao
interface UserDao {

    @Insert
    fun insert(userModel: User)

    @Query("SELECT * FROM user")
    fun getUserList() : LiveData<List<User>>

    @Update
    fun updateUser(userModel: User)

    @Delete
    fun deleteUser(userModel: User)

}