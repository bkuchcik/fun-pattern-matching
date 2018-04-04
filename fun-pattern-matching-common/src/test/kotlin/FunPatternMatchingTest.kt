package com.pattern.matching

import kotlin.test.Test
import kotlin.test.asserter

class FunPatternMatchingTest {


    @Test
    fun should_match_expected_match_result() {
        val p = Point(5, 5)
        p.run {
            when {
                x == p.x && distance() > 10 -> println("I love $x")
                else -> println(p)
            }
        }
    }

    @Test
    fun should_match_expected_match_result_twice() {
        val p = ALotOfProperty("s", false, 10L, 5, 42.0)
        p.run {
            when {
            //ALotOfProperty("x", true, 52, _, _)
                s == "x" && b && l == 52L -> println("I love $s")
                else -> println(p)
            }
        }
    }

    @Test
    fun usage_of_when_with_apply() {
        val notification: Notification = Email("sender", "title", "body")
        notification.apply {
            when {
                this is Email && sender.contains("xxxx") -> println("Email from $sender")
                this is SMS -> println("SMS from $caller")
                else -> println(this)
            }
        }
    }

    @Test
    fun usage_of_simple_when() {
        val notification: Notification = Email("sender", "title", "body")
        when (notification) {
            is Email -> notification.apply { println("Email from $sender") }
            is SMS -> println("SMS from ${notification.caller}")
            else -> println(this)
        }
    }
}

data class Point(val x: Int, val y: Int) {
    fun distance() = 0
}

data class ALotOfProperty(val s: String, val b: Boolean, val l: Long, val i: Int, val d: Double)

abstract interface Notification

data class Email(val sender: String, val title: String, val body: String) : Notification

data class SMS(val caller: String, val message: String) : Notification

data class VoiceRecording(val contactName: String, val link: String) : Notification

