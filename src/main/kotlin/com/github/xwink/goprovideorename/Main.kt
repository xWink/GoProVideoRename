package com.github.xwink.goprovideorename

import java.io.File

private val goProVideoNamePattern = "^GH[\\d]{6}.MP4$".toRegex()

fun main() {
    var retry = true
    while (retry) {
        val path = getPath()
        println()

        if (!path.isDirectory) {
            println("\"$path\" is not a directory.")
        } else {
            renameAllFilesInPath(path)
        }

        println("Would you like to rename more files? (y/n)")
        print("> ")
        retry = (readLine() ?: "").lowercase() == "y"
        if (retry) {
            println()
        }
    }
}

fun getPath(): File {
    println("Enter the absolute path to the directory containing videos to rename")
    print("> ")
    return File(readLine() ?: "")
}

fun renameAllFilesInPath(path: File) {
    println("Renaming files found in directory \"$path\".\n")

    val files = path.walkTopDown()
    files.forEach {
        if (it.isFile && it.name.matches(goProVideoNamePattern)) {
            renameFile(it)
        } else if (it.isFile) {
            println("Skipping \"${it.name}\" because it does not match the supported GoPro video naming format.")
        }
    }
}

fun renameFile(file: File) {
    val newFilename = getNewFilename(file.name)
    file.renameTo(File(file.parent + File.separator + newFilename))
    println("Renamed \"${file.name}\" to \"$newFilename\"")
}

// Old Name = GH(01)(116) = GH(subVideoNum)(videoNum)
// New Name = GH(116)(A) = GH(videoNum)(subVideoChar)
fun getNewFilename(oldFilename: String): String {
    val videoNum = oldFilename.substring(4, 8)
    val subVideoNum = oldFilename.substring(2, 4)
    val subVideoChar = ('A'.code + subVideoNum.toInt() - 1).toChar()
    return "GH${videoNum}${subVideoChar}.MP4"
}
