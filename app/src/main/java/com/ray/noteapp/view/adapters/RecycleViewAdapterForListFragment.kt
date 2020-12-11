package com.ray.noteapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ray.noteapp.R
import com.ray.noteapp.databinding.FragmentListBinding
import com.ray.noteapp.databinding.IndividualListBinding
import com.ray.noteapp.model.data.Note
import kotlinx.android.synthetic.main.individual_list.view.*

class RecycleViewAdapterForListFragment(val noteList:ArrayList<Note>):
    RecyclerView.Adapter<RecycleViewAdapterForListFragment.RecycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        //val binding :FragmentListBinding = DataBindingUtil.inflate<FragmentListBinding>(layoutInflater,R.layout.individual_list, parent, false)

        val binding = IndividualListBinding.inflate(layoutInflater, parent, false)

        return RecycleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val oneNote = noteList.get(position)
        holder.bind(oneNote)

        //holder.individualBinding.textviewTitle.text = oneNote.title
        //holder.individualBinding.listItemTimeSaved.text = oneNote.time_update.toString()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    //Since layout containing xml is called individual_list.xml, binding class will be created as
    //IndividualListBinding as below.
    class RecycleViewHolder(val individualBinding:IndividualListBinding, itemView: View = individualBinding.root)
        : RecyclerView.ViewHolder(itemView)
    {
        private lateinit var recycleBinding:IndividualListBinding
        fun bind(note:Note){
            individualBinding.note = note

//            binding.note.id = note.id
  //          binding.executePendingBindings()
        }
    }
}
