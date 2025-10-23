package com.example.tryflowbite.view.components

import com.example.tryflowbite.model.Msg
import tyrian.{Elem, Html}
import tyrian.Html.form
import tyrian.Html.{attribute as attr, *}

def createForm[Msg](children: Elem[Msg]*): Html[Msg] =
  form(cls :="space-y-6", attr("action", "#"))(children:_*)