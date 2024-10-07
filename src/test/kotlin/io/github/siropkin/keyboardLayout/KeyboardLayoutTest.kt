package io.github.siropkin.keyboardLayout

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.mockito.Mockito
import java.awt.im.InputContext

class KeyboardLayoutTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    fun testGetWindowsKeyboardLayout() {
        val keyboardLayout = Mockito.spy(KeyboardLayout())
        Mockito.doReturn("00000409").`when`(keyboardLayout).executeNativeCommand(arrayOf("some", "command"))

        val info = keyboardLayout.getInfo()
        assertEquals("en", info.language)
        assertEquals("US", info.country)
        assertEquals("US", info.variant)
    }

    @Test
    @EnabledOnOs(OS.MAC)
    fun testGetMacKeyboardLayout() {
        val keyboardLayout = KeyboardLayout()
        val inputContext = Mockito.mock(InputContext::class.java)
        Mockito.`when`(inputContext.locale).thenReturn(java.util.Locale("en", "US", "UserDefined_com.sogou.inputmethod.pinyin"))

        val info = keyboardLayout.getInfo()
        assertEquals("en", info.language)
        assertEquals("US", info.country)
        assertEquals("ZH", info.variant)
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    fun testGetLinuxKeyboardLayout() {
        val keyboardLayout = Mockito.spy(KeyboardLayout())
        Mockito.doReturn("us").`when`(keyboardLayout).executeNativeCommand(arrayOf("setxkbmap", "-query"))

        val info = keyboardLayout.getInfo()
        assertEquals("", info.language)
        assertEquals("us", info.country)
        assertEquals("", info.variant)
    }
}
