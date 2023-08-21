package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.databinding.FragmentLifestyleDetailBinding
import org.softeer_2nd.caArt.model.data.state.LifestyleDetailState
import org.softeer_2nd.caArt.viewmodel.LifestyleDetailViewModel

@AndroidEntryPoint
class LifestyleDetailFragment : Fragment() {

    private val model: LifestyleDetailViewModel by viewModels()

    private val args: LifestyleDetailFragmentArgs by navArgs()

    private var _binding: FragmentLifestyleDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        model.requestLifeStyleState(args.personaId)
        _binding = FragmentLifestyleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.lifestyleDetailState.observe(viewLifecycleOwner) {
            binding.setBinding(it)
        }
    }

    private fun FragmentLifestyleDetailBinding.setBinding(state: LifestyleDetailState) {
        cover = state.cover
        profile = state.profile
        tagName1 = state.tags[0]
        tagName2 = state.tags[1]
        recommandedModel = state.recommendation.model
        recommandedOption1 = state.recommendation.options[0]
        recommandedOption2 = state.recommendation.options[1]
        interview1 = state.interviews[0]
        interview2 = state.interviews[1]

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}