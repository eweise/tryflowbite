package com.example.tryflowbite

import tyrian.Cmd
import tyrian.Html
import tyrian.Html.div
import java.util.UUID
import tyrian.cmds.Logger
import zio.*
import zio.interop.catz.*
import com.example.tryflowbite.util.PrettyLogger
import com.example.tryflowbite.view.pages.LoginPage
import com.example.tryflowbite.until.HttpHelper
import com.example.tryflowbite.model.*
import com.example.tryflowbite.view.pages.*

package object page {
  enum Page(
    val path: String,
    val render: Model => Html[Msg],
    beforeEnter: Model => Cmd[Task, Msg] = _ => Cmd.None, // e.g: side effect for loading data
    val isSecured: Boolean = true
  ):
    def doNavigate(model: Model): Cmd[Task, Msg] = beforeEnter(model) |+| Cmd.emit(Msg.DoNavigate(this))

    case Login      extends Page("/login", model => LoginPage(model.loginForm), isSecured = false)
    case Home       extends Page("/", model => Welcome(model.homeState), _ => HttpHelper.fetchServerMessage)
    case Alerts     extends Page("/components/alerts", model => AlertsView(), _ => PrettyLogger.info("Entering Alerts page"))
    case Accordion  extends Page("/components/accordion", model => AccordionView(), _ => PrettyLogger.info("Entering Accordion page"))
    case Buttons    extends Page("/components/buttons", model => ButtonsView(), _ => PrettyLogger.info("Entering Buttons page"))
    case Toggle     extends Page("/components/toggle", model => ToggleView(), _ => PrettyLogger.info("Entering Toggle page"))
    case Datepicker extends Page("/components/datepicker", model => DatepickerView(), _ => PrettyLogger.info("Entering Datepicker page"))
    case Badges     extends Page("/components/badges", model => BadgesView(), _ => PrettyLogger.info("Entering Badges page"))
    case Cards      extends Page("/components/cards", model => CardsView(), _ => PrettyLogger.info("Entering Cards page"))
    case Carousel   extends Page("/components/carousel", model => CarouselView(), _ => PrettyLogger.info("Entering Carousel page"))
    case Test       extends Page("/components/test", model => TestView(), _ => PrettyLogger.info("Entering Test page"))
}
