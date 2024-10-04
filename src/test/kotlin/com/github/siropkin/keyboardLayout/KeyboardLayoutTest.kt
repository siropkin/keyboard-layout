import com.github.siropkin.keyboardLayout.KeyboardLayout
import com.github.siropkin.keyboardLayout.KeyboardLayoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class KeyboardLayoutTest {

    @Test
    fun testGetInfoOnWindows() {
        val keyboardLayout = Mockito.mock(KeyboardLayout::class.java)
        val expectedInfo = KeyboardLayoutInfo("en", "US", "00000409")
        Mockito.`when`(keyboardLayout.getInfo()).thenReturn(expectedInfo)

        val info = keyboardLayout.getInfo()
        assertEquals("en", info.language)
        assertEquals("US", info.country)
        assertEquals("00000409", info.variant)
    }

    @Test
    fun testGetInfoOnMac() {
        val keyboardLayout = Mockito.mock(KeyboardLayout::class.java)
        val expectedInfo = KeyboardLayoutInfo("en", "US", "UserDefined_252")
        Mockito.`when`(keyboardLayout.getInfo()).thenReturn(expectedInfo)

        val info = keyboardLayout.getInfo()
        assertEquals("en", info.language)
        assertEquals("US", info.country)
        assertEquals("UserDefined_252", info.variant)
    }

    @Test
    fun testGetInfoOnLinux() {
        val keyboardLayout = Mockito.mock(KeyboardLayout::class.java)
        val expectedInfo = KeyboardLayoutInfo("en", "US", "")
        Mockito.`when`(keyboardLayout.getInfo()).thenReturn(expectedInfo)

        val info = keyboardLayout.getInfo()
        assertEquals("en", info.language)
        assertEquals("US", info.country)
        assertEquals("", info.variant)
    }
}
