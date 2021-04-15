@file:Suppress("FunctionName")

package org.jetbrains.kotlin.library

fun UnresolvedLibrary(path: String, libraryVersion: String?): ExplicitUnresolvedLibrary =
    ExplicitUnresolvedLibrary(path, libraryVersion)

sealed class UnresolvedLibrary {
    abstract val path: String
    abstract val libraryVersion: String?
    abstract fun substitutePath(newPath: String): UnresolvedLibrary
}

data class ExplicitUnresolvedLibrary(
    override val path: String,
    override val libraryVersion: String?
) : UnresolvedLibrary() {
    override fun substitutePath(newPath: String): ExplicitUnresolvedLibrary {
        return copy(path = newPath)
    }
}

data class ManifestUnresolvedLibrary(
    override val path: String,
    override val libraryVersion: String?
) : UnresolvedLibrary() {
    override fun substitutePath(newPath: String): ManifestUnresolvedLibrary {
        return copy(path = newPath)
    }
}
