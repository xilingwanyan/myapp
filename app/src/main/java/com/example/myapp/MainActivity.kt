package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.ui.theme.MyComposeApplicationTheme
//---
/*import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width*/
import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
//import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.draw.blur
//import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.*
import androidx.compose.ui.*
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //定义活动布局
            MyComposeApplicationTheme { //主题
                Surface {
                    bj(zh("Hello World!!","ohMyApp"))
                }
            }
        }
    }
}
data class zh(val q: String , val w: String)
@Composable
fun bj(zhds: zh) { //背景实现
    Box{
        Image(
            painter = painterResource(R.drawable.image3),
            contentDescription = "一个图片" ,
            modifier = Modifier.blur(1.dp)
                .fillMaxSize()
        )
        zhs(zhds)
    }
}
@Composable
fun zhs(zhd: zh) {
    Column(
        /*modifier = Modifier.background(Color.Blue) ,
        verticalArrangement = Arrangement.Bottom*/
    ){
        Image( //首张图片
            painter = painterResource(R.drawable.image1),
            contentDescription = "一个图片"
        )
            /*Canvas(
                modifier = Modifier.fillMaxSize()
                    .alpha(0.4f)
                    .blur(7.dp)
            ){
                drawRoundRect(
                    color = Color.Black ,
                    cornerRadius = CornerRadius(30f , 30f)
                )
            }*/
        Box{ //text实现
            Canvas(
                modifier = Modifier
                    //.background(Color(0xFF1A121C))
                    .fillMaxWidth()
                    .height(66.dp)
                    //.border(1.5.dp , Color(0xFF62D002))
                    //.padding(1.5.dp)
                    .alpha(0.9f)
            ){
                drawRoundRect(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF1D0316) ,
                            Color(0xFF03071D) ,
                            Color(0xFf0A1D14)
                        )
                    ),
                    cornerRadius = CornerRadius(20f , 20f)
                )
            }
            Column(
                modifier = Modifier
                    .padding(2.dp)
            ){
                Text(zhd.q , modifier = Modifier
                    .border(2.dp , Color(0xFF385276))
                )
                Text(zhd.w)
                Text("very Good")
            }
        }
        Box( //图片+文字实现
            modifier = Modifier
                .border(3.dp , Color(0xFF3E2CD6))
                .padding(3.dp)
        ){
            Image(
                painter = painterResource(R.drawable.image2),
                contentDescription = "一个图片" ,
                alpha = 0.7f ,
                modifier = Modifier.blur(7.dp)
            )
            Column{
                Text("This is a image")
                Text("But alpha = 0.7f , also it hava text")
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