package org.prashant.filecollection;

import java.util.Arrays;
import java.util.List;

public class FileProcessorMain {

    public static void main(String[] args) {
        List<FileEntry> files = Arrays.asList(
                new FileEntry("file1.txt", 100L),
                new FileEntry("file2.txt", 200L, Arrays.asList("collection1")),
                new FileEntry("file3.txt", 200L, Arrays.asList("collection1")),
                new FileEntry("file4.txt", 300L, Arrays.asList("collection2")),
                new FileEntry("file5.txt", 100L, Arrays.asList("collection3"))
        );
        FileProcessor obj = new FileProcessor();

        obj.processFiles(files, 2);
    }
}
