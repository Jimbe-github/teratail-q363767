package com.teratail.q363767

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teratail.q363767.databinding.MainFragmentBinding

class MainFragment : Fragment() {
  companion object {
    fun newInstance() = MainFragment()
  }

  //https://developer.android.com/topic/libraries/view-binding#fragments
  private var _binding: MainFragmentBinding? = null
  private val binding get() = _binding!!

  private lateinit var viewModel: MainViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    _binding = MainFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    binding.btnTest.setOnClickListener {
      viewModel.startAlarm()
    }

    viewModel.alarmState.observe(viewLifecycleOwner, { b-> binding.btnTest.isEnabled = !b })
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}