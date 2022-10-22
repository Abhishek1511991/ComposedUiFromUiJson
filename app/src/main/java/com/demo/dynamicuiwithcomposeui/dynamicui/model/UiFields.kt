package com.demo.dynamicuiwithcomposeui.dynamicui.model

import com.google.gson.annotations.SerializedName

data class UiFields (

  @SerializedName("fields" ) var fields : ArrayList<Fields> = arrayListOf(),
  @SerializedName("title"  ) var title  : String?           = null,
  @SerializedName("next"   ) var next   : String?           = null

)