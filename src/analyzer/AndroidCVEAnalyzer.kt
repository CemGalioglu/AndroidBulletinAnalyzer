@file:JvmName("AndroidCVEAnalyzer")

package analyzer

import util.FileUtil


object AndroidCVEAnalyzer {
    val listAospVersions = arrayOf(
        "9", "8.1", "8.0", "7.1.2", "7.1.1", "7.1", "7.0", "6.0.1", "6.0", "5.1.1", "5.1",
        "5.0.2", "5.0.1", "5.0", "4.4.4", "4.4.3", "4.4.2", "4.4.1", "4.4", "4.3.1", "4.3",
        "4.2.2", "4.2.1", "4.2", "4.1.2", "4.1.1", "4.1", "4.0.4", "4.0.3", "4.0.2", "4.0.1",
        "3.2.6", "3.2.5", "3.2.4", "3.2.3", "3.2.2", "3.2.1", "3.2", "3.1", "3.0", "2.3.7",
        "2.3.6", "2.3.5", "2.3.4", "2.3.3", "2.3.2", "2.3.1", "2.3", "2.2.3", "2.2.2",
        "2.2.1", "2.2", "2.1", "2.0.1", "2.0", "1.6", "1.5", "1.1", "1.0"
    )

    //TODO deal with the following cases -> Android 4.x before 4.4.4, 5.0.x before 5.0.2, 5.1.x before 5.1.1, and 6.x
    //TODO remove dates from description
    //TODO delete/ignore entries that have incorrect formatting.
    //TODO deal with the following cases -> Android 6.x before 2016-09-01 and 7.0 before 2016-09-01
    //TODO Ignore 1.1 if it belongs to a different version like 5.1.1
    fun findEffectedVersions() {
        var counter = 0
        with(FileUtil) {
            val list = loadFileToList(PROJECT_FILE_PATH + "\\data\\android.normalized_data.json")
            for (line in list) {
                if (isLineStartWith(line, "\"_id\"")) {
                      print(line.substring(line.indexOf("C"), line.indexOf(",") - 1) + " ")
                    } else if (isLineStartWith(line, "\"updated_aosp_versions\"")) {
                      println(line.substring(line.indexOf(":")))
                } else if (isLineStartWith(line, "\"description\"")) {
                    counter++
                    if (counter % 2 == 0) {
                        listAospVersions.forEach { aosp ->
                            if (line.contains(aosp)) {
                                print("$aosp ")
                            }
                        }
                        println("")
                    }
                }
            }
        }
    }
}