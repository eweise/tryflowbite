package com.example.tryflowbite.app

import com.example.tryflowbite.config.AppConfig
import com.example.tryflowbite.http.DefaultRoutes.*
import com.example.tryflowbite.service.JWTIssuer
import com.example.tryflowbite.service.JWTVerifier
import com.example.tryflowbite.services.RandomQuotes
import zio.*
import zio.Console.*
import zio.http.*
import zio.logging.backend.SLF4J

object Main extends ZIOAppDefault {

  override def run =
    Server
      .serve(public ++ authenticated)
      .provide(
        Server.defaultWithPort(8080),
        JWTVerifier.live,
        JWTIssuer.live,
        AppConfig.live,
        RandomQuotes.live
      )

  override val bootstrap: ZLayer[ZIOAppArgs, Any, Any] =
    Runtime.removeDefaultLoggers >>> SLF4J.slf4j

}
