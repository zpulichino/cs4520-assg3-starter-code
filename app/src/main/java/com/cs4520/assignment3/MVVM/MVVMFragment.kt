package com.cs4520.assignment3.MVVM


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.databinding.FragmentMVVMBinding


class MVVMFragment : Fragment() {

    private var _binding: FragmentMVVMBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MVVMViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentMVVMBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMVVMBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MVVMViewModel::class.java)

        setupUI()
        observingVM()

    }

    private fun setupUI() {
        binding.additionBTN.setOnClickListener {
            viewModel.add(binding.input1.text.toString(), binding.input2.text.toString())
        }
        binding.subtractionBTN.setOnClickListener {
            viewModel.sub(binding.input1.text.toString(), binding.input2.text.toString())
        }
        binding.multiplyBTN.setOnClickListener {
            viewModel.multiply(binding.input1.text.toString(), binding.input2.text.toString())
        }
        binding.divideBTN.setOnClickListener {
            viewModel.div(binding.input1.text.toString(), binding.input2.text.toString())
        }

    }

    private fun observingVM() {
        viewModel.result.observe(viewLifecycleOwner) { result ->
            binding.result.text = result.toString()
            clearInputs()
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                viewModel.clearError()
            }
        }
    }

    private fun clearInputs() {
        binding.input1.text.clear()
        binding.input2.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}