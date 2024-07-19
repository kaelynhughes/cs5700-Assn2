import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.FileReader

class TrackingSimulator {
    val allShipments = mutableListOf<Shipment>()
    public val shipmentUpdateHistory: List<Shipment> = mutableListOf()
    fun runSimulation() {
       try {
           val reader = BufferedReader(FileReader("src/main/kotlin/test.txt"))
           getUpdate(reader)

       } catch (e: Exception) {
           println("error")
       }
    }
    fun findShipment(id: String): Shipment? {
        if (allShipments.filter { shipment -> shipment.getId() == id }.isNotEmpty()) {
            return allShipments.filter { shipment -> shipment.getId() == id }[0]
        } else {
            return null
        }
    }
    fun addShipment(shipmentId: String, timestamp: Long) {
        var newShipment = Shipment(shipmentId, "created")
        allShipments.add(newShipment)
        newShipment.addUpdate(CreationUpdate(timestamp))
    }
    fun getUpdate(reader: BufferedReader) = runBlocking {
        launch {
            var line: String? = reader.readLine()
            while (line != null) {
                val updateItems = line.split(',')
                try {
                    val type = UpdateType.valueOf(updateItems[0].uppercase())
                    val id = updateItems[1]
                    val timestamp = updateItems[2].toLong()
                    val otherInfo = if (updateItems.size > 3) updateItems[2] else ""
                    val shipment = allShipments.find { shipment -> shipment.getId() == id}

                    when (type) {
                        UpdateType.CREATED -> addShipment(id, timestamp)
                        UpdateType.SHIPPED -> shipment?.addUpdate(StatusUpdate(shipment.getStatus(), "Shipped", timestamp))
                        UpdateType.LOCATION -> shipment?.addUpdate(LocationUpdate("Shipped", "Location", timestamp))
                        UpdateType.DELIVERED -> shipment?.addUpdate(StatusUpdate(shipment.getStatus(), "Shipped", timestamp))
                        UpdateType.DELAYED -> shipment?.addUpdate(ExpectedArrivalUpdate(timestamp, otherInfo.toLong(), timestamp))
                        UpdateType.LOST -> shipment?.addUpdate(StatusUpdate(shipment.getStatus(), "Shipped", timestamp))
                        UpdateType.CANCELLED -> shipment?.addUpdate(StatusUpdate(shipment.getStatus(), "Shipped", timestamp))
                        UpdateType.NOTEADDED -> shipment?.addUpdate(NotesUpdate(otherInfo, timestamp))

                    }
                } catch (e: Exception) {
                    println("error in update type")
                    println(line)
                }
                delay(1000L)
                line = reader.readLine()
            }
        }
    }
}
