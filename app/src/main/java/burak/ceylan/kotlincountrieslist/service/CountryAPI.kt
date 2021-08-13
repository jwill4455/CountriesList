package burak.ceylan.kotlincountrieslist.service

import burak.ceylan.kotlincountrieslist.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //FULL_URL = https://api.npoint.io/e2c7bf7e1af83db88f61
    //EXT_URL = e2c7bf7e1af83db88f61


    @GET("e2c7bf7e1af83db88f61")
    fun getCountries(): Single<List<Country>>
}