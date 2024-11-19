package com.example.mouredevtutoriallargo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mouredevtutoriallargo.ui.theme.MoureDevTutorialLargoTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue



private val messages: List<MyMessage> = listOf(
    MyMessage(title = "Hola Jetpack Compose", body = "¿Preparado? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose2", body = "¿Preparado 2? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose3", body = "¿Preparado 3? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose4", body = "¿Preparado 4? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose5", body = "¿Preparado 5? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose6", body = "¿Preparado 6? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose7", body = "¿Preparado 7? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose8", body = "¿Preparado 8? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose9", body = "¿Preparado 9? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose10", body = "¿Preparado 10? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose11", body = "¿Preparado 11? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose12", body = "¿Preparado 12? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    MyMessage(title = "Hola Jetpack Compose13", body = "¿Preparado 13? Lorem ipsum dolor sit amet consectetur adipiscing elit est lacinia, quam eget litora ridiculus volutpat netus lacus dapibus eros, ad nam tellus fames in curabitur libero sapien."),
    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoureDevTutorialLargoTheme {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title:String, val body: String)

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

@Composable
fun MyTexts(message: MyMessage){

    var expanded by rememberSaveable { mutableStateOf(false)}

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable{
            expanded = !expanded
         
    }) {
        MyText(message.title,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if (expanded) Int.MAX_VALUE else 1)
    }
}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

// Repasar la lista
@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages){message -> MyComponent(message) }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponentN(){
    MoureDevTutorialLargoTheme {
        MyMessages(messages)
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewComponentL(){
    MoureDevTutorialLargoTheme {
        MyMessages(messages)
        }
}
