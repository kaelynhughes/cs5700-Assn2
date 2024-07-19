interface UpdateSubject {
    val observingObjects: MutableList<UpdateObserver>

    fun addObserver(observer: UpdateObserver)
    fun notifyObservers()
    fun removeObserver(observer: UpdateObserver)
}