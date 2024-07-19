class CreationUpdate (
        override val timestamp: Long
    ): ShippingUpdate {
        override fun updateShipment(shipment: Shipment) {
            shipment.setStatus("created")
        }
        override fun displayUpdate(): String {
            return "Shipment created at $timestamp."
        }
}