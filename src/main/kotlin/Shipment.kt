class Shipment(
    private val id: String,
    private var status: String,
    private var expectedArrival: Long? = null,
    private var location: String? = null,
    private val notes: MutableList<String> = mutableListOf(),
    private val updateHistory: MutableList<ShippingUpdate> = mutableListOf()
): UpdateSubject {
    override val observingObjects: MutableList<UpdateObserver> = mutableListOf()

    override fun addObserver(observer: UpdateObserver) {
        observingObjects.add(observer)
    }
    override fun notifyObservers(update: ShippingUpdate) {
        observingObjects.forEach { element -> element.notify(update) }
    }

    override fun removeObserver(observer: UpdateObserver) {
       observingObjects.remove(observer)
    }
    fun addUpdate(update: ShippingUpdate) {
        update.updateShipment(this)
        updateHistory.add(update)
    }

    fun getId(): String {
        return id
    }

    fun getStatus(): String {
        return status
    }
    fun setStatus(status: String) {
        this.status = status
    }

    fun getLocation(): String? {
        return location
    }
    fun setLocation(location: String) {
        this.location = location
    }

    fun getExpectedArrival(): Long? {
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

