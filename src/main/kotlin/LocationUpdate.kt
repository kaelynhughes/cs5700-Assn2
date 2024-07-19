class LocationUpdate(
    val previousValue: String,
    val newValue: String,
    override val timestamp: Long
): ShippingUpdate {
    override fun updateShipment(shipment: Shipment) {
        shipment.setLocation(newValue)
    }

    override fun displayUpdate(): String {
        return "Location updated from $previousValue to $newValue at $timestamp."
    }
}