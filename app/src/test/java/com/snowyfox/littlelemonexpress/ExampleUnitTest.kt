package com.snowyfox.littlelemonexpress

import android.util.Log.i
import com.snowyfox.littlelemonexpress.data.provided_data.menuItems
import com.snowyfox.littlelemonexpress.utility.pipe
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        val list = menuItems.filter { it.category.name.lowercase() == "desserts" }
        list pipe ::println
    }
}
