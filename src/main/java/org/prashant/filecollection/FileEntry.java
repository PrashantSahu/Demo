package org.prashant.filecollection;

import java.util.ArrayList;
import java.util.List;

public class FileEntry {

    String name;
    Long size;
    List<String> collections;

    FileEntry(String name, Long size, List<String> collections) {
        this.name = name;
        this.size = size;
        this.collections = collections;
    }

    FileEntry(String name, Long size) {
        this.name = name;
        this.size = size;
        this.collections = new ArrayList<>();
    }
}
