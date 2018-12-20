package com.kotlin.ui.roomDB.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private var userId: Int = 0

    @ColumnInfo(name = "name")
    private var name: String? = null

    @ColumnInfo(name = "email")
    private var email: String? = null

    @ColumnInfo(name = "mobile")
    private var mobile: String? = null

    @ColumnInfo(name = "address")
    private var address: String? = null

    fun getUserId(): Int {
        return userId
    }

    fun setUserId(userId: Int) {
        this.userId = userId
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getMobile(): String? {
        return mobile
    }

    fun setMobile(mobile: String) {
        this.mobile = mobile
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String) {
        this.address = address
    }
}