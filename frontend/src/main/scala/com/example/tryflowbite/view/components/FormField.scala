package com.example.tryflowbite.view.components

import com.example.tryflowbite.model.Msg
import com.example.tryflowbite.util.ElementIdGenerator
import tyrian.Html
import tyrian.Html.*
import tyrian.Html.attribute as attr

def formField(
                       name: String,
                       _value: String,
                       _onInput: String => Msg ,
                       _type: "password" | "text"
                     ): Html[Msg] =
  val icon = if _type == "password" then Icons.lock else Icons.user
  val _placeholder = if _type == "password" then "••••••••" else ""
  val _id = ElementIdGenerator.generate("login-")
  div()(
    label(`for` := _id, cls := "block mb-2 text-sm font-medium text-gray-900 dark:text-white")(name),
    div(cls := "relative")(
      div(cls := "absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none")(icon),
      input(
        onInput(_onInput),
        id := _id,
        `type` := _type,
        value := _value,
        placeholder := _placeholder,
        cls := "bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full ps-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-500 dark:focus:border-purple-500"
      )
    )
  )
