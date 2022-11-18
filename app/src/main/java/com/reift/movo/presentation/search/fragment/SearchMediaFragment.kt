package com.reift.movo.presentation.search.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reift.movo.R
import com.reift.movo.databinding.FragmentSearchMediaBinding
import com.reift.movo.databinding.FragmentSearchTabBinding

class SearchMediaFragment : Fragment() {

    private var _binding: FragmentSearchMediaBinding? = null
    private val binding get() = _binding as FragmentSearchMediaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchMediaBinding.inflate(layoutInflater)

        return binding.root
    }

}