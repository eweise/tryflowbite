package com.example.tryflowbite.view.pages

import com.example.tryflowbite.model.Msg
import com.example.tryflowbite.view.components.Col.StringCol
import com.example.tryflowbite.view.components.{Button, Row, TableComponent, TableModel}
import tyrian.Html
import tyrian.Html.{cls, div, span, text}

object TestView:
  val sampleTableModel = TableModel(
    name = "sample table",
    colHeaders = List("Header 1", "Header 2"),
    rows = List(
      Row(cols = List(StringCol("value 1"), StringCol("value 2"))),
      Row(cols = List(StringCol("value 3"), StringCol("value 4"))),
      Row(cols = List(StringCol("value 5"), StringCol("value 6"))),
    )
  )

  def apply(): Html[Msg] = div(cls := "flex flex-col space-around  max-w-full p-6")(
    span(text("Test View")),
    div()(
      Button.alternative("Alt", Msg.NoOp),
      TableComponent(sampleTableModel)
    )
  )
