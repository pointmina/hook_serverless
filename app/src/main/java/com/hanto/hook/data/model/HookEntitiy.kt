package com.hanto.hook.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Hook")
data class Hook(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val hookId: String,
    var title: String,
    var url: String?,
    var description: String?,
    var isPinned: Boolean = false
) : Parcelable


@Entity(tableName = "Tag")
data class Tag(
    @PrimaryKey(autoGenerate = true) val tagId: Long = 0,
    val hookId: String,
    val name: String
)
