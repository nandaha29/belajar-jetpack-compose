package com.example.prakpapbtugasone


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prakpapbtugasone.ui.theme.PrakpapbtugasoneTheme


// MainActivity: Komponen utama dari aplikasi yang diatur untuk menampilkan konten menggunakan Jetpack Compose.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set konten aplikasi menggunakan theme Prakpapbtugasone
        setContent {
            PrakpapbtugasoneTheme {
                // Menampilkan ScaffoldExample sebagai konten utama
                MyScaffoldExample()
            }
        }
    }
}


// MyScaffoldExample: Fungsi Composable yang membangun UI utama dengan TopAppBar, BottomAppBar, dan FloatingActionButton.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldExample() {
    var presses by remember { mutableStateOf(0) } // State untuk menghitung jumlah klik
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Memastikan Scaffold mengisi seluruh ukuran layar
        topBar = {


            // Menampilkan TopAppBar dengan konfigurasi warna dan ikon
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Column {
                        // Menampilkan dua baris teks di bagian atas
                        Text(
                            text = "Tugas Praktikum PAPB",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "List + Appbar + Bottombar",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                },
                navigationIcon = {
                    // Menampilkan ikon navigasi di sebelah kiri TopAppBar
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        bottomBar = {
            // Menampilkan BottomAppBar dengan NIM di tengah
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(), // Mengisi lebar penuh
                    textAlign = TextAlign.Center, // Menyelaraskan teks di tengah
                    text = "225150207111118", // NIM
                )
            }
        },
        floatingActionButton = {
            // Menampilkan FloatingActionButton untuk menambah item
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        // Menampilkan daftar mobil dengan padding dari Scaffold
        CarList(Modifier.padding(paddingValues))
    }
}


// CarList: Menampilkan daftar mobil dalam bentuk LazyColumn
@Composable
fun CarList(modifier: Modifier = Modifier) {
    val cars = listOf(
        "Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Audi", "Mercedes", "Hyundai",
        "Nissan", "Kia", "Volkswagen", "Subaru", "Mazda", "Jeep", "Ram", "GMC", "Buick",
        "Land Rover", "Jaguar", "Porsche", "Lexus", "Cadillac", "Tesla", "Chrysler", "Volvo"
    )


    LazyColumn(
        modifier = modifier
            .fillMaxSize() // Mengisi ukuran penuh dari Modifier yang diterima
            .padding(16.dp) // Memberikan padding di sekitar daftar
    ) {
        items(cars) { car ->
            CarItem(carName = car) // Menampilkan setiap item mobil
        }
    }
}


//// CarItem: Menampilkan teks untuk nama mobil
//@Composable
//fun CarItem(carName: String) {
//    Text(
//        text = "Car: $carName",
//        style = MaterialTheme.typography.bodyLarge,
//        modifier = Modifier
//            .fillMaxWidth() // Mengisi lebar penuh dari Modifier yang diterima
//            .padding(vertical = 8.dp) // Memberikan padding vertikal di sekitar teks
//    )
//}


@Composable
fun CarItem(carName: String) {
    // Menampilkan item mobil di dalam Card tanpa warna latar belakang
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp) // Menambahkan efek elevasi pada card
    ) {
        Text(
            text = "Car: $carName",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(16.dp) // Memberikan padding di dalam card
        )
    }
}


// DefaultPreview: Menampilkan pratinjau dari UI dalam mode tema
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrakpapbtugasoneTheme {
        MyScaffoldExample()
    }
}
