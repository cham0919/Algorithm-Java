package Test.__DH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) throws ParseException {
        Test2 test = new Test2();
        String s = " 779091968 23 Sep 2009 system.zip\n" +
                " 284164096 14 Aug 2013 to-do-list.xml\n" +
                " 714080256 19 Jun 2013 blockbuster.mpeg\n" +
                "       329 12 Dec 2010 notes.html\n" +
                " 444596224 17 Jan 1950 delete-this.zip\n" +
                "       641 24 May 1987 setup.png\n" +
                "    245760 16 Jul 2005 archive.zip\n" +
                " 839909376 31 Jan 1990 library.dll";
        test.solution(s);

    }


    Map<String, String> monthMap;
    SimpleDateFormat format;
    Date minLastModified;
    int minByteSize;
    int result;

    private String solution(String s) {
        try {
            initParam();

            String[] fileArray = s.split("\n");

            for (String fileDate : fileArray) {
                File file = createFile(fileDate);

                if (isLessThanMinByteSize(file)) {
                    continue;
                } else if (isBeforeThanMinLastModified(file)) {
                    continue;
                } else {
                    result++;
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return result == 0 ? "NO FILES" : String.valueOf(result);
    }

    private boolean isBeforeThanMinLastModified(File file) {
        return file.getLastModified().compareTo(minLastModified) <= 0 ? true : false;
    }

    private File createFile(String fileData) throws ParseException {
        String[] fileDataArray = fileData.trim().split(" ");
        fileDataArray[2] = monthMap.get(fileDataArray[2]);
        Date lastModified = format.parse(fileDataArray[1] + " " + fileDataArray[2] + " " + fileDataArray[3]);
        File file = new File().setSize(Integer.valueOf(fileDataArray[0]))
                .setLastModified(lastModified)
                .setName(fileDataArray[3]);

        return file;
    }

    private boolean isLessThanMinByteSize(File file) {
        return file.getSize() < minByteSize;
    }

    private void initParam() throws ParseException {
        format = new SimpleDateFormat ("dd MM yyyy");
        minLastModified = format.parse("31 01 1990");
        minByteSize = 1024 * 240;
        result = 0;
        monthMap = new HashMap();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
    }

    class File {
        int size;
        Date lastModified;
        String name;

        public int getSize() {
            return size;
        }

        public File setSize(int size) {
            this.size = size;
            return this;
        }

        public Date getLastModified() {
            return lastModified;
        }

        public File setLastModified(Date lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public String getName() {
            return name;
        }

        public File setName(String name) {
            this.name = name;
            return this;
        }
    }
}
