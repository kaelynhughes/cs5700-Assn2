class NotesUpdate(
    val newValue: String,
    override val timestamp: Long
): ShippingUpdate {
    val previousValue = null
    override fun updateShipment(shipment: Shipment) {
        shipment.addNote(newValue)
    }

    override fun displayUpdate(): String {
        return "A new note was added at $timestamp which reads, \"$newValue\"."
    }
}