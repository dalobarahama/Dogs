package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.databinding.ItemDogBinding
import com.example.dogs.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.item_dog, parent, false)
        val view =
            DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogsList[position]
        holder.view.listener = this

//        holder.view.name.text = dogsList[position].dogBreed
//        holder.view.lifespan.text = dogsList[position].lifeSpan
//        holder.view.setOnClickListener {
//            val action = ListFragmentDirections
//                .actionListFragmentToDetailFragment()
//            action.dogUid = dogsList[position].uuid
//            Navigation.findNavController(it).navigate(action)
//        }
//        holder.view.image_view.loadImage(
//            dogsList[position].imageUrl,
//            getProgressDrawable(holder.view.image_view.context)
//        )
    }

    override fun onDogClicked(view: View) {
        val uuid = view.dog_Id.text.toString().toInt()
        val action = ListFragmentDirections
            .actionListFragmentToDetailFragment()
        action.dogUid = uuid
        Navigation.findNavController(view).navigate(action)
    }

    class DogViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root)
}