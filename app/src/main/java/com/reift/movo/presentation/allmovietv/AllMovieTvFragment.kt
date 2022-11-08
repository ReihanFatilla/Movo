package com.reift.movo.presentation.allmovietv

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reift.movo.R
import com.reift.movo.databinding.ActivityMainBinding
import com.reift.movo.databinding.FragmentAllMovieTvBinding
import org.koin.android.viewmodel.ext.android.viewModel

class AllMovieTvFragment : Fragment() {

    private val viewModel: AllMovieTvViewModel by viewModel()

    private var _binding: FragmentAllMovieTvBinding? = null
    private val binding get() = _binding as FragmentAllMovieTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllMovieTvBinding.inflate(layoutInflater)
        return binding.root
    }

}