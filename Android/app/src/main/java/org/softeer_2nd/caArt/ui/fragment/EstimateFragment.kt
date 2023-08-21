package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.databinding.FragmentEstimateBinding
import org.softeer_2nd.caArt.model.factory.DummyItemFactory
import org.softeer_2nd.caArt.ui.recycleradapter.OrderDetailAdapter
import org.softeer_2nd.caArt.ui.recycleradapter.ResultOptionAdapter

class EstimateFragment : Fragment() {
    private var _binding: FragmentEstimateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEstimateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
    }

    fun RecyclerView.setup(
        layoutManager: RecyclerView.LayoutManager,
        adapter: RecyclerView.Adapter<*>,
        nestedScrollingEnabled: Boolean = true
    ) {
        this.layoutManager = layoutManager
        this.adapter = adapter
        this.isNestedScrollingEnabled = nestedScrollingEnabled
    }

    private fun setupRecyclerViews() {
        binding.rvChoiceOptions.setup(
            LinearLayoutManager(context),
            ResultOptionAdapter(DummyItemFactory.createResultOptionDummyItem(), false),
            false
        )

        binding.rvOrderDetail.setup(
            LinearLayoutManager(context),
            OrderDetailAdapter(DummyItemFactory.createOrderMoreDetailDummyItem()),
            false
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}