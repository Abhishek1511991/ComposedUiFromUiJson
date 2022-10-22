package com.demo.dynamicuiwithcomposeui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.dynamicuiwithcomposeui.dynamicui.constants.JsonFormConstants
import com.demo.dynamicuiwithcomposeui.dynamicui.model.JsonMainObject
import com.demo.dynamicuiwithcomposeui.ui.theme.DynamicUiWithComposeUITheme
import com.google.gson.Gson

class MainActivity : ComposeBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicUiWithComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.padding(all = 10.dp)) {
                        val mjson: String?
                        if (savedInstanceState == null) {
                            mjson = loadJSONFromAsset( "data.json")
                        } else {
                            mjson = savedInstanceState.getString("jsonState")
                        }

                        val json=  Gson().fromJson(mjson, JsonMainObject::class.java)
                        Log.e("model",json.toString())
                        if(!json.step1.fields.isEmpty()){
                            val data=json.step1.fields
                            for(i in 0..data.size-1){
                                val fieldObj=data.get(i)
                                when(fieldObj.type){
                                    JsonFormConstants.EDIT_TEXT-> {
                                        EditTextFactory(textObj = fieldObj)
                                    }
                                    JsonFormConstants.LABEL-> {
                                        TextFactory(textObj = fieldObj)
                                    }
                                    JsonFormConstants.CUSTOM_IMAGE_VIEW-> {
                                        ImageFactory(textObj = fieldObj)
                                    }
                                    JsonFormConstants.CUSTOM_CARD_VIEW-> {
                                        CardFactory(textObj = fieldObj)
                                    }
                                    JsonFormConstants.CUSTOM_BUTTON_VIEW-> {
                                        ButtonFactory(textObj = fieldObj)
                                    }
                                    JsonFormConstants.CUSTOM_LINEAR_VIEW-> {
                                        LinearFactory(textObj = fieldObj)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DynamicUiWithComposeUITheme {
        Greeting("Android")
    }
}