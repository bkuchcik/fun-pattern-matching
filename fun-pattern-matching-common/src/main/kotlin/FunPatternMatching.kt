package com.pattern.matching

class FunPatternMatching

//val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
//customer1ID match {
//    case CustomerID(name) => println(name)  // prints Sukyoung
//    case _ => println("Could not extract a CustomerID")
//}

fun <T : Any> T.isSameAs(other: T, vararg properties: T.() -> Any): Boolean = properties.all { it() == other.it() }
