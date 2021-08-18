package com.example.imagesizeanimation_compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ItemModel(val icon: ImageVector, val text: String)

val itemList = listOf(
    ItemModel(Icons.Default.Home, "Home"),
    ItemModel(Icons.Default.AccountBox, "Account"),
    ItemModel(Icons.Default.Phone, "Phone"),
    ItemModel(Icons.Default.Notifications, "Notifications"),
    ItemModel(Icons.Default.Email, "Email"),
    ItemModel(Icons.Default.Info, "User Info"),
    ItemModel(Icons.Default.Favorite, "Favourites"),
    ItemModel(Icons.Default.ThumbUp, "Likes"),
    ItemModel(Icons.Default.MailOutline, "Mail"),
    ItemModel(Icons.Default.Refresh, "Refresh"),
    ItemModel(Icons.Default.Search, "Search"),
    ItemModel(Icons.Default.Call, "Recent Calls"),
    ItemModel(Icons.Default.Share, "Share Profile"),
    ItemModel(Icons.Default.Settings, "Settings"))

const val imageUrl = "https://images.unsplash.com/photo-1545901478-6fd3d475dad1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=910&q=80"