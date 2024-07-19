interface UpdateObserver {
    val subjectsObserved: MutableList<UpdateSubject>

    fun subscribe(subject: UpdateSubject)
    fun remove(subject: UpdateSubject)
    fun onUpdate()
}