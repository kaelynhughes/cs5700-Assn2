import androidx.compose.runtime.*

class TrackerViewHelper(
    shipmentId: String
): UpdateObserver {
    init {
        val id = mutableStateOf(shipmentId)
        val shipmentUpdateHistory: State<List<String>> = mutableStateOf(mutableListOf())
    }
    override val subjectsObserved: MutableList<UpdateSubject> = mutableListOf()
    override fun subscribe(subject: UpdateSubject) {
       subject.addObserver(this)
       subjectsObserved.add(subject)
    }
    override fun remove(subject: UpdateSubject) {
       subject.removeObserver(this)
       subjectsObserved.remove(subject)
    }
    override fun notify(update: ShippingUpdate) {

    }
}