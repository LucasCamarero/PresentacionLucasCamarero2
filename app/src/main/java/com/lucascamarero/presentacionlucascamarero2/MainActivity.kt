package com.lucascamarero.presentacionlucascamarero2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucascamarero.presentacionlucascamarero2.ui.theme.PresentacionLucasCamarero2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentacionLucasCamarero2Theme {
                Surface {
                    // lanza la interface
                    app()
                }
            }
        }
    }
}

@Preview
@Composable
fun app() {
    // para que funcione el "scroll" uso Lazy
    LazyColumn(
        modifier = Modifier
            // para que la columna ocupe toda la pantalla
            .fillMaxSize()
            .background(Color(0xFF292726))
    ) {
        // con lazycolumn al menos tiene que haber 1 item
        item {
            // creo una columna para poder alinear bien la imagen
            Column(
                modifier = Modifier
                    // para que la columna ocupe el ancho de pantalla
                    .fillMaxWidth()
                    .padding(top = 45.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotolucas),
                    contentDescription = "Imagen presentación",
                    modifier = Modifier
                        .size(180.dp)
                        .border(width = 6.dp, color = Color.White, shape = CircleShape)
                        .clip(CircleShape)
                )
            }

            Text(
                text = "Lucas Camarero",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Librero y aprendiz de desarrollador, me gusta tocar el bajo y salir a andar por la montaña.",
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 5.dp),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_history_edu_24),
                    contentDescription = "Educación"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Perfil Académico",
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Técnico especialista en Marketing",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_badminton_24),
                    contentDescription = "Deportes"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Deportes",
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Senderismo, natación",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_cake_24),
                    contentDescription = "Comida"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Comida",
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "No le hago ascos a nada",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_chess_knight_24),
                    contentDescription = "Hobbies"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Hobbies",
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Música, cine y ajedrez",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }

            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .padding(horizontal = 60.dp)
                    .padding(bottom = 60.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "Github"
                    )
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.linkedin_svgrepo_com),
                        contentDescription = "Linkedin"
                    )
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = "Instagram"
                    )
                }
            }
        }
    }
}

