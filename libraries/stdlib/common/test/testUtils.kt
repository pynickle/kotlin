/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package test

public expect fun assertTypeEquals(expected: Any?, actual: Any?)

internal expect fun String.removeLeadingPlusOnJava6(): String

internal expect inline fun testOnNonJvm6And7(f: () -> Unit)

// When decoding utf-8, JVM and JS implementations replace the sequence reflecting a surrogate code point differently.
// JS replaces each byte of the sequence by the replacement char, whereas JVM replaces the whole sequence with a single replacement char.
// See corresponding actual to find out the replacement.
internal expect val surrogateCodePointDecoding: String

// The byte sequence used to replace a surrogate char.
// JVM default replacement sequence consist of single 0x3F byte.
// JS and Native replacement byte sequence is [0xEF, 0xBF, 0xBD].
internal expect val surrogateCharEncoding: ByteArray