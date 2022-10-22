# JsonBasedComposedUi
Design the dynamic ui from the json and render ui component using Composed UI


Usage Json Structure Form json should consist of steps and fields.

Steps Step directly corresponds to a fragment(or a page) in wizard. It consists of different fields(array of fields), title and next step.

{
  "count": "1",
  "step1": {
    "fields": [
      {
        "key": "address",
        "id": "0",
        "type": "card",
        "view_type": "linear",
        "data": [
          {
            "key": "address",
            "type": "label",
            "id": "0_1",
            "text_color": "#424242",
            "text_size": "12",
            "title": "Fischerinsal",
            "bold": "true"
          },
          {
            "key": "address",
            "type": "label",
            "id": "0_2",
            "text_color": "#424242",
            "text_size": "10",
            "title": "Fischerinsal 2,10179 Berlin"
          },
          {
            "key": "address_card",
            "id": "0_3",
            "type": "linear",
            "weight_sum": "3",
            "orientation": "horizontal",
            "data": [
              {
                "key": "name",
                "id": "01",
                "type": "button",
                "title": "Share",
                "url": "https://cdn0.iconfinder.com/data/icons/multimedia-261/32/Send-512.png",
                "icon_position": "left",
                "weight": "1",
                "text_size": "12",
                "text_color": "#424242"
              },
              {
                "key": "name",
                "id": "02",
                "type": "button",
                "title": "Send",
                "url": "https://static.thenounproject.com/png/5194978-200.png",
                "icon_position": "right",
                "weight": "1",
                "text_size": "12",
                "text_color": "#424242"
              },
              {
                "key": "name",
                "id": "03",
                "type": "button",
                "title": "Route",
                "weight": "1",
                "text_size": "12",
                "text_color": "#424242"
              }
            ]
          }
        ]
      }
    ],
    "title": "Step 1 of 3",
    "next": "step2"
  }
}

key - It must be unique in that particular step.

type - It must be edit_text for EditText.

hint - hint for EditText.

value - will be the value present in the editText after completion of wizard

key - must be unique in that particular step.

type - must be label for Label.

text - text for Label.

Add library for own application gradle:

dependencies { implementation lib("dynamicui") }

TODOs Support validation for Checkbox and RadioButton. Improve recylerview adapter as list

Supported Ui Component

EDIT_TEXT = "text"

RADIO_BUTTON = "radio"

LABEL = "label"

CUSTOM_LINEAR_VIEW = "linear"

CUSTOM_BUTTON_VIEW = "button"

CUSTOM_CARD_VIEW = "card"

CUSTOM_IMAGE_VIEW = "image"


License This project is licensed under the MIT License. Please refer the License.txt file.
