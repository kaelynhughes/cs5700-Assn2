class StatusUpdate(
    val previousValue: String,
    val newValue: String,
    override val timestamp: Long
): ShippingUpdate {
    override fun updateShipment(shipment: Shipment) {
        shipment.setStatus(newValue)
    }
    override fun displayUpdate(): String {
        return "Status updated from $previousValue to $newValue at $timestamp."
    }
}