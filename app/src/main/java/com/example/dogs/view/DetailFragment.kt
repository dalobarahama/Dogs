package com.example.dogs.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dogs.R
import com.example.dogs.util.getProgressDrawable
import com.example.dogs.util.loadImage
import com.example.dogs.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var dogUid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            dogUid = DetailFragmentArgs.fromBundle(it).dogUid
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(dogUid)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogsDetail.observe(this, Observer { dog ->
            dog_name.text = dog.dogBreed
            dog_purpose.text = dog.bredFor
            dog_temperament.text = dog.temperament
            dog_lifespan.text = dog.lifeSpan
            context?.let { dog_image.loadImage(dog.imageUrl, getProgressDrawable(it)) }
        })
    }

}
