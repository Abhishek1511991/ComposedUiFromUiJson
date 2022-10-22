package com.demo.dynamicuiwithcomposeui.dynamicui.model

import com.google.gson.annotations.SerializedName


data class Fields(

  @SerializedName("key") var key: String? = null,
  @SerializedName("id") var id: String? = null,
  @SerializedName("type") var type: String? = null,
  @SerializedName("title") var title: String? = null,
  @SerializedName("text_color") var text_color: String? = null,
  @SerializedName("orientation") var orientation: String? = null,
  @SerializedName("weight_sum") var weight_sum: Int? = null,
  @SerializedName("text_size") var text_size: String? = null,
  @SerializedName("bold") var bold: String? = null,
  @SerializedName("background_color") var background_color: String? = null,
  @SerializedName("image_left") var image_left: String? = null,
  @SerializedName("image_right") var image_right: String? = null,
  @SerializedName("text") var text: String? = null,
  @SerializedName("url") var url: String? = null,
  @SerializedName("hint") var hint: String? = null,
  @SerializedName("view_type") var viewType: String? = null,
  @SerializedName("data") var data: ArrayList<Fields> = arrayListOf()

)