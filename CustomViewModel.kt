class CustomViewModel : ViewModel() {

    private val _counterMutableStateFlow = MutableStateFlow<Int>(0)
    val counterStateFlow: StateFlow<Int> = _counterMutableStateFlow

    fun startCounter() {
        Log.i(TAG, "startCounter")
        viewModelScope.launch {
            var i = 0
            while (true) {
                _counterMutableStateFlow.value = i
                delay(1000)
                i += 1
            }
        }
    }
}
