package com.kotlin.ui.roomDB.dao

import android.arch.persistence.room.*
import com.kotlin.ui.roomDB.entity.User

@Dao
interface UserDao {

    @Insert
    fun insert(userModel: User)

    @Query("SELECT * FROM user")
    fun getUserList() : List<User>

    @Update
    fun updateUser(userModel: User)

    @Delete
    fun deleteUser(userModel: User)

}