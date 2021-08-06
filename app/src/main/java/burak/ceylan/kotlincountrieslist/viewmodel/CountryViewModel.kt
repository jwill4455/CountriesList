package burak.ceylan.kotlincountrieslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import burak.ceylan.kotlincountrieslist.model.Country

class CountryViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Turkey","Ankara","Asia","TRY","Turkish","ww.ss.com")
        countryLiveData.value = country
    }
}