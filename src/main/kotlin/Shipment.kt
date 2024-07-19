class Shipment(
    val id: String,
    private var status: String,
    private var expectedArrival: Long,
    private var location: String,
    private val notes: MutableList<String>,
    private val updateHistory: MutableList<ShippingUpdate>
) {
    fun addUpdate(update: ShippingUpdate) {
        update.updateShipment(this)
        updateHistory.add(update)
    }

//    fun getId(): String {
//        return id
//    }

    fun getStatus(): String {
        return status
    }
    fun setStatus(status: String) {
        this.status = status
    }

    fun getLocation(): String {
        return location
    }
    fun setLocation(location: String) {
        this.location = location
    }

    fun getExpectedArrival(): Long {
        return expectedArrival
    }
    fun setExpectedArrival(expectedArrival: Long) {
        this.expectedArrival = expectedArrival
    }

    fun getNotes(): MutableList<String> {
        return notes
    }
    fun addNote(note: String) {
        notes.add(note)
    }

    fun getUpdateHistory(): MutableList<ShippingUpdate> {
        return updateHistory
    }

}

