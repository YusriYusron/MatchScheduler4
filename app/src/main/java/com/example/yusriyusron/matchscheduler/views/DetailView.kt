package com.example.yusriyusron.matchscheduler.views

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.yusriyusron.matchscheduler.api.ApiRepository
import com.example.yusriyusron.matchscheduler.api.TheSportDBApi
import com.example.yusriyusron.matchscheduler.models.Match
import com.example.yusriyusron.matchscheduler.models.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.*

class DetailView : AppCompatActivity() {
    private lateinit var homeTeamBadge: ImageView
    private lateinit var awayTeamBadge: ImageView
    private lateinit var homeTeamName: TextView
    private lateinit var awayTeamName: TextView
    private lateinit var homeTeamScore: TextView
    private lateinit var awayTeamScore: TextView
    private lateinit var homeRedCard: TextView
    private lateinit var awayRedCard: TextView
    private lateinit var homeYellowCard: TextView
    private lateinit var awayYellowCard: TextView
    private lateinit var homeTeamGoals: TextView
    private lateinit var awayTeamGoals: TextView
    private lateinit var homeTeamShoot: TextView
    private lateinit var awayTeamShoot: TextView
    private lateinit var homeTeamKeeper: TextView
    private lateinit var awayTeamKeeper: TextView
    private lateinit var homeTeamDefense: TextView
    private lateinit var awayTeamDefense: TextView
    private lateinit var homeTeamMidfield: TextView
    private lateinit var awayTeamMidfield: TextView
    private lateinit var homeTeamForward: TextView
    private lateinit var awayTeamForward: TextView
    private lateinit var homeTeamSubtitutes: TextView
    private lateinit var awayTeamSubtitutes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)
            scrollView {
                lparams(width = matchParent, height = matchParent)
                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    lparams(width = matchParent, height = matchParent)
                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL
                        linearLayout {
                            lparams(width = dip(0), height = wrapContent, weight = 4f)
                            leftPadding = dip(10)
                            orientation = LinearLayout.VERTICAL
                            gravity = Gravity.CENTER
                            homeTeamBadge = imageView().lparams(width = dip(80), height = dip(80))
                            homeTeamName = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER
                                bottomPadding = 70
                            }

                        }
                        linearLayout {
                            gravity = Gravity.CENTER
                            lparams(width = dip(0), height = wrapContent, weight = 3f)
                            orientation = LinearLayout.HORIZONTAL

                            // Home Team Score
                            homeTeamScore = textView {
                                gravity = Gravity.CENTER
                                padding = dip(10)
                                textSize = 30f
                            }.lparams(width = dip(0), height = wrapContent, weight = 1f)
                            textView {
                                gravity = Gravity.CENTER
                                text = " VS "
                            }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                            //Away Team Score
                            awayTeamScore = textView {
                                gravity = Gravity.CENTER
                                padding = dip(10)
                                textSize = 30f
                            }.lparams(width = dip(0), height = wrapContent, weight = 1f)
                        }
                        linearLayout {
                            gravity = Gravity.CENTER
                            rightPadding = dip(10)
                            lparams(width = dip(0), height = wrapContent, weight = 4f)
                            orientation = LinearLayout.VERTICAL

                            // Away Team Badge
                            awayTeamBadge = imageView().lparams(width = dip(80), height = dip(80))
                            awayTeamName = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER
                            }
                        }
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Team Goals
                        homeTeamGoals = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Goals"
                            gravity = Gravity.CENTER
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Teasm Goals
                        awayTeamGoals = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Team Shoot
                        homeTeamShoot = textView {
                            gravity = Gravity.CENTER
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Shoots"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Shoot
                        awayTeamShoot = textView {
                            gravity = Gravity.CENTER
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Team Shoot
                        homeRedCard = textView {
                            gravity = Gravity.CENTER
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Red Card"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Shoot
                        awayRedCard = textView {
                            gravity = Gravity.CENTER
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Team Shoot
                        homeYellowCard = textView {
                            gravity = Gravity.START
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Yellow Card"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Shoot
                        awayYellowCard = textView {
                            gravity = Gravity.END
                            textSize = 16f
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    textView {
                        text = "Lineups"
                        gravity = Gravity.CENTER_HORIZONTAL
                        textSize = 20f
                        topPadding = 50
                        bottomPadding = 50
                        textColor = Color.BLACK
                    }.lparams(width = matchParent, height = wrapContent)
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Goal Keeper
                        homeTeamKeeper = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Goal Keeper"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Goal Keeper
                        awayTeamKeeper = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        //Home Defense
                        homeTeamDefense = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Defense"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Defense
                        awayTeamDefense = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        // Home Team Midfield
                        homeTeamMidfield = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Midfield"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Midfield
                        awayTeamMidfield = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        //Home Team Forward
                        homeTeamForward = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Forward"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Forward
                        awayTeamForward = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                    linearLayout {
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        //Home Team Subtitutes
                        homeTeamSubtitutes = textView {
                            gravity = Gravity.START
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        textView {
                            text = "Subtitutes"
                            gravity = Gravity.CENTER
                            textSize = 16f
                            topPadding = 50
                        }.lparams(width = dip(0), height = wrapContent, weight = 1f)

                        // Away Team Subtitutes
                        awayTeamSubtitutes = textView {
                            gravity = Gravity.END
                        }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                    }
                }
            }
        }

        val intent = intent
        val match = intent.getParcelableExtra<Match>("match")
        if (match.idAwayTeam != null) {
            loadATeam(match.idAwayTeam, "away")
            loadATeam(match.idHomeTeam, "home")
        }

        awayTeamName.text = match.awayTeam
        homeTeamName.text = match.homeTeam

        if (match != null) {
            homeTeamGoals.text = match.homeGoalDetail
            awayTeamGoals.text = match.awayGoalDetail

            homeTeamScore.text = match.homeScore
            awayTeamScore.text = match.awayScore

            homeTeamShoot.text = match.homeShots
            awayTeamShoot.text = match.awayShots

            homeRedCard.text = match.homeRedCard
            awayRedCard.text = match.awayRedCard

            homeYellowCard.text = match.homeYellowCard
            awayYellowCard.text = match.awayYellowCard

            homeTeamKeeper.text = match.homeGoalkeeper
            awayTeamKeeper.text = match.awayGoalkeeper

            homeTeamDefense.text = match.homeDefense
            awayTeamDefense.text = match.awayDefense

            homeTeamMidfield.text = match.homeMidfield
            awayTeamMidfield.text = match.awayMidfield

            homeTeamForward.text = match.homeForward
            awayTeamForward.text = match.awayForward

            homeTeamSubtitutes.text = match.homeSubstitutes
            awayTeamSubtitutes.text = match.awaySubstitutes
        }
    }

    fun loadATeam(idTeam: String?, type: String) {
        val request = ApiRepository()
        val gson = Gson()
        doAsync {
            val data = gson.fromJson(
                request.doRequest(TheSportDBApi.getATeam(idTeam)),
                TeamResponse::class.java
            )
            uiThread {
                val team = data.teams
                val imageView = if (type.equals("home")) {
                    homeTeamBadge
                } else {
                    awayTeamBadge
                }
                Glide.with(applicationContext).load(team.get(0).teamBadge).into(imageView)
            }
        }
    }
}