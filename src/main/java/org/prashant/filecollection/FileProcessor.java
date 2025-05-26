package org.prashant.filecollection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileProcessor {

    Map<String, Long> collectionSize;
    Long totalSize;

    public FileProcessor() {
        collectionSize = new ConcurrentHashMap<>();
        totalSize=0L;
    }

    public void processFiles(List<FileEntry> fileEntries, int k) {



        for(FileEntry fileEntry: fileEntries) {
            totalSize += fileEntry.size;
            for(String collection: fileEntry.collections) {
                collectionSize.put(collection, collectionSize.getOrDefault(collection, 0L)+ fileEntry.size);
//                collectionSize.merge()
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingLong(collectionSize::get));

        for(String collection: collectionSize.keySet()) {
            pq.add(collection);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        System.out.println("Total file size "+totalSize);

        System.out.println("k biggest collections");
        while(k-->0) {
            String coll = pq.poll();
            System.out.println(coll +" " + collectionSize.get(coll));
        }
    }
}
