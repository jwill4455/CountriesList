package burak.ceylan.kotlincountrieslist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import burak.ceylan.kotlincountrieslist.view.CountryFragmentArgs
import burak.ceylan.kotlincountrieslist.R
import burak.ceylan.kotlincountrieslist.databinding.FragmentCountryBinding
import burak.ceylan.kotlincountrieslist.util.downloadFromUrl
import burak.ceylan.kotlincountrieslist.util.placeholderProgressBar
import burak.ceylan.kotlincountrieslist.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    private lateinit var viewModel : CountryViewModel
    private var countryUuid = 0
    private lateinit var dataBinding : FragmentCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        return dataBinding.root

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)




        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
              country?.let {

                  dataBinding.selectedCountry = country

                  /*
                  countryName.text = it.countryName
                  countryCapital.text = it.countryCapital
                  countryRegion.text = it.countryRegion
                  countryCurrency.text = it.countryCurrency
                  countryLanguage.text = it.countryLanguage
                  context?.let {
                      countryImage.downloadFromUrl(country.imageUrl, placeholderProgressBar(it))
                  }

                   */
              }
        })
    }

}