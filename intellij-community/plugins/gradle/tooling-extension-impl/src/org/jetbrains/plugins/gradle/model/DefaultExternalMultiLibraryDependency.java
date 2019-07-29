// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.plugins.gradle.model;

import org.gradle.internal.impldep.com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;

import static com.intellij.util.containers.ContainerUtilRt.map2List;
import static org.jetbrains.plugins.gradle.tooling.util.FunctionUtils.FILE_TO_PATH;

public final class DefaultExternalMultiLibraryDependency extends AbstractExternalDependency implements ExternalMultiLibraryDependency {
  private static final long serialVersionUID = 1L;
  private final Collection<File> files;
  private final Collection<File> sources;
  private final Collection<File> javadocs;

  public DefaultExternalMultiLibraryDependency() {
    files = new LinkedHashSet<File>(0);
    sources = new LinkedHashSet<File>(0);
    javadocs = new LinkedHashSet<File>(0);
  }

  public DefaultExternalMultiLibraryDependency(ExternalMultiLibraryDependency dependency) {
    super(dependency);
    files = dependency.getFiles();
    sources = dependency.getSources();
    javadocs = dependency.getJavadoc();
  }

  @NotNull
  @Override
  public Collection<File> getFiles() {
    return files;
  }

  @NotNull
  @Override
  public Collection<File> getSources() {
    return sources;
  }

  @NotNull
  @Override
  public Collection<File> getJavadoc() {
    return javadocs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DefaultExternalMultiLibraryDependency)) return false;
    if (!super.equals(o)) return false;
    DefaultExternalMultiLibraryDependency that = (DefaultExternalMultiLibraryDependency)o;
    return map2List(files, FILE_TO_PATH).equals(map2List(that.files, FILE_TO_PATH));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), map2List(files, FILE_TO_PATH));
  }

  @Override
  public String toString() {
    return "library '" + files + '\'' + super.toString();
  }
}
