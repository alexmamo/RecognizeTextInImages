package ro.alexmamo.recognizetextinimages.core

import android.util.Log
import ro.alexmamo.recognizetextinimages.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception?) = e?.apply {
            Log.e(TAG, stackTraceToString())
        }
    }
}