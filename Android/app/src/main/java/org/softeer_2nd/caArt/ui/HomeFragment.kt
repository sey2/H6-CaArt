package org.softeer_2nd.caArt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.FragmentHomeBinding
import org.softeer_2nd.caArt.dialogs.CaArtDialog

class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_carColorChoiceFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view2 = TextView(requireContext()).apply {
            text = "hello"
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
        }
        CaArtDialog.Builder(requireContext())
            .setTitle("hello", 30)
            .setDescription("android")
            .setButtonType(CaArtDialog.DOUBLE) //DOUBLE, SINGLE
            .setPositiveButton(listener = {
                //명시적 dismiss 필요
                Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()
                it.dismiss()
            })
            .setNegativeButton(text = "아니", listener = {
                //negative 버튼 클릭 시 이 블록 수행 후 자동으로 dismiss
            })
            .setContentText(
                text = "abcd1234@email.com",
                hint = "hi",
                isEditable = true
            ) //setDialogContentView와 함께 쓰기 불가능
            .setDialogContentView(view2)//원하는 뷰를 넣을 수 있음
            .build()
            .show(requireActivity().supportFragmentManager, "dialogTag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}