class ExpectedArrivalUpdate (
    val previousValue: Long,
    val newValue: Long,
    override val timestamp: Long
    ): ShippingUpdate {
        override fun updateShipment(shipment: Shipment) {
            shipment.setExpectedArrival(newValue)
        }

        override fun displayUpdate(): String {
            return "Location updated from $previousValue to $newValue at $timestamp."
        }
}