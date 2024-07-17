class Shipment(val id: String, var status: String, var currentLocation: String, val notes: MutableList<String>) {
    fun addNote(note: String) {
        notes.add(note)
    }
}

