package com.demo.dynamicuiwithcomposeui

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.demo.dynamicuiwithcomposeui.dynamicui.constants.JsonFormConstants
import com.demo.dynamicuiwithcomposeui.dynamicui.model.Fields
import java.io.IOException

open class ComposeBaseActivity: ComponentActivity() {
    fun loadJSONFromAsset(fileName: String?): String? {
        var json: String? = null
        json = try {
            val `is` = assets.open(fileName!!)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            Log.d("TAG", "Exception Occurred : " + ex.message)
            return null
        }
        return json
    }


    @Composable
    fun TextFactory(textObj: Fields) {
        Text(
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(10.dp),
            text = "${textObj.title}"
        )
    }

    @Composable
    fun EditTextFactory(textObj: Fields) {
        textObj.title?.let {
            TextField(value = it,
            onValueChange = {
                textObj.title=it
            },label = { textObj.title?.let { it1 -> Text(it1) } })
        }
    }

    @Composable
    fun ImageFactory(textObj: Fields) {
        Image(painter = rememberAsyncImagePainter(textObj.url), contentDescription =textObj.title )
    }

    @Composable
    fun CardFactory(textObj: Fields) {
        Card(shape = RoundedCornerShape(8.dp),
             backgroundColor = MaterialTheme.colors.surface,
             modifier = Modifier
                 .width(IntrinsicSize.Max)
                 .padding(all = 10.dp)) {
            Column( modifier = Modifier
                .height(IntrinsicSize.Min)
                .width(IntrinsicSize.Max)
                .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start){
                if(textObj.data.size>0){
                    for(i in 0..textObj.data.size-1){
                        val fieldObj=textObj.data.get(i)
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

    @Composable
    fun ButtonFactory(textObj: Fields) {
        Button(onClick = {  }, shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, Color.Blue)
        ) {
            textObj.title?.let { Text(text = it) }
        }
    }

    @Composable
    fun RedioButtonFactory(textObj: Fields) {
        RadioButton(selected = true, onClick = {

        },mo)
    }

    @Composable
    fun LinearFactory(textObj: Fields) {
        when(textObj.orientation){
            "horizontal" -> {

                Box() {
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    if(textObj.data.size>0){
                        for(i in 0..textObj.data.size-1){
                            val fieldObj=textObj.data.get(i)
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
                            Spacer(modifier = Modifier.size(size = 10.dp))
                        }
                    }

                }

            }}
            "linear" -> {
                Box(modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize()
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically), modifier = Modifier.padding(all = 10.dp)) {
                        if(textObj.data.size>0){
                            for(i in 0..textObj.data.size-1){
                                val fieldObj=textObj.data.get(i)
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
                                Spacer(modifier = Modifier.size(size = 10.dp))
                            }
                        }
                    }
                }

            }
        }
    }



}