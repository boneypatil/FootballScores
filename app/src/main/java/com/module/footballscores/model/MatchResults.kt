package com.module.footballscores.model

import java.io.Serializable


data class MatchResults(
    val team_A: String,
    val team_B: String,
    val score_A: String,
    val score_B: String,
    val link_A: String,
    val link_B: String,
    val date: String
):Serializable