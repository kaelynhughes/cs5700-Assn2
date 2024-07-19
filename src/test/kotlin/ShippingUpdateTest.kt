import kotlin.test.*

class ShippingUpdateTest {
    @Test
    fun testShipmentUpdate() {
        // create a shipment to test with
        val shipment = Shipment("old id", "old status", 123456789, "old location")

        // create shipment - first update
        val creationUpdate = CreationUpdate(456)
        shipment.addUpdate(creationUpdate)
        assertEquals("Shipment created at 456.", creationUpdate.displayUpdate())

        // update status
        val statusUpdate = StatusUpdate(shipment.getStatus(), "new status", 12345)
        shipment.addUpdate(statusUpdate)
        assertEquals("Status updated from created to new status at 12345.", statusUpdate.displayUpdate())
        assertEquals("new status", shipment.getStatus())

        // update location
        val oldLocation: String = shipment.getLocation() ?: "location"
        val locationUpdate = LocationUpdate(oldLocation, "new location", 1234)
        shipment.addUpdate(locationUpdate)
        assertEquals("Location updated from old location to new location at 1234.", locationUpdate.displayUpdate())
        assertEquals("new location", shipment.getLocation())

        // update expected arrival
        val expectedArrivalUpdate = ExpectedArrivalUpdate(shipment.getExpectedArrival() ?: 0, 23456, 234)
        shipment.addUpdate(expectedArrivalUpdate)
        assertEquals("Expected arrival time updated from 123456789 to 23456 at 234.", expectedArrivalUpdate.displayUpdate())
        assertEquals(23456, shipment.getExpectedArrival())

        // update with notes
        val notesUpdate = NotesUpdate("new note", 456)
        shipment.addUpdate(notesUpdate)
        assertEquals("A new note was added at 456 which reads, \"new note\".", notesUpdate.displayUpdate())
        assertEquals("new note", shipment.getNotes().last())


    }
}