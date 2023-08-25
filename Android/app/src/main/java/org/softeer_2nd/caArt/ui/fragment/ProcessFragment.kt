package org.softeer_2nd.caArt.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.softeer_2nd.caArt.viewmodel.ProcessViewModel

abstract class ProcessFragment<PROCESS_DATA_TYPE> : Fragment() {

    abstract val processViewModel: ProcessViewModel<PROCESS_DATA_TYPE>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        processViewModel.lastProcess.observe(viewLifecycleOwner) {
            onLastProcessChanged(it)
        }

        processViewModel.processChangeEvent.observe(viewLifecycleOwner) {
            onProcessChanged(it.currentProcess, it.isLastProcess, it.data)
        }

        processViewModel.processFinishEvent.observe(viewLifecycleOwner) {
            onProcessFinished()
        }
    }

    abstract fun onLastProcessChanged(lastProcess: Int)

    abstract fun onProcessChanged(
        currentProcess: Int,
        isLastProcess: Boolean,
        data: PROCESS_DATA_TYPE?
    )

    abstract fun onProcessFinished()
}