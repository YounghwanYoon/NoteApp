package com.ray.noteapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ray.noteapp.R
import com.ray.noteapp.databinding.FragmentListBinding
import com.ray.noteapp.databinding.IndividualListBinding
import com.ray.noteapp.model.data.Note
import com.ray.noteapp.view.adapters.RecycleViewAdapterForListFragment
import kotlinx.android.synthetic.main.fragment_list.*

class List_Fragment: Fragment(){
    //This layout file is fragment_list.xml and it will auto generate binding class as "FragmentListBinding"
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        binding.lifecycleOwner= this
        val data = populateData()
        fragment_recyclerview.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL, false )
        fragment_recyclerview.adapter = RecycleViewAdapterForListFragment(data)
    }

    //Dummy Data
    private fun populateData():ArrayList<Note>{
        val list_note = ArrayList<Note>()
        list_note.add(Note(0,"Studying", 200, "Study Android Again"))

        list_note.add(Note(0,"Play Game", 300, "Play Game Again"))

        list_note.add(Note(0,"Cooking ", 500, "Let's Cook"))
        list_note.add(Note(0,"Studying", 200, "Study Android Again"))

        list_note.add(Note(0,"Play Game", 300, "Play Game Again"))

        list_note.add(Note(0,"Cooking ", 500, "Let's Cook"))
        list_note.add(Note(0,"Studying", 200, "Study Android Again"))

        list_note.add(Note(0,"Play Game", 300, "Play Game Again"))

        list_note.add(Note(0,"Cooking ", 500, "Let's Cook"))

        return list_note
    }
}

class Calendar_Fragment:Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }
}