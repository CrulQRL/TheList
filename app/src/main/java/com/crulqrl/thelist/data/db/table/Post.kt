package com.crulqrl.thelist.data.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
class Post( val userId: String,
            @PrimaryKey val id: Int,
            val title: String,
            val body: String)