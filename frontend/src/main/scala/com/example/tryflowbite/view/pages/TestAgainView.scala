package com.example.tryflowbite.view.pages

import com.example.tryflowbite.model.{Model, Msg}
import com.example.tryflowbite.view.components.Col.StringCol
import com.example.tryflowbite.view.components.*
import com.example.tryflowbite.view.pages.TestAgainView.TestAgainMsg.{Decrement, Increment}
import tyrian.{Cmd, Html}
import tyrian.Html.{attribute as attr, *}
import zio.Task

object TestAgainView:

  case class TestAgainModel(counter: Int)

  enum TestAgainMsg:
    case Increment
    case Decrement

  def apply(model: TestAgainModel): Html[TestAgainMsg] = div(cls := "flex flex-col space-around  max-w-full p-6")(
    span(text("Test Again View")),
    div()(
      Button.alternative("Increment", TestAgainMsg.Increment),
      Button.alternative("Decrement", TestAgainMsg.Decrement),
      text("counter = " + model.counter)
    )
  )

  def update(model: TestAgainModel): TestAgainMsg => (TestAgainModel, Cmd[Task, TestAgainMsg]) = {
    case Increment => (model.copy(counter = model.counter + 1), Cmd.None)
    case Decrement => (model.copy(counter = model.counter - 1), Cmd.None)
  }
