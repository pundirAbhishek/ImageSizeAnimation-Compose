package com.example.imagesizeanimation_compose

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun AnimateScreen(){
    val listState = rememberLazyListState()

    val transition =
        updateTransition(listState.firstVisibleItemIndex != 0, label = "Image Size Transition")

    val cornerRadius by transition.animateInt { isScrolling ->
        if (isScrolling) 50 else 0
    }

    val size by transition.animateDp { isScrolling ->
        if (isScrolling) 300.dp else 500.dp
    }
    val modifier: Modifier = if (listState.firstVisibleItemIndex != 0) {
        Modifier
            .clip(RoundedCornerShape(percent = cornerRadius))
            .size(size)
    } else {
        Modifier
            .size(size)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        val painter =
            rememberImagePainter(data = imageUrl)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(state = listState, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)) {
            items(itemList) { item ->
                Item(itemModel = item)
            }
        }
    }
}

@Composable
fun Item(itemModel: ItemModel) {
    Row(modifier = Modifier.height(40.dp)) {
        Icon(imageVector = itemModel.icon, contentDescription = itemModel.text)
        Spacer(modifier = Modifier.size(20.dp))
        Text(itemModel.text)
    }
}
