import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun app() {
    var shipmentId by remember { mutableStateOf("") }
    val shipments = remember { mutableStateListOf<Shipment>(Shipment("id", "status", 123, "location"))}

    MaterialTheme {
        Column {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
            TextField(shipmentId, onValueChange = {
                shipmentId = it
            })
            Button(onClick = {
                print("New shipment: $shipmentId")
            }) {
                Text("Add Shipment")
            }}
            LazyColumn {
                items(shipments, key = {it.getId()}) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                            .padding(4.dp)
                    ) {
                        Text("Shipment ${it.getId()} - most recent status: ${it.getStatus()}")
                        Text("Most recent location: ${it.getLocation()}")
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}
