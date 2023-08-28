package org.softeer_2nd.caArt.model.repository

import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.softeer_2nd.caArt.CaArtApplication
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.network.CaArtResponse
import retrofit2.HttpException

open class BaseNetworkRepository {

    companion object {
        const val TAG = "BaseNetworkRepository"
    }

    protected open suspend fun <T> safeApiCall(
        isErrorResultToast: Boolean = true,
        apiCall: suspend () -> CaArtResponse<T>
    ): CaArtResponse<T> {
        return try {
            apiCall.invoke()
        } catch (e: HttpException) {
            Log.e(TAG, "${e.code()} : ${e.message()}")
            val context = CaArtApplication.getApplicationContext()
            if (isErrorResultToast) Toast.makeText(
                context,
                context.getString(R.string.network_error),
                Toast.LENGTH_SHORT
            ).show()
            CaArtResponse(
                success = false,
                statusCode = e.code(),
                message = e.message()
            )
        }
    }
}