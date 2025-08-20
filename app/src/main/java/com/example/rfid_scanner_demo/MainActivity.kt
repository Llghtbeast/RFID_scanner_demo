package com.example.rfid_scanner_demo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.rfid_scanner_demo.ui.Navigation
import com.example.rfid_scanner_demo.ui.screens.home.HomeScreen
import com.example.rfid_scanner_demo.ui.theme.RFID_scanner_demoTheme
import com.zebra.rfid.api3.ENUM_TRANSPORT
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.ReaderDevice

import com.zebra.rfid.api3.Readers
import com.zebra.rfid.api3.START_TRIGGER_TYPE
import com.zebra.rfid.api3.STOP_TRIGGER_TYPE
import com.zebra.rfid.api3.TriggerInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    private var readers: Readers? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RFID_scanner_demoTheme {
                Surface {
                    Navigation(modifier = Modifier)
                }
            }
        }

        if (readers == null) {
            readers = Readers(this, ENUM_TRANSPORT.SERVICE_SERIAL)
        }

        // Using coroutines (recommended approach)
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    readers?.GetAvailableRFIDReaderList()?.let { readerList ->
                        if (readerList.isNotEmpty()) {
                            // get first reader from list
                            val reader = readerList[0].rfidReader
                            if (!reader.isConnected) {
                                // Establish connection to the RFID Reader
                                reader.connect()
                                configureReader(reader)
                                return@withContext true
                            }
                        }
                    }
                } catch (e: InvalidUsageException) {
                    e.printStackTrace()
                } catch (e: OperationFailureException) {
                    e.printStackTrace()
                    Log.d(TAG, "OperationFailureException ${e.vendorMessage}")
                }
                false
            }

            // This runs on the main thread (equivalent to onPostExecute)
            if (result) {
                Toast.makeText(applicationContext, "Reader Connected", Toast.LENGTH_LONG).show()
                //textView.text = "Reader connected"
            }
        }
    }

    private fun configureReader(reader: RFIDReader) {
        if (reader.isConnected) {
            val triggerInfo = TriggerInfo()
            triggerInfo.StartTrigger.triggerType = START_TRIGGER_TYPE.START_TRIGGER_TYPE_IMMEDIATE
            triggerInfo.StopTrigger.triggerType = STOP_TRIGGER_TYPE.STOP_TRIGGER_TYPE_IMMEDIATE
            try {
                // receive events from reader
                // TODO
            } catch (e: InvalidUsageException) {
                e.printStackTrace()
            } catch (e: OperationFailureException) {
                e.printStackTrace()
            }
        }
    }
}