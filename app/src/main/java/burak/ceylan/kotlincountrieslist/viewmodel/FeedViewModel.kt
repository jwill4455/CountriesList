package burak.ceylan.kotlincountrieslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import burak.ceylan.kotlincountrieslist.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val country = Country("Turkey","Ankara","Asia","TRY","Turkish","ww.ss.com")
        val country2 = Country("France","Paris","Europe","EUR","French","ww.ss.com")
        val country3 = Country("German","Berlin","Europe","EUR","German","ww.ss.com")

        val countryList = arrayListOf<Country>(country,country2,country3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false

    }
}