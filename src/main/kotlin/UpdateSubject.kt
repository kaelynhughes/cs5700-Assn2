interface UpdateSubject {
    val observingObjects: MutableList<UpdateObserver>

    fun addObserver(observer: UpdateObserver)
    fun notifyObservers(update: ShippingUpdate)
    fun removeObserver(observer: UpdateObserver)
}