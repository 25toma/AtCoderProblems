package com.kenkoooo.atcoder.api

import akka.http.scaladsl.model.DateTime
import akka.http.scaladsl.model.headers.`Access-Control-Allow-Origin`
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.kenkoooo.atcoder.db.SqlClient
import com.kenkoooo.atcoder.model.ApiJsonSupport
import com.kenkoooo.atcoder.scraper.AtCoder.UserNameRegex

/**
  * API routes which connect to SQL and provide JSON-formatted API
  *
  * @param sqlClient [[SqlClient]] to connect to SQL
  */
class JsonApi(sqlClient: SqlClient) extends ApiJsonSupport {
  val routes: Route = encodeResponse {
    respondWithDefaultHeader(`Access-Control-Allow-Origin`.*) {
      get {
        pathPrefix("info") {
          conditional(EntityTagger.calculateDateTimeTag(lastUpdated()), lastUpdated()) {
            path("contests") {
              complete(sqlClient.contests.values.toList)
            } ~ path("problems") {
              complete(sqlClient.problems.values.toList)
            } ~ path("ac") {
              complete(sqlClient.acceptedCounts)
            } ~ path("fast") {
              complete(sqlClient.fastestSubmissionCounts)
            } ~ path("first") {
              complete(sqlClient.firstSubmissionCounts)
            } ~ path("short") {
              complete(sqlClient.shortestSubmissionCounts)
            } ~ path("merged-problems") {
              complete(sqlClient.mergedProblems)
            } ~ path("sums") {
              complete(sqlClient.ratedPointSums)
            } ~ path("lang") {
              complete(sqlClient.languageCounts)
            }
          }
        } ~ path("results") {
          parameters('user ? "", 'rivals ? "") { (user, rivals) =>
            val rivalList = rivals.split(",").map(_.trim).toList
            val users = (user :: rivalList).filter(_.length > 0).filter(_.matches(UserNameRegex))

            complete(sqlClient.loadUserSubmissions(users: _*).toList)
          }
        }
      }
    }
  }

  private def lastUpdated(): DateTime = DateTime(sqlClient.lastReloadedTimeMillis)
}
