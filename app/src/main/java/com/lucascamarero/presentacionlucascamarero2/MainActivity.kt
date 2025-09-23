package com.lucascamarero.presentacionlucascamarero2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
// Se opta voluntariamente a utilizar una API experimental que pertenece a Material 3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun app() {

    // Scaffold modela la vista
    Scaffold(
        // barra superior
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    // Text introduce un texto en pantalla
                    Text("Presentación Lucas Camarero II")
                }
            )
        },
        // barra inferior
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                ponerBotones()
            }
        }
    )
    // lo que va dentro del "body"??
    { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //Mensaje(pulsado)
        }
    }
}

@Composable
fun ponerBotones() {
    val context = LocalContext.current

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        // Botón 1: Enviar e-mail
        Button(onClick = {
            val recipient = "l.camareroperez@ikasle.eus"
            val subject = "Prueba desde jet compose"
            val body = "Hola Lucas del futuro. Esto es una prueba"
            val uri = Uri.parse(
                "mailto:$recipient"
                        + "?subject=${Uri.encode(subject)}"
                        + "&body=${Uri.encode(body)}"
            )

            val intent = Intent(Intent.ACTION_SENDTO).apply { data = uri }
            context.startActivity(intent)
        }) {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }

        // Botón 2: Compartir contenido
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Mira esta app de Compose genial!")
            }
            context.startActivity(Intent.createChooser(intent, "Compartir con"))
        }) {
            Icon(Icons.Default.Share, contentDescription = "Compartir")
        }

        // Botón 3: Abrir navegador
        Button(onClick = {
            val url = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }) {
            Icon(Icons.Default.Info, contentDescription = "Navegador")
        }

        // Botón 4: Abrir otra actividad
        Button(onClick = {
            val intent = Intent(context, OtraActividad::class.java)
            context.startActivity(intent)
        }) {
            Icon(Icons.Default.Home, contentDescription = "Otra actividad")
        }
    }
}

/*
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
*/
