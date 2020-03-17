@file:JvmName("FileUtil")

package util

import java.io.File

object FileUtil {
    const val PROJECT_FILE_PATH = "C:\\Users\\Cem\\Documents\\SecurityProject"

    fun loadFileToList(filePath: String): ArrayList<String> {
        val list = arrayListOf<String>()
        val reader = File(filePath)
        reader.forEachLine { list.add(it) }
        return list
    }

    fun isLineStartWith(line : String, target : String ) = line.trim().startsWith(target)
}