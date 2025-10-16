package com.example.tryflowbite.util

import tyrian.Cmd
import tyrian.cmds.*
import zio.*
import com.example.tryflowbite.until.HttpHelper
import com.example.tryflowbite.model.Msg
object Authentication {

  def authenticate(username: String, password: String): Cmd[Task, Msg] =
    HttpHelper.login(username, password)
}
