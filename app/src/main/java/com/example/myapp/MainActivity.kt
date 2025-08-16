package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.ui.theme.MyComposeApplicationTheme
//---
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //定义活动布局
            MyComposeApplicationTheme { //主题
                Surface {
                    zhs(zh("Hello World!!","ohMyApp"))
                }
            }
        }
    }
}
data class zh(val q: String , val w: String)
@Composable
fun texts(name: String) {
    Text(name)
}
@Composable
fun zhs(zhd: zh) {
    Column{
        Image(
            painter = painterResource(R.drawable.image1),
            contentDescription = "一个图片"
        )
        Column{
            Text(zhd.q)
            Text(zhd.w)
        }
        Box{
            Image(
                painter = painterResource(R.drawable.image2),
                contentDescription = "一个图片" ,
                alpha = 0.5f
            )
            Column{
                Text("This is a image")
                Text("But alpha = 0.5f , also it hava text")
            }
        }
    }
}


/*@Preview
@Composable
fun yulan() {
    texts("test")
}*/













/*
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Greeting("World!")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeApplicationTheme {
        Greeting("World!!")
    }
}*/