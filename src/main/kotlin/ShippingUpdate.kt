interface ShippingUpdate {
    val timestamp: Long

    fun updateShipment(shipment: Shipment)
    fun displayUpdate(): String
}