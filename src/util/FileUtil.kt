@file:JvmName("FileUtil")

package util

import java.io.File

object FileUtil {
    fun loadFileToList(filePath: String): ArrayList<String> {
        val list = arrayListOf<String>()
        val reader = File(filePath)
        reader.forEachLine { list.add(it) }
        return list
    }
}