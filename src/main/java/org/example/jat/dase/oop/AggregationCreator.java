package org.example.jat.dase.oop;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
2. Create composition and aggregation example.

Aggregation.

The relationship between MusicAlbum and MusicRecord in my example is an aggregation.

Each MusicAlbum contains a list of MusicRecord objects,
but the MusicRecord objects can exist independently of any MusicAlbum.

Additionally, a single MusicRecord can be part of multiple MusicAlbum objects,
which further supports the aggregation relationship.

Here is a UML class diagram that represents the aggregation relationship between MusicAlbum and MusicRecord

+----------------------------------------+          0..*        +----------------------+
|  MusicAlbum                            |----------------------|  MusicRecord         |
+----------------------------------------+                       +---------------------+
| - name: String                         |                      | - name: String       |
| - records: List<MusicRecord>           |                      | - author: String     |
|                                        |                      | - releasedYear: int  |
+----------------------------------------+                      +----------------------+
| + addRecord(record: MusicRecord): void |
| + getRecords(): List<MusicRecord>      |
+----------------------------------------+

 */
public class AggregationCreator {
    private static final Logger log = LoggerFactory.getLogger(AggregationCreator.class);

    public static void main(String[] args) {
        MusicRecord song1 = new MusicRecord("Song 1", "Madonna", 2015);
        MusicRecord song2 = new MusicRecord("Song 2", "Lady Gaga", 2015);
        MusicRecord song3 = new MusicRecord("Song 3", "Madonna", 2015);

        MusicAlbum madonnaAlbum = new MusicAlbum("Madonna songs of 2015");
        madonnaAlbum.addRecord(song1);
        madonnaAlbum.addRecord(song3);
        printMusicAlbumInfo(madonnaAlbum);

        MusicAlbum hitsAlbum = new MusicAlbum("Music hits of 2015");
        hitsAlbum.addRecord(song1);
        hitsAlbum.addRecord(song2);
        hitsAlbum.addRecord(song3);
        printMusicAlbumInfo(hitsAlbum);
    }

    private static void printMusicAlbumInfo(MusicAlbum musicAlbum) {
        log.info("Album: {}", musicAlbum);
    }

    @Data
    @AllArgsConstructor
    static class MusicRecord {
        private String name;
        private String author;
        private int releasedYear;

        @Override
        public String toString() {
            return author + ", " + name + ", " + releasedYear;
        }
    }

    @Data
    static class MusicAlbum {
        private String name;
        /*
         The MusicAlbum class has a list of MusicRecord objects,
         but the MusicRecord objects can exist independently of any MusicAlbum.
         */
        private List<MusicRecord> musicRecords;

        public MusicAlbum(String name) {
            this.name = name;
            this.musicRecords = new ArrayList<>();
        }

        public void addRecord(MusicRecord musicRecord) {
            this.musicRecords.add(musicRecord);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name + ": \n");
            for (MusicRecord record : musicRecords) {
                sb.append("  - ").append(record.toString()).append("\n");
            }
            return sb.toString();
        }
    }
}
