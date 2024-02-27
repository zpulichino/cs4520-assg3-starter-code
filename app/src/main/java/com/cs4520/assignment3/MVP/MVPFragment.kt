package com.cs4520.assignment3.MVP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMVPBinding


class MVPFragment : Fragment(), MVPView {

    private var _binding: FragmentMVPBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MVPPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMVPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMVPBinding.bind(view)
        presenter = MVPPresenter(this, MVPModel())

        setupUI()
    }

    private fun setupUI() {
        with(binding) {
            additionBTN.setOnClickListener {
                presenter.onAddClick(input1.text.toString(), input2.text.toString())
                binding.input1.text.clear()
                binding.input2.text.clear()
            }
            subtractionBTN.setOnClickListener {
                presenter.onSubClick(input1.text.toString(), input2.text.toString())
                binding.input1.text.clear()
                binding.input2.text.clear()
            }
            multiplyBTN.setOnClickListener {
                presenter.onMultiplyClick(input1.text.toString(), input2.text.toString())
                binding.input1.text.clear()
                binding.input2.text.clear()
            }
            divideBTN.setOnClickListener {
                presenter.onDivideClick(input1.text.toString(), input2.text.toString())
                binding.input1.text.clear()
                binding.input2.text.clear()
            }
        }
    }

    override fun showResult(message: String) {
        binding.result.text = message
    }

    override fun showError(result: String) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}