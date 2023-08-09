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
import org.softeer_2nd.caArt.dialogs.OptionDetailDialog
import org.softeer_2nd.caArt.factorys.DummyItemFactory

class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnMoveCarColor.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_carColorChoiceFragment)
        }
        binding.btnMoveCarTrim.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_carTrimChoiceFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OptionDetailDialog.Builder()
            .setOptionList(DummyItemFactory.createAdditionalOptionGrouopItem())
            .build()
            .show(requireActivity().supportFragmentManager, "tag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}