package com.pattern.matching

import kotlin.test.Test
import kotlin.test.asserter

class FunPatternMatchingTest {


    @Test
    fun should_match_expected_match_result() {
        asserter.assertEquals("not maching expected", "ok", "ko")
    }
}