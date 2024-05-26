package com.example.kot104_assignmentfinal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_assignmentfinal.constant.AppConstant
import com.example.kot104_assignmentfinal.ui.theme.HomeBeautiColor
import com.example.kot104_assignmentfinal.ui.theme.KOT104_AssignmentFinalTheme
import com.example.kot104_assignmentfinal.ui.theme.MakeYourColor
import com.example.kot104_assignmentfinal.ui.theme.PrimaryColor
import com.example.kot104_assignmentfinal.ui.theme.TheBestColor
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor

class SlashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentFinalTheme {
                MyApp()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyApp() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.slash_img)
            ),
    ) {
        Main()
    }
}

@Composable
fun Main() {
    val ctxt = LocalContext.current
    fun onClick() {
        ctxt.startActivity(Intent(ctxt, LoginActivity::class.java))
    }
    Column {
        Text(
            text = "Make your".uppercase(),
            modifier = Modifier.padding(start = 30.dp),
            fontSize = 24.sp,
            color = MakeYourColor,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(AppConstant.FONT_GELASIO_BOLD))
        )
        Text(
            text = "Home Beautiful".uppercase(),
            modifier = Modifier.padding(start = 30.dp, top = 15.dp),
            fontSize = 30.sp,
            color = HomeBeautiColor,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(AppConstant.FONT_GELASIO_SEMI_BOLD))
        )
        Text(
            text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
            modifier = Modifier
                .padding(horizontal = 60.dp, vertical = 35.dp),
            fontSize = 18.sp,
            color = TheBestColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            fontFamily = FontFamily(Font(R.font.nunito_sans_regular))
        )

        TextButton(
            onClick = { onClick() },
            modifier = Modifier
                .width(160.dp)
                .height(55.dp)
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 30.dp)
                .background(PrimaryColor, shape = MaterialTheme.shapes.small),
        ) {
            Text(
                text = "Get Started",
                color = WhiteColor
            )
        }

    }
}